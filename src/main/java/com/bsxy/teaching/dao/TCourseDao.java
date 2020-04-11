package com.bsxy.teaching.dao;

import com.bsxy.teaching.mapper.TCourseMapper;
import com.bsxy.teaching.pojo.TCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName TCourseDao
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Repository
public class TCourseDao {
    @Autowired
    private TCourseMapper tCourseMapper;

    public List<TCourse> selectCourseName(int curr, int limits, String courseName) {
        return tCourseMapper.selectCourse(curr,limits,courseName);
    }

    public Integer selectCountCourse(String courseName) {
        return tCourseMapper.selectCountCourse(courseName);
    }

    public Integer addCourse(TCourse tCourse) {
        return tCourseMapper.insertSelective(tCourse);
    }
}
