package com.weke.provider.mapper;

import com.weke.provider.domain.Course;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CourseMapper {

    @Select("select * from course")
    public List<Course> getCourse();

    /**
     * 投影课程难度
     * @return
     */
    @Select("select distinct(course_diff) from course")
    public List<String> getCourseDiff();

    /**
     * 方向详情查询
     * @param courseDiff
     * @param directionId
     * @return
     */
    @SelectProvider(type = CourseBuilder.class , method = "getCourseByDiff")
    public List<Course> getCourseByDiffAndDirection(@Param("courseDiff") String courseDiff,
                                                  @Param("directionId") Integer directionId);

    class CourseBuilder{
        public String getCourseByDiff(@Param("courseDiff") final String courseDiff,
                                      @Param("directionId") final Integer directionId){
            String sql = new SQL(){{
                SELECT("C.course_id,C.course_name,C.course_info");
                SELECT("C.course_time,C.course_people,C.course_diff");
                SELECT("C.direction_id,C.course_kind,C.course_level,C.must_know");
                FROM("course C");
                WHERE("C.direction_id = #{directionId}");
                if (!courseDiff.equals("all")) {
                    WHERE("C.course_diff = #{courseDiff}");
                }

            }}.toString();
            return sql;
        }
    }

    @Select("select * from course where course_name = #{courseName}")
    Course getByCourseName(@Param("courseName") String courseName);

    @Insert("insert into course(course_name, course_info, course_time, course_people,course_diff, direction_id, course_level, must_know)" +
            "values(#{courseName}, #{courseInfo}, #{courseTime}, #{coursePeople}, #{courseDiff}, #{directionId}, #{courseLevel}, #{mustKnow})")
    @Options(useGeneratedKeys=true, keyProperty="courseId")
    Integer saveCourse(Course course);

    // 获得所有课程
    @Select("select * from course where 1 =1")
    List<Course> getAllCourses();

    @Select("select * from course where course_id=#{id}")
    Course getCourseById(Integer id);
}
