package com.homework.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.homework.entity.User;
import com.homework.service.impl.ServiceImpl;
import com.homework.util.Ip;
import com.homework.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.homework.util.Md5;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

@Controller
public class UserController {
    @Autowired
    private ServiceImpl service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String email, String password, HttpServletRequest request) {
        Log log = new Log();//设置Log
        User user1 = service.login(email, passwordByMd5);
        Ip ip = new Ip();
        ip.setRequest(request);
        String IP = ip.getClientIp();
        if (user1 != null) {
            if (user1.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user1);
                request.getSession().setAttribute("admin", user1);
                log.setInfo("用户:" + user1.getUsername() + " IP:" + IP + " 登录成功");
                return "success";
            }
            else {
                log.setError("用户:" + user1.getUsername() + " IP:" + IP + " 密码错误");
                return "fail";
            }

        } else {
            log.setError("IP:" + IP + " 用户名或密码错误");
            return "fail";
        }
    }
}
