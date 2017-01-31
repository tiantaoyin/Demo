package com.demo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by ankang on 2017-01-30.
 */
@Data
public class User implements Serializable{
    private Integer userId;
    private String userMobile;
    private String userPassword;
    private String userRealname;
    private String userLawname;
    private String userSex;
    private String userAddress;
    private String userAutograph;
    private String userImg;
    private String userSalt;
    private String userStatus;
    private Integer teachId;
}
