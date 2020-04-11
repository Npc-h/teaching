package com.bsxy.teaching.dao;

import com.bsxy.teaching.mapper.TUserMapper;
import com.bsxy.teaching.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @ClassName TUserDao
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Repository
public class TUserDao {
    @Autowired
    private TUserMapper tUserMapper;

    public TUser verifyLogin(TUser tUserParam) {
        return tUserMapper.selectUser(tUserParam);
    }

    public int registerUser(TUser tUser) {
        return tUserMapper.insert(tUser);
    }
}
