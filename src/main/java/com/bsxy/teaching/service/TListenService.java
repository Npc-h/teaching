package com.bsxy.teaching.service;

import com.bsxy.teaching.dao.TListenDao;
import com.bsxy.teaching.pojo.TListen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TGroupService
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Service
public class TListenService {
    @Autowired
    private TListenDao tListenDao;

    public TListen verifyCourse(String cName, String lName) {
        return tListenDao.verifyCourse(cName,lName);
    }

    public Integer insertListen(TListen tListen2) {
        return tListenDao.insertListen(tListen2);
    }

    public List<TListen> selectCourseListen(String page, String limit, String courseName, String listenName) {
        int curr = Integer.parseInt(page);
        int limits = Integer.parseInt(limit);
        curr = (curr-1)*limits;
        return tListenDao.selectCourseListen(curr,limits,courseName,listenName);
    }

    public Integer selectCourseListenCount(String courseName, String listenName) {
        return tListenDao.selectCourseListenCount(courseName,listenName);
    }
}
