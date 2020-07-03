package com.it.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program:dpf.ssm
 * @description:加密类
 * @autor:dpf
 * @create:2020-06-22 19:56
 **/
public class PasswordEncoder {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String Encoder(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password ="123";
        System.out.println(Encoder(password));
    }
}
