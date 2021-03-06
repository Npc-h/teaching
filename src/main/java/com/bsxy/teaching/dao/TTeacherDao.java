package com.bsxy.teaching.dao;

import com.bsxy.teaching.mapper.TTeacherMapper;
import com.bsxy.teaching.pojo.TTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName TTeacherDao
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Repository
public class TTeacherDao {
    @Autowired
    private TTeacherMapper tTeacherMapper;

    public void registerUser(TTeacher tTeacher) {
        tTeacherMapper.insertSelective(tTeacher);
    }

    public List<TTeacher> selectAllTeacher() {
        return tTeacherMapper.selectAllTeacher();
    }

    public List<TTeacher> selectTeacher(int curr, int limits, String teacherName) {
        return tTeacherMapper.selectTeacher(curr,limits,teacherName);
    }

    public Integer selectCountTeacher(String teacherName) {
        return tTeacherMapper.selectCountTeacher(teacherName);
    }
}
