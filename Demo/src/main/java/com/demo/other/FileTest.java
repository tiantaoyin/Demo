package com.demo.other;

import java.io.File;

/**
 * 获取某目录(E:\Test\CoreJava)下所有以.java结尾的文件的绝对路径(包含所有子目录)
 * 知识点:匿名内部类    File.listFiles()方法   递归
 * File.listFiles()方法 : File[] listFiles(FileFilter fileFilter)
 * FileFilter接口类型
 * 注:创建文件对象不等于创建文件,创建文件需调用file.createNewFile()方法
 *    另,创建线程对象不等于创建线程,启动线程需调用thread.start()方法
 * Created by ankang on 2017-01-31.
 */
public class FileTest {
    public static void main(String[] args) {
        //创建文件对象
        File file=new File("E:\\Test\\CoreJava");
        printJavaFiles(file);
    }

    //获取所有.java结尾的文件的绝对路径 的静态方法
    private static void printJavaFiles(File file) {
    }
}
