package com.bsxy.teaching.dao;

import com.bsxy.teaching.mapper.TStudentMapper;
import com.bsxy.teaching.pojo.TStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
