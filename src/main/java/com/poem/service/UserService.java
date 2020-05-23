package com.poem.service;

import com.poem.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    User queryUserByUsername(@Param("username") String username);
    Integer insertUser(User user);
}
