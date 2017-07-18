package com.a520it.xianghacaipu.constant;

import android.util.Log;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by simon on 2017/6/16.
 */

public class NetworkCons {

    public static final String BASEURL = "http://api.xiangha.com/";
    public static final String FINDFISTLISTDATA = "main6/tie/getList?cid=10&mid=27&page=1&pageTime=";
    public static final String FINDADDLISTDATA = "main6/tie/getList?cid=10&mid=27&page=PAGENUM&pageTime=TIME";
    public static final String NEWADDLISTDATA = "main6/tie/getList?cid=10&mid=25&page=PAGENUM&pageTime=TIME";
    public static final String FINDDETAILDATA = "http://api.xiangha.com/main6/tie/getInfo?code=CODEID&page=1";

    public static String getCodeId(String codeid) {
        String url = FINDDETAILDATA;
        url = url.replace("CODEID", codeid);
        Log.v("cherish233", "url:" + url);
        return url;
    }

    public static String getPage(int page, String time) {
        String url = FINDADDLISTDATA;
        url = url.replace("PAGENUM", String.valueOf(page)).replace("TIME", time);
        return url;
    }

    public static String getNewPage(int page, String time) {
        String url = NEWADDLISTDATA;
        url = url.replace("PAGENUM", String.valueOf(page)).replace("TIME", time);
        return url;
    }

    public static String getTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //年月日
        String nyr = sDateFormat.format(new Date());
        sDateFormat = new SimpleDateFormat("HH:mm:ss");

        //时分秒
        String sfm = sDateFormat.format(new Date());
        String sfm2 = sDateFormat2.format(new Date());
<<<<<<< HEAD
        Log.v("cherish233", "时间1=" + sfm + "----时间2=" + sfm2);
        String encode = URLEncoder.encode(sfm);
        return nyr + "+" + encode;
=======
        Log.v("cherish233","时间1="+sfm+"----时间2="+sfm2);
//        String encode = URLEncoder.encode(sfm);
//        return nyr + "+" + encode;
        return "111";
>>>>>>> xlk
    }

}

