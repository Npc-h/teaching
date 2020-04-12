package com.bsxy.teaching.controller;

import com.bsxy.teaching.pojo.TCourse;
import com.bsxy.teaching.pojo.TStudent;
import com.bsxy.teaching.pojo.TTeacher;
import com.bsxy.teaching.service.TStudentService;
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
 * @ClassName TStudentController
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Controller
public class TStudentController {
    @Autowired
    private TStudentService tStudentService;

    //查询学生
    @RequestMapping(value = "/selectStudent")
    @ResponseBody
    public Map<String, Object> selectStudent(String page, String limit, String studentName){
        List<TTeacher> tTeacher = tStudentService.selectStudent(page, limit,studentName);
        JSONArray array = JSONArray.fromObject(tTeacher);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", tStudentService.selectStudentCount(studentName));
        result.put("data", array);
        return result;
    }

    //编辑学生信息
    @RequestMapping(value = "/changeStudent")
    @ResponseBody
    public Integer changeStudent(HttpServletRequest request){
        TStudent tStudent= new TStudent();

        tStudent.setSUserId(request.getParameter("tUserId"));
        tStudent.setSAge(request.getParameter("tUserAge"));
        tStudent.setSSex(request.getParameter("tUserSex"));
        tStudent.setSNumber(request.getParameter("tUserNumber"));

        return tStudentService.changeStudent(tStudent);
    }
}
