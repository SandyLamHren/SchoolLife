package com.haoren.dao;

import com.haoren.bean.NewsBean;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * Created by Hh on 2017/5/13.
 */
public interface NewsDao {

    /**
     * 查询新闻列表
     * @return
     */
    @Select("select * from news where type = #{0} limit #{1} ")
    ArrayList<NewsBean> selectNewsList(int type, int count);

}
