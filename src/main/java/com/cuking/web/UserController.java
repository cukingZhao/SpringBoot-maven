package com.cuking.web;

import com.cuking.domain.User;
import com.cuking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by cuking on 2017/1/5.
 */
@Controller
@RequestMapping("/u")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/i")
    public String index() {
        return "login";
    }

    @RequestMapping("/r")
    public String r() {
        return "regist";
    }

    @RequestMapping("/regist")
    @ResponseBody
    public Map<String, Object> regist(User user) {

        Map map = new HashMap();

        userService.save(user);
        map.put("status", 200);
        map.put("data", "注册成功");


        return map;
    }

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(String username, String password) {
        Map map = new HashMap();

        User user = userService.findByName(username);

        if (null != user && user.getPassword().equals(password)) {
            map.put("status", 200);
            map.put("data", "登录成功!  欢迎回来!  " + user.getNickName());
        } else {
            map.put("status", 500);
            map.put("data", "登录失败!用户名或者密码不正确!!");
        }
        return map;
    }
}
