package com.bsxy.teaching.service;

import com.bsxy.teaching.dao.TStudentDao;
import com.bsxy.teaching.pojo.TStudent;
import com.bsxy.teaching.pojo.TTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TStudentService
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Service
public class TStudentService {
    @Autowired
    private TStudentDao tStudentDao;

    public List<TTeacher> selectStudent(String page, String limit, String studentName) {
        int curr = Integer.parseInt(page);
        int limits = Integer.parseInt(limit);
        curr = (curr-1)*limits;
        return tStudentDao.selectStudent(curr,limits,studentName);
    }

    public Integer selectStudentCount(String studentName) {
        return tStudentDao.selectStudentCount(studentName);
    }

    public Integer changeStudent(TStudent tStudent) {
        return  tStudentDao.changeStudent(tStudent);
    }
}
