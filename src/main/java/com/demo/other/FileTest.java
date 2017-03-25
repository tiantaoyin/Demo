package com.demo.other;

import java.io.File;
import java.io.FileFilter;

/**
 * 获取某目录下所有以.java结尾文件的绝对路径(含子目录)
 * Created by ankang on 2017-03-25.
 */
public class FileTest {
    public static void main(String[] args) {
        /**
         * 创建文件对象
         * 创建文件/目录对象不等于创建文件,创建文件调用createNewFile()方法
         */
        File file = new File("E:\\Test\\CoreJava");
        printJavaFilesAbsolutePath(file);
    }

    private static void printJavaFilesAbsolutePath(File file) {
        File[] files = file.listFiles(new FileFilter() {
            /**
             * @param pathname:该目录中的每一个文件或子目录
             * @return true:保留pathname到结果中
             * false:不保留pathname到结果中
             */
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }
                if (pathname.isFile()) {
                    String name = pathname.getName();
                    if (name.endsWith(".java")) {
                        return true;
                    }
                }
                return false;
            }
        });

        for (File f : files) {
            if (f.isFile()){
                System.out.println(f.getAbsolutePath());
            }else {
                printJavaFilesAbsolutePath(f);
            }
        }
    }
}
