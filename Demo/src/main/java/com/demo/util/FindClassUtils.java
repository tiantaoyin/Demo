package com.demo.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindClassUtils {

    /**
     * 通过配置文件的形式获取类对象
     * @param path
     * @return
     */
    public static Object findClassByPath(String path) throws Exception {

        try {
            return Class.forName(PropertiesUtils.getProperty(path)).newInstance();
        } catch (Exception e) {
            log.error("An Error happend when geting object, The Error Message is ", e);
            throw new ClassNotFoundException();
        }

    }
}
