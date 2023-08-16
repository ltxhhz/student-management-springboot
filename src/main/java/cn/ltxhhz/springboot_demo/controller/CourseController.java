package cn.ltxhhz.springboot_demo.controller;


import cn.ltxhhz.springboot_demo.entity.Result;
import cn.ltxhhz.springboot_demo.entity.ResultResponse;
import cn.ltxhhz.springboot_demo.services.CourseService;
import cn.ltxhhz.springboot_demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/selection")
    public Result selection(@CookieValue("user") String user){
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getSuccessResult();
    }

    @GetMapping({"","/"})
    public Result list(@CookieValue("user") String user){
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getSuccessResult(courseService.list());
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
