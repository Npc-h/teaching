package com.bsxy.teaching.mapper;

import com.bsxy.teaching.pojo.TCourse;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TCourseMapper {

    int deleteByPrimaryKey(Integer cId);

    int insert(TCourse record);

    int insertSelective(TCourse record);


    TCourse selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(TCourse record);

    int updateByPrimaryKey(TCourse record);
}