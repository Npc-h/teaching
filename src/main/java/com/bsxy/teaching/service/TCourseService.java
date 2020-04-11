package com.bsxy.teaching.service;

import com.bsxy.teaching.dao.TCourseDao;
import com.bsxy.teaching.pojo.TCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TCourseService
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Service
public class TCourseService {
    @Autowired
    private TCourseDao tCourseDao;


    public List<TCourse> selectCourseName(String page, String limit, String courseName) {
        int curr = Integer.parseInt(page);
        int limits = Integer.parseInt(limit);
        curr = (curr-1)*limits;
        return tCourseDao.selectCourseName(curr,limits,courseName);
    }

    public Integer selectCountCourse(String courseName) {
        return tCourseDao.selectCountCourse(courseName);
    }

    public Integer addCourse(TCourse tCourse) {
       return tCourseDao.addCourse(tCourse);
    }
}
