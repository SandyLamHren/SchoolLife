package com.haoren.service;

import com.haoren.bean.NewsBean;

import java.util.ArrayList;

/**
 * * 新闻相关Service
 * Created by Hh on 2017/5/13.
 */
public interface NewService {

    /**
     * 查询新闻列表
     */

    ArrayList<NewsBean> selectNews(int type, int page);
}
