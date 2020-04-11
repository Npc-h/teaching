package com.bsxy.teaching.dao;

import com.bsxy.teaching.mapper.TTeacherMapper;
import com.bsxy.teaching.pojo.TTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
