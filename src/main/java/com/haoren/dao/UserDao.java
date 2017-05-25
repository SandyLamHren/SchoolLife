package com.haoren.dao;

import com.haoren.bean.AcademyBean;
import com.haoren.bean.ClassBean;
import com.haoren.bean.MajorBean;
import com.haoren.bean.UserBean;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 用户Dao
 * Created by Hh on 2017/3/26.
 */
public interface UserDao {

    //登陆
    UserBean selectUser(String user_number, String pwd);

    ClassBean selectClass(int id);

    MajorBean selectMajor(int id);

    AcademyBean selectAcademy(int id);


    /** 注册流程 **/
    //查询学号是否存在
    @Select("select * from user where user_number = #{1} and real_name= #{0}")
    UserBean isYanDaPeople(String real_name,String user_number);
    @Update("UPDATE user SET real_name =#{0} , pwd =#{1} WHERE user_number=#{2}")
    int updateUserInfo(String real_name,String pwd,String user_number);


}
