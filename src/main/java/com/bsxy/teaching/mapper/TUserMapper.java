package com.bsxy.teaching.mapper;

import com.bsxy.teaching.pojo.TUser;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TUserMapper {


    int deleteByPrimaryKey(Integer uId);

    int insert(TUser record);

    int insertSelective(TUser record);


    TUser selectByPrimaryKey(Integer uId);

    TUser selectUser(TUser tUser);



    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}