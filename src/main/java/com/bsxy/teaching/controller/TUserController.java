package com.bsxy.teaching.controller;

import com.bsxy.teaching.pojo.TUser;
import com.bsxy.teaching.service.TUserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName TUserController
 * @Description: TODO
 * @Author yangjs
 * @Date 2020/4/10
 * @Version V1.0
 **/
@Controller
public class TUserController {

    @Autowired
    private TUserService tUserService;

    //校验用户登录
    @RequestMapping(value = "/verifyLogin")
    @ResponseBody
    public void  verifyLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject object = new JSONObject();
        String userName = request.getParameter("username");
        String userPassword = request.getParameter("password");
        String userType = request.getParameter("type");
        TUser tUserParam = new TUser();
        tUserParam.setUName(userName);
        tUserParam.setUPassword(userPassword);
        tUserParam.setUType(userType);
        TUser tUser = tUserService.verifyLogin(tUserParam);
        System.out.println(tUser);
        if(tUser!=null){
            object.put("flag","1");
            object.put("username",tUser.getUName());
            object.put("password",tUser.getUPassword());
            object.put("type",tUser.getUType());
            object.put("userid",tUser.getUId());
        }else {
            object.put("flag","2");
        }
        response.setContentType("text/xml;charset=GBK");
        response.getWriter().write(object.toString());
    }

    //用户注册
    @RequestMapping(value = "/registerUser")
    @ResponseBody
    public Integer registerUser(HttpServletRequest request){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        int num = uuid.hashCode();
        num = num < 0 ? -num : num;
        TUser tUser =new TUser();
        tUser.setUId(num);
        String userName = request.getParameter("username");
        String userPassword = request.getParameter("password");
        String userType = request.getParameter("type");
        tUser.setUName(userName);
        tUser.setUPassword(userPassword);
        tUser.setUType(userType);
        int i = tUserService. registerUser(tUser);
        return i;
    }

    //重置密码
    @RequestMapping(value = "/changePassword")
    @ResponseBody
    public Integer changePassword(HttpServletRequest request){

        //修改密码
        String newPassword = request.getParameter("passwordNew");
        String tUserId = request.getParameter("tUserId");
        return tUserService.tUserService(tUserId,newPassword);
    }

    //修改密码
    @RequestMapping(value = "/changePasswordC")
    @ResponseBody
    public Integer changePasswordC(HttpServletRequest request){
        //校验密码
        TUser tUser = new TUser();
        String uName = request.getParameter("username");
        String oldPassword = request.getParameter("oldpassword");
        tUser.setUName(uName);
        tUser.setUPassword(oldPassword);
        TUser tUsers = tUserService.verifyLogin(tUser);
        if(tUsers == null) return 3;

        //修改密码
        String newPassword = request.getParameter("newpassword");
        String tUserId = request.getParameter("tUserId");
        return tUserService.tUserService(tUserId,newPassword);
    }
}
