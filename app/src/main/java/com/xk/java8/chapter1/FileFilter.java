package com.xk.java8.chapter1;

import java.io.File;

/**
 * Created by xuekai on 2017/5/17.
 */

public class FileFilter {
    public static void main(String[] args) {


        File[] files = new File("E:\\androidstudio_workspace\\k12").listFiles(File::isHidden);
//        File[] files = new File("E:\\androidstudio_workspace\\k12").listFiles(new java.io.FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.isHidden();
//            }
//        });
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
