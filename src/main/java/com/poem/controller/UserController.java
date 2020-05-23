package com.poem.controller;

import com.poem.pojo.User;
import com.poem.service.PoemService;
import com.poem.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PoemService poemService;

    @GetMapping("/login")
    public String login(){
        System.out.println("goto login page");
        return "login";
    }

    @PostMapping("/login")
    public String loginLogic(User user, Model model){


        System.out.println("login logic");
        //获取subject 调用login
        Subject subject = SecurityUtils.getSubject();
        // 创建用于登录的令牌
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 开启记住我
        token.setRememberMe(true);
        // 登录失败会抛出异常，则交由异常解析器处理
        subject.login(token);
        model.addAttribute("poems",poemService.selectPoemRandom());
        return "index";// 登录成功，跳转首页
    }



    @RequestMapping("/perms/error")
    public String permsError(){
        System.out.println("权限不足");
        return "perm_error";
    }

    @GetMapping("/regist")
    public String registPage(){
        System.out.println("goto regist page");
        return "regist";
    }

    @PostMapping("/regist")
    public String regist(User user){
        userService.insertUser(user);
        return "redirect:/user/login";
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "index";
    }
}