package com.demo.dao;

import com.demo.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {
    User selectUser(Integer userId);
    Integer selectUserAmount();
    Integer updateUser(@Param("userStatus")String userStatus, @Param("userId")Integer userId);
    Integer deleteUser(Integer userId);
    Integer insertUser(User User);
}
