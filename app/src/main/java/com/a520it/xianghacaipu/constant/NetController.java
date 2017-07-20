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

    //我的订单网络地址
    public  static  final  String  MYINDENT_ALL = "http://api.ds.xiangha.com/v2/oder/listOrder?status=0&pn=1&null&";
    public  static  final  int  MYINDENT_ALL_ACTION = 4;


    //我的积分网络地址
    public  static  final  String  INTEVRATE_TOP ="http://api.xiangha.com/home5/getTaskCount?";
    public  static  final  int   INTEVRATE_TOP_ACION = 5;
    public  static  final  String  INTEVRATE_BTOOM ="http://api.xiangha.com/main5/home/getProductList?page=1";
    public  static  final  int   INTEVRATE_BTOOM_ACION = 6;

    //我的钱包网络
    public  static  final  String WALLET_URL ="http://appweb.xiangha.com/vip/allet?fullScreen=2";
    //我的会员网络请求
    public  static  final  String  VIP_URL="http://appweb.xiangha.com/vip/myvip?fullScreen=2";

}
