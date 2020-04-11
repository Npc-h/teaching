package com.bsxy.teaching.controller;

import com.bsxy.teaching.pojo.TCourse;
import com.bsxy.teaching.service.TCourseService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TCourseController
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Controller
public class TCourseController {
    @Autowired
    private TCourseService tCourseService;

    //查询课程
    @RequestMapping(value = "/selectCourse")
    @ResponseBody
    public Map<String, Object> selectCourseName(String page, String limit, String CourseName){
        List<TCourse> tFoods = tCourseService.selectCourseName(page, limit,CourseName);
        JSONArray array = JSONArray.fromObject(tFoods);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", tCourseService.selectCountCourse(CourseName));
        result.put("data", array);
        return result;
    }

    //增加课程
    @RequestMapping(value = "/addCourse")
    @ResponseBody
    public Integer addCourse(HttpServletRequest request){
        TCourse tCourse = new TCourse();
        tCourse.setCName(request.getParameter("courseName"));
        tCourse.setCTeacher(request.getParameter("contrller"));
        tCourse.setCSite(request.getParameter("courseSite"));


        return tCourseService.addCourse(tCourse);
    }
}
