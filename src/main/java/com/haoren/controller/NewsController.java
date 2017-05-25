package com.haoren.controller;

import com.alibaba.fastjson.JSONObject;
import com.haoren.bean.NewsBean;
import com.haoren.service.NewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 新闻Controller
 * Created by Hh on 2017/5/13.
 */
@Controller
@RequestMapping("news")
public class NewsController {

    @Resource
    NewService newService;

    @RequestMapping("getNewsList")
    public void getNewList(HttpServletResponse response, int type,int page) {
        JSONObject object = new JSONObject();
        if (0 <= type && type <= 3) {
            ArrayList<NewsBean> datas = newService.selectNews(type,page);
            object.put("code", 1);
            object.put("msg", "查询成功");
            object.put("data",datas);

        } else {
            object.put("code", 0);
            object.put("msg", "请传入正确的type");
            object.put("data",null);
        }
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
