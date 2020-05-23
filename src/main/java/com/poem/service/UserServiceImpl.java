package com.poem.service;

import com.poem.constant.MyConstant;
import com.poem.dao.UserDAO;
import com.poem.pojo.User;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    //@Resource(name="userDAO2")
    @Resource
    private UserDAO userDAO;
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserByUsername(String username) {
        return userDAO.queryUserByUsername(username);
    }

    @Override
    public Integer insertUser(User user) {
        // 加密
        String salt = UUID.randomUUID().toString();
        String s = new Sha256Hash(user.getPassword(), salt, MyConstant.INTERCOUNT).toBase64();
        // 设置密文
        user.setPassword(s);
        // 设置盐
        user.setSalt(salt);
        return userDAO.insertUser(user);
    }
}
