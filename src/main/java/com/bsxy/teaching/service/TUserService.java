package com.bsxy.teaching.service;

import com.bsxy.teaching.dao.TStudentDao;
import com.bsxy.teaching.dao.TTeacherDao;
import com.bsxy.teaching.dao.TUserDao;
import com.bsxy.teaching.pojo.TStudent;
import com.bsxy.teaching.pojo.TTeacher;
import com.bsxy.teaching.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName TUserService
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Service
public class TUserService {
    @Autowired
    private TUserDao tUserDao;

    @Autowired
    private TStudentDao tStudentDao;

    @Autowired
    private TTeacherDao tTeacherDao;

    public TUser verifyLogin(TUser tUserParam) {
        return tUserDao.verifyLogin(tUserParam);
    }

    @Transactional
    public int registerUser(TUser tUser) {
        //判断类型 插入教师表和学生表
        if(tUser.getUType().equals("1")){
            TStudent tStudent =new TStudent();
            tStudent.setSName(tUser.getUName());
            tStudent.setSUserId(tUser.getUId().toString());

            tStudentDao.registerUser(tStudent);
        }else if(tUser.getUType().equals("2")){
            TTeacher tTeacher = new TTeacher();
            tTeacher.setTName(tUser.getUName());
            tTeacher.setTUserId(tUser.getUId().toString());

            tTeacherDao.registerUser(tTeacher);
        }
        return tUserDao.registerUser(tUser);
    }
}
