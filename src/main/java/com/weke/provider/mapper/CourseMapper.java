package com.weke.provider.mapper;

import com.weke.provider.domain.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
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
                SELECT("C.direction_id,C.course_kind,C.course_level");
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
}
