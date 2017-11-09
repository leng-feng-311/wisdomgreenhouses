package com.hongfeng.common.tool;

import java.util.Random;
import java.util.UUID;

/**
 * Created by Jiazefeng on 2017/10/18.
 */
public class IdGen {
    public static String getNewUserID() {
//        String reID = "U_"+(DateUtils.getNow(DateUtils.FORMAT_LONG_Number));
//        return reID;
        return uuid();
    }

    public static String getLoginBookID() {
//        String reID = "L_"+(DateUtils.getNow(DateUtils.FORMAT_LONG_Number));
//        return reID;
        return UUID.randomUUID().toString();
    }

    public static String getSMSAuthID(){
//        String reID = "A_"+(DateUtils.getNow(DateUtils.FORMAT_LONG_Number));
//        return reID;
        return uuid();
    }

    /**
    * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
    */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getCompliantID(){
        String reID = "CM_"+(DateUtils.getNow(DateUtils.FORMAT_LONG_Number));
        return reID;
    }

    public static String getMallID(){
        String reID = "M_"+(DateUtils.getNow(DateUtils.FORMAT_LONG_Number));
        return reID;
    }

    public static String getAnyPicID(){
        String reID = "AP_"+(DateUtils.getNow("yyyyMMddHHmmss"));
        return reID;
    }

    public static String getNanaTimeID(){
        String currentID = "";
        synchronized (IdGen.class){
            currentID =  DateUtils.getNow("yyyyMMddHHmmssSSS")+String.valueOf(System.nanoTime());
        }
        return currentID;
    }

    public static String getAnyImgID() {
        String reID = "AI_" + uuid();
        return reID;
    }
    /**
     * 获取时间Id
     * @return
     */
    public static String getDateId(){
        return getDateTimeId(DateUtils.FORMAT_LONG_Number);
    }

    /**
     * 获取时间 + 5位随机数
     * @return
     */
    public static String getDateTimeId(String format){

        String returnValue = DateUtils.getNow(format);
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return returnValue + rannum;
    }

    /**
     * 获取6位随机数字
     */
    public static int getSixRandom(){
        int random = (int)((Math.random()*9+1)*100000);
        return random;
    }

}
