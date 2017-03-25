package com.demo.designModel.FactoryModel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.demo.service.USB;
import com.demo.util.PropertiesUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactoryTest {

    /**
     * 工厂模式
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        long beginTime = System.currentTimeMillis();

        InputStream is = new FileInputStream(PropertiesUtils.getProperty("path"));

        Properties prop = new Properties();//HashHashtable的子类（setProperty代表put，getProperty代表get）

        prop.load(is);//加载流中的内容（键值对），通过“ = ” 区分键和值

        String factory = prop.getProperty("factory");

        log.info("getting object ...");

        USB usb = factory(factory);

        log.info("invoke method ...");

        usb.service();

        long endTime = System.currentTimeMillis();

        log.info("任务耗时" + (endTime - beginTime) + "毫秒");
    }

    //工厂
    public static USB factory(String className) throws Exception {
        Class<?> c = Class.forName(className);
        return (USB) c.newInstance();
    }
}