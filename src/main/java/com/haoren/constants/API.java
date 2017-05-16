package com.haoren.constants;

/**
 * 请求地址信息
 * Created by Hh on 2017/3/26.
 */
public class API {

    private static final String IP = "http://192.168:8080/SchoolLife";

    /**
     * 登录 传入账号密码
     */
    public static final String LOGIN = IP+"/user/login";

    /**
     * 注册 传入用户名密码
     * user_number pwd
     */
    public static final String REGISTER = IP+"/user/register";



}
