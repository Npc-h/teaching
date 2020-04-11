package com.bsxy.teaching.mapper;

import com.bsxy.teaching.pojo.TListen;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TListenMapper {


    int deleteByPrimaryKey(Integer lId);

    int insert(TListen record);

    int insertSelective(TListen record);


    TListen selectByPrimaryKey(Integer lId);



    int updateByPrimaryKeySelective(TListen record);

    int updateByPrimaryKey(TListen record);
}