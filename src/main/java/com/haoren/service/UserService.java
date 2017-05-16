package com.haoren.service;

import com.haoren.bean.UserBean;

/**
 * Created by Hh on 2017/3/26.
 */
public interface UserService {
    //注册
    //根据学号去判断是否是烟大的人
    int isYanDaPeople(String real_name,String user_number);
    //如果是本校的人员 更新用户信息
    int updateUserInfo(String real_name, String pwd,String user_number);

    //登陆 根据学号密码查询
    UserBean selectUser(String user_number, String pwd);
}
