package com.demo.service.impl;

import com.demo.service.USB;

/**
 * Created by ankang on 2017-01-12.
 */
public class Mouse implements USB {
    public void service() {
        System.out.println("通电--->移动");
    }
}
