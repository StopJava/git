package com.it.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    //将字符串转化为时间
    public static Date String2Date(String str,String patt) throws ParseException {
        SimpleDateFormat sdf= new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }
    //将时间转化为字符串
    public static String Date2String(Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }
}
