package com.bsxy.teaching.controller;

import com.bsxy.teaching.pojo.TCourse;
import com.bsxy.teaching.pojo.TTeacher;
import com.bsxy.teaching.service.TTeacherService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TTeacherController
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Controller
public class TTeacherController {
    @Autowired
    private TTeacherService tTeacherService;

    //查询课程
    @RequestMapping(value = "/selectTeacher")
    @ResponseBody
    public List<TTeacher> selectAllTeacher(){
        System.out.println("进入调用");
       List<TTeacher> tTeacherList = tTeacherService.selectAllTeacher();
        System.out.println("查询到的值为"+tTeacherList.size());
        return tTeacherList;
    }

}
