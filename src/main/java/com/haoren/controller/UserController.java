package com.haoren.controller;

import com.alibaba.fastjson.JSONObject;
import com.haoren.bean.UserBean;
import com.haoren.constants.MyConstant;
import com.haoren.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户管理 controller
 * Created by Hh on 2017/3/26.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 登陆
     *
     * @param response
     * @param pwd
     */
    @RequestMapping("/login")
    public void login(HttpServletResponse response, String user_number, String pwd) {
        UserBean user = userService.selectUser(user_number, pwd);
        JSONObject object = new JSONObject();
        if (user == null) {
            //用户名或密码错误
            object.put("code", 0);
            object.put("msg", "用户名或密码错误");
            object.put("data", null);
        } else {
            //登陆成功
            object.put("code", 1);
            object.put("msg", "登陆成功");
            object.put("data", user);
        }
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册验证用户是否是烟大的人
     * @param response
     * @param pwd
     */
    @RequestMapping("/register")
    public void register(HttpServletResponse response, String user_number, String pwd, String real_name) {
        JSONObject object = new JSONObject();
        int code = userService.isYanDaPeople(real_name, user_number);
        if (code == MyConstant.USER_NOT_REGISTER) {
            // TODO: 2017/3/26  注册
            int result = userService.updateUserInfo(real_name, pwd, user_number);

            if (result == 1) {
                object.put("code", 1);
                object.put("msg", "注册成功");
                object.put("data", userService.selectUser(user_number, pwd));
            }
        } else if (code == MyConstant.USER_NOT_EXIST) {
            //号码不存在
            object.put("code", 0);
            object.put("msg", "仅限烟大本校人员使用");
            object.put("data", null);
        } else {
            //号码已注册 请直接登录
            object.put("code", 0);
            object.put("msg", "号码已经注册, 请直接登陆");
            object.put("data", null);
        }
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


