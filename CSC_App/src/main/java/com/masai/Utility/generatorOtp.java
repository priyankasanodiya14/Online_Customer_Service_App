package com.masai.Utility;

public class generatorOtp {

    public static int generate(){
        int randomPIN = (int)(Math.random()*9000)+1000;
        return randomPIN;
    }

}
