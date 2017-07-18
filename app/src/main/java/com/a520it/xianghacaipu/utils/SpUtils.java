package com.a520it.xianghacaipu.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 小码哥
 * @time 2017/4/24 0024  11:18
 * @desc 保存一些数据在SP
 */
public class SpUtils {

    public static final String AD_NAMEPARSSWORD = "ad_name"; //保存账号和密码
    public static final String AD_LOGINSTATR = "ad_nameprss"; //保存登录状态
    public static final String AD_USERNAME = "ad_username"; //保存用户的名字



    public static SharedPreferences getSP(Context context){
        //1 得到Sp
        SharedPreferences sp = context.getSharedPreferences("cache", Context.MODE_PRIVATE);
        return sp;
    }



    //保存boolean值
    public static  void setBoolean(Context context,String key,boolean value){
        SharedPreferences sp = getSP(context);
        //2 保存值
        sp.edit().putBoolean(key,value).commit();
    }

    public static boolean getBoolean(Context context,String key){
        SharedPreferences sp = getSP(context);
        boolean result = sp.getBoolean(key, false);
        return result;
    }

    //保存String的值
    public static  void setString(Context context,String key,String value){
        SharedPreferences sp = getSP(context);
        //2 保存值
        sp.edit().putString(key,value).commit();
    }

    public static String getString(Context context,String key){
        SharedPreferences sp = getSP(context);
        String result = sp.getString(key, "");
        return result;
    }

    //保存int的值
    public static  void setInterger(Context context,String key,int value){
        SharedPreferences sp = getSP(context);
        //2 保存值
        sp.edit().putInt(key,value).commit();
    }

    public static int getInteger(Context context,String key){
        SharedPreferences sp = getSP(context);
        int result = sp.getInt(key, 0);
        return result;
    }

    //保存long的值
    public static  void setLong(Context context,String key,long value){
        SharedPreferences sp = getSP(context);
        //2 保存值
        sp.edit().putLong(key,value).apply();
//        sp.edit().putLong(key,value).commit();
    }

    public static long getLong(Context context,String key){
        SharedPreferences sp = getSP(context);
        long result = sp.getLong(key, 0);
        return result;
    }

    /**
     * 保存文件到手机内存
     * @param context
     * @param number
     * @param psw
     * @return
     */
    public static boolean SaveUserInfo(Context context, String number,
                                       String psw) {
        try {
            File fileDir = context.getFilesDir();
            File f = new File(fileDir, "data.txt");
            FileOutputStream fos;
            fos = new FileOutputStream(f);

            String data = number + "##" + psw;
            fos.write(data.getBytes());
            fos.flush();
            fos.close();
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 从手机内存读取
     * @param context
     * @return
     */
    public static Map<String, String> GetUserInfo(Context context) {

        try {
            File fileDir = context.getFilesDir();
            File f = new File(fileDir, "data.txt");
            FileInputStream fis;
            fis = new FileInputStream(f);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    fis));
            String text = reader.readLine();
            if (!text.isEmpty()) {
                String split[] = text.split("##");
                Map<String, String> userInfoMap = new HashMap<String, String>();
                userInfoMap.put("number", split[0]);
                userInfoMap.put("psw", split[1]);
                return userInfoMap;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }



}
