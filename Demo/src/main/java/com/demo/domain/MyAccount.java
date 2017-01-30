package com.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by ankang on 2017-01-11.
 */
@Data
@AllArgsConstructor
public class MyAccount {
    private String accountId; //账号  
    private int cash;   //账户余额  
}
