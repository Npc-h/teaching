package com.bsxy.teaching.service;

import com.bsxy.teaching.dao.TTeacherDao;
import com.bsxy.teaching.pojo.TTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TTeacherService
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Service
public class TTeacherService {
    @Autowired
    private TTeacherDao tTeacherDao;

    public List<TTeacher> selectAllTeacher() {
        return tTeacherDao.selectAllTeacher();
    }

    public List<TTeacher> selectTeacher(String page, String limit, String teacherName) {
        int curr = Integer.parseInt(page);
        int limits = Integer.parseInt(limit);
        curr = (curr-1)*limits;
        return tTeacherDao.selectTeacher(curr,limits,teacherName);
    }

    public Integer selectCountTeacher(String teacherName) {
        return tTeacherDao.selectCountTeacher(teacherName);
    }
}
