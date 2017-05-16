package com.haoren.service.impl;

import com.haoren.bean.UserBean;
import com.haoren.constants.MyConstant;
import com.haoren.dao.UserDao;
import com.haoren.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Hh on 2017/3/26.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public int isYanDaPeople(String real_name,java.lang.String user_number) {
        UserBean userBean = userDao.isYanDaPeople(real_name,user_number);
        if (userBean == null) {
            return MyConstant.USER_NOT_EXIST;
        } else if (userBean.getPwd().equals("")) {
            return MyConstant.USER_NOT_REGISTER;
        } else {
            return MyConstant.USER_REGISTER;
        }
    }

    @Override
    public int updateUserInfo(String real_name, String pwd,String userNumber) {
        return userDao.updateUserInfo( real_name, pwd,userNumber);
    }

    @Override
    public UserBean selectUser(java.lang.String user_number, java.lang.String pwd) {
        return userDao.selectUser(user_number, pwd);
    }
}
