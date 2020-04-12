package com.bsxy.teaching.dao;

import com.bsxy.teaching.mapper.TListenMapper;
import com.bsxy.teaching.pojo.TListen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName TGroupDao
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Repository
public class TListenDao {
    @Autowired
    private TListenMapper tListenMapper;

    public TListen verifyCourse(String cName, String lName) {
        return tListenMapper.verifyCourse(cName,lName);
    }

    public Integer insertListen(TListen tListen2) {
        return tListenMapper.insertSelective(tListen2);
    }

    public List<TListen> selectCourseListen(int curr, int limits, String courseName, String listenName) {
        return tListenMapper.selectCourseListen(curr,limits,courseName,listenName);
    }

    public Integer selectCourseListenCount(String courseName, String listenName) {
        return tListenMapper.selectCourseListenCount(courseName,listenName);
    }

    public Integer updateEvaluate(String lID) {
        return tListenMapper.updateEvaluate(lID);
    }
}
