package com.a520it.xianghacaipu.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 2017/5/11.
 */
//网络请求工具类
public class NetworkUtil {

    //get请求
    public static InputStream doGet(String urlstr, HashMap<String, String> map) {
        //创建一个请求
        try {
            String parseParams = parseParams(map);
            URL url = new URL(urlstr + "?" + parseParams);
            //打开请求
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置请求方法
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                InputStream in = conn.getInputStream();
                //                BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
                //返回数据
                //                return  buffer.readLine();
                return in;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //post请求
    public static String doPost(String urlstr, HashMap<String, String> map) {
        //创建一个请求
        try {
            URL url = new URL(urlstr);
            //打开请求
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置请求方法
            conn.setRequestMethod("POST");
            //解析集合
            String parseParams = parseParams(map);
            //设置开启输出流
            conn.setDoOutput(true);
            //获取输出流,发送数据
            conn.getOutputStream().write(parseParams.getBytes());
            if (conn.getResponseCode() == 200) {
                InputStream in = conn.getInputStream();
                BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
                //返回数据
                return buffer.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //把一个map集合转化为字符串
    private static String parseParams(HashMap<String, String> map) {
        String strString = "";
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                strString += entry.getKey() + "=" + entry.getValue() + "&";
            }
            strString = strString.substring(0, strString.length() - 1);
            return strString;
        }
        return strString;
    }

}
