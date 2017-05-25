package com.haoren.service.impl;

import com.haoren.bean.NewsBean;
import com.haoren.dao.NewsDao;
import com.haoren.service.NewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by Hh on 2017/5/13.
 */
@Service("newsService")
public class NewsServiceImpl implements NewService{

    @Resource
    NewsDao newsDao;

    @Override
    public ArrayList<NewsBean> selectNews(int type, int page) {
        return newsDao.selectNewsList(type,page*10);
    }
}
