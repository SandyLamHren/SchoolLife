package com.haoren.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 返回常用信息Util
 * Created by Hh on 2017/3/26.
 */
public class PrintUtil {

    //返回错误信息
    public static void errorPrint(JSONObject object) {
        object.put("code", 0);
        object.put("msg", null);
        object.put("data", null);
    }

}
