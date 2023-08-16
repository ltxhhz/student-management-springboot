package cn.ltxhhz.springboot_demo.controller;

import cn.ltxhhz.springboot_demo.entity.Result;
import cn.ltxhhz.springboot_demo.entity.ResultResponse;
import cn.ltxhhz.springboot_demo.entity.User;
import cn.ltxhhz.springboot_demo.services.UserService;
import cn.ltxhhz.springboot_demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    Result login(@RequestBody User user) {
        String res = userService.login(user);
        if (res == null) {
            return ResultResponse.getFailResult();
        } else {
            return ResultResponse.getSuccessResult(res);
        }
    }

    @GetMapping("/check")
    Result check(@CookieValue("user") String user) {
        return ResultResponse.getResult(Utils.verifyUser(user));
    }
}
