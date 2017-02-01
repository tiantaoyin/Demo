package com.demo.other;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;

/**
 * 获取某目录(E:\Test\CoreJava)下所有以.java结尾的文件的绝对路径(包含所有子目录)
 * 知识点:匿名内部类    File.listFiles()方法   递归
 * File.listFiles()方法 : File[] listFiles(FileFilter fileFilter)
 * FileFilter接口类型
 * 注:创建文件对象不等于创建文件,创建文件需调用file.createNewFile()方法
 * 另,创建线程对象不等于创建线程,启动线程需调用thread.start()方法
 * Created by ankang on 2017-01-31.
 */
@Slf4j
public class FileTest {
    public static void main(String[] args) {
        //创建文件对象
        File file = new File("E:\\Test\\CoreJava");
        log.info("invoke the static method which name is printJavaFiles ...");
        printJavaFiles(file);
    }

    //获取所有.java结尾的文件的绝对路径的静态方法
    private static void printJavaFiles(File file) {
        //listFile()获取目录下所有文件及子目录
        File[] files = file.listFiles(new FileFilter() {
            /**
             * @param pathname  该目录中的每一个文件或子目录
             * @return true 保留pathname到结果中
             *           false 不保留pathname到结果中
             */
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {//如果是目录,返回true
                    return true;
                }
                if (pathname.isFile()) {
                    String name = pathname.getName();//获取文件名
                    if (name.endsWith(".java")) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        });

        for (File file1 : files) {
            //是文件,打印其绝对路径
            if (file1.isFile()) {
                System.out.println(file1.getAbsolutePath());
            } else {
                //不是文件,递归调用printJavaFiles(File file)方法
                printJavaFiles(file1);
            }
        }
    }
}
