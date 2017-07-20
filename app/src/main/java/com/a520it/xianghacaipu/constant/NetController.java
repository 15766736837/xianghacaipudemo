package com.a520it.xianghacaipu.constant;

/**
 * Created by ASUS on 2017/6/26.
 */

public class NetController {

    public  static  final  int FOOD_USERIMFO_ACION = 0;
    public  static  final  String  FOOD_USERIMFO = "http://api.xiangha.com/main6/user/getUserInfoByCode?code=68104213276";
    public  static  final  int FOOD_MSP_ACION = 1;
    public  static  final  String FOOD_MSP = "http://api.xiangha.com/main6/user/getPostByCode?code=68104213276&page=1";

    //关注的网络地址
    public static  final  String  CONCERN_FONS_URL="http://api.xiangha.com/main5/home/getUserData?code=null&type=fans&page=1";
    public  static  final  String CONCERN_URL ="http://api.xiangha.com/main5/home/getUserData?code=null&type=follwers&page=1";
    public  static  final  int CONCERN_FONS_ACION = 2;
    public  static  final  int CONCERN_ACION = 3;
}
