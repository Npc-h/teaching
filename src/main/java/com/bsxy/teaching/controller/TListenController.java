package com.bsxy.teaching.controller;

import com.bsxy.teaching.pojo.TCourse;
import com.bsxy.teaching.pojo.TListen;
import com.bsxy.teaching.service.TListenService;
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
 * @ClassName TGroupController
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Controller
public class TListenController {
    @Autowired
    private TListenService tListenService;

    //添加听课表
    @RequestMapping(value = "/insertListen")
    @ResponseBody
    public Integer insertListen(HttpServletRequest request){
        //校验是否选择改课程
       TListen tListen = tListenService.verifyCourse(request.getParameter("CName"),request.getParameter("lName"));
        if(tListen!=null){
            return 3;
        }
        TListen tListen2 = new TListen();
        tListen2.setLCourseName(request.getParameter("CName"));
        tListen2.setLListenPerson(request.getParameter("lName"));
        tListen2.setLSite(request.getParameter("CSite"));
        tListen2.setLTeacher(request.getParameter("CTeacher"));

       return  tListenService.insertListen(tListen2);

    }

    //查询听课课程
    @RequestMapping(value = "/selectCourseListen")
    @ResponseBody
    public Map<String, Object> selectCourseListen(String page, String limit, String CourseName,String listenName){
        List<TListen> tListens = tListenService.selectCourseListen(page, limit,CourseName,listenName);
        JSONArray array = JSONArray.fromObject(tListens);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", tListenService.selectCourseListenCount(CourseName,listenName));
        result.put("data", array);
        return result;
    }
}
