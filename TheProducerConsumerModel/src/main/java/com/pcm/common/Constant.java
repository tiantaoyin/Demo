package com.pcm.common;

import com.pcm.util.PropertiesUtils;

/**
 * 常量
 * Created by ankang on 2017-02-07.
 */
public class Constant {
    public static int STORAGE_MAX_SIZE = Integer.parseInt(PropertiesUtils.getProperty("storage_max_size"));    //仓库最大存储量
}
