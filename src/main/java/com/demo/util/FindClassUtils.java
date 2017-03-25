package com.demo.util;

public class FindClassUtils {

    /**
     * 通过路径获取对应的实现类
     * @param path
     * @return
     */
    public static Object findClassByPath(String path) throws Exception {
        try {
            return Class.forName(PropertiesUtils.getProperty(path)).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }
}
