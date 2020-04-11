package com.bsxy.teaching.mapper;

import com.bsxy.teaching.pojo.TTeacher;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TTeacherMapper {


    int deleteByPrimaryKey(Integer tId);

    int insert(TTeacher record);

    int insertSelective(TTeacher record);


    TTeacher selectByPrimaryKey(Integer tId);



    int updateByPrimaryKeySelective(TTeacher record);

    int updateByPrimaryKey(TTeacher record);
}