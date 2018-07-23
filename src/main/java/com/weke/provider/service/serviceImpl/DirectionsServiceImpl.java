package com.weke.provider.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.weke.provider.domain.Course;
import com.weke.provider.domain.Direction;
import com.weke.provider.mapper.CourseMapper;
import com.weke.provider.mapper.DirectionMapper;
import com.weke.provider.service.DirectionsService;
import com.weke.provider.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Component
public class DirectionsServiceImpl implements DirectionsService {

    @Autowired
    private DirectionMapper directionMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<DirectionVo> getDirection() {
        List<DirectionVo> directionVos =new ArrayList<>();

        List<Direction> directions = directionMapper.getAll();
        List<String> nameList = directionMapper.getDirectionName();

        for (String name : nameList) {
            DirectionVo directionVo = new DirectionVo();
            directionVo.setDirectionName(name);

            List<TecDetailVo> tecDetailVoList = new ArrayList<>();
            for (Direction direction : directions) {
                if (direction.getDirectionName().equals(name)) {
                    TecDetailVo tecDetailVo = new TecDetailVo();
                    tecDetailVo.setCatalogName(direction.getCatalogName());
                    tecDetailVo.setDirectionName(direction.getDirectionName());
                    tecDetailVo.setUrl("");
                    tecDetailVoList.add(tecDetailVo);
                }
            }

            directionVo.setTecDetailVoList(tecDetailVoList);
            directionVos.add(directionVo);
        }
        return directionVos;
    }

    @Override
    public DirectionDetailsVo getDirectionDetails(String directionName, String catalogName, String courseDiff) {
        DirectionDetailsVo directionDetailsVos = new DirectionDetailsVo();

        List<Direction> directions = directionMapper.getDetailsDirection(directionName,catalogName);
        List<String> directionNameList = directionMapper.getDirectionName();
        List<Direction_vo> direction_voList = new ArrayList<>();

        List<Direction> directionList = directionMapper.getDirectionByDirection(directionName);

        if (directionName.equals("all")) {
            for (String name : directionNameList) {
                Direction_vo direction_vo = new Direction_vo();
                List<String> catalogList = new ArrayList<>();
                for (Direction direction : directions) {
                    if (direction.getDirectionName().equals(name)) {
                        catalogList.add(direction.getCatalogName());
                    }
                }
                direction_vo.setCatalogList(catalogList);
                direction_vo.setDirectionName(name);
                direction_voList.add(direction_vo);
            }
        } else {
            for (String name : directionNameList) {
                Direction_vo direction_vo = new Direction_vo();
                List<String> catalogList = new ArrayList<>();
                if (name.equals(directionName)) {
                    for (Direction direction : directionList) {
                        if (direction.getDirectionName().equals(name)) {
                            catalogList.add(direction.getCatalogName());
                            //System.out.println("catalogName:"+ direction.getCatalogName());
                        }
                    }
                }
                direction_vo.setCatalogList(catalogList);
                direction_vo.setDirectionName(name);
                direction_voList.add(direction_vo);
            }
        }

        directionDetailsVos.setDirection_vo(direction_voList);

        List<String> diff = courseMapper.getCourseDiff();
        directionDetailsVos.setCourseDiff(diff);

        Set<Integer> idSet = new HashSet<>();
        //获取课程信息
        for (Direction direction : directions) {
            idSet.add(direction.getDirectionId());
//            System.out.println(direction.getDirectionId());
        }

        List<CourseVo> courseVos = new ArrayList<>();
        for (Integer id : idSet) {
            //System.out.println("id="+id);
            List<Course> courseList = courseMapper.getCourseByDiffAndDirection(courseDiff,id);
            for (Course course : courseList) {
                CourseVo courseVo = new CourseVo();
                courseVo.setCourseName(course.getCourseName());
                courseVo.setCourseKind(course.getCourseKind());
                courseVo.setCourseDiff(course.getCourseDiff());
                courseVo.setCoursePeople(course.getCoursePeople());
                courseVo.setCourseLevel(course.getCourseLevel());
                courseVos.add(courseVo);
            }
        }
        directionDetailsVos.setCourseVos(courseVos);

        return directionDetailsVos;
    }
}
