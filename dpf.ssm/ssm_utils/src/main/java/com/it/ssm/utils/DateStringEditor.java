package com.it.ssm.utils;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.ParseException;
import java.util.Date;

/**
 * @program:dpf.ssm
 * @description:日期与字符串的转换
 * @autor:dpf
 * @create:2020-06-15 22:52
 **/
public class DateStringEditor extends PropertiesEditor {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        try {
            Date date = DateUtils.String2Date(text,"yyyy-MM-dd HH:mm");
            super.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
