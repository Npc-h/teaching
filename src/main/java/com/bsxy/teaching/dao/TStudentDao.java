package com.bsxy.teaching.dao;

import com.bsxy.teaching.mapper.TStudentMapper;
import com.bsxy.teaching.pojo.TStudent;
import com.bsxy.teaching.pojo.TTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName TStudentDao
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Repository
public class TStudentDao {
    @Autowired
    private TStudentMapper tStudentMapper;

    public void registerUser(TStudent tStudent) {
        tStudentMapper.insertSelective(tStudent);
    }

    public List<TTeacher> selectStudent(int curr, int limits, String studentName) {
        return tStudentMapper.selectStudent(curr,limits,studentName);
    }

    public Integer selectStudentCount(String studentName) {
        return tStudentMapper.selectStudentCount(studentName);
    }

    public Integer changeStudent(TStudent tStudent) {
        return tStudentMapper.updateByPrimaryKeySelective(tStudent);
    }
}
