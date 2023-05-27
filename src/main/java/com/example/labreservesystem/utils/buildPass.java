package com.example.labreservesystem.utils;

import org.apache.commons.codec.digest.DigestUtils;
public class buildPass {
    public static void main(String[] args) {
        String s = DigestUtils.md5Hex("123");
        System.out.println(s);
    }
}

