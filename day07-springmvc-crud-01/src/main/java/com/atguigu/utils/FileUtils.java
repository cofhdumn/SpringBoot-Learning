package com.atguigu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileUtils {
    /**
     * 基于传入的文件名，使用UUID生成一个不会重复的文件名，但是要保证文件的后缀不变
     */

    public static String getFileName(String originalFileName) {
        //1. 获取文件的后缀
        String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));

        //UUID默认格式 案列： 5aa4f49c-8219-4647-b1d8-02935ae85c30
        //2. 使用UUID生成一个唯一的字符串
        String uuidStr = UUID.randomUUID().toString().replace("-", "");

        return uuidStr + suffix;

    }

    /**
     * 基于日期生成目录名
     */

    public static String getDateDirName() {
        //1. 获取当前日期
        String currentDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());

        return currentDate;

    }

    /**
     * 随机生成两级目录名称
     */

    public static String getRandomDirName() {
        //1. 定义字符源
        String str = "abcdefghijkl0123456789";
        //2. 定义一个StringBuilder对象

        StringBuilder dirNameBuilder = new StringBuilder();
        //2.1 随机生成两级目录名称
        for (int i = 0; i < 2; i++){
            //外层循环表示控制目录的层级
            //内层循环表示控制每一级目录的长度
            for (int j =0 ; j < 2; j++){
                //随机从str中获取一个字符
                int index = (int) Math.random() * str.length();
            }

            //拼接一个"/"
            dirNameBuilder.append("/");
        }
        //去掉最后一个"/"
        String substring = dirNameBuilder.toString().substring(0, dirNameBuilder.length() - 1);
        System.out.println("substring = " + substring);
        return substring;

    }
}
