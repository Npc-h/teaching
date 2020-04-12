package com.bsxy.teaching.mapper;

import com.bsxy.teaching.pojo.TListen;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TListenMapper {


    int deleteByPrimaryKey(Integer lId);

    int insert(TListen record);

    int insertSelective(TListen record);


    TListen selectByPrimaryKey(Integer lId);



    int updateByPrimaryKeySelective(TListen record);

    int updateByPrimaryKey(TListen record);

    TListen verifyCourse(@Param("cName") String cName,@Param("lName") String lName);

    List<TListen> selectCourseListen(@Param("curr") Integer curr, @Param("limits") Integer limits,@Param("courseName") String courseName,@Param("listenName") String listenName);

    Integer selectCourseListenCount(@Param("courseName") String courseName,@Param("listenName") String listenName);

    Integer updateEvaluate(@Param("lID") String lID);
}