package cn.ltxhhz.springboot_demo.controller;

import cn.ltxhhz.springboot_demo.entity.*;
import cn.ltxhhz.springboot_demo.services.StudentService;
import cn.ltxhhz.springboot_demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping({"", "/"})
    public Result list(@CookieValue("user") String user, @RequestParam(value = "basic", defaultValue = "false") boolean basic) {
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getSuccessResult(studentService.list(basic));
    }

    @PostMapping({"", "/"})
    public Result add(@RequestBody StudentForm student, @CookieValue("user") String user) {
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getResult(studentService.add(student) > 0);
    }

    @PutMapping({"", "/"})
    public Result update(@RequestBody Student student, @CookieValue("user") String user) {
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getResult(studentService.update(student) > 0);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Long id, @CookieValue("user") String user) {
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getResult(studentService.delete(id) > 0);
    }

    @GetMapping("/selection")
    public Result selection(@CookieValue("user") String user) {
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getSuccessResult(studentService.selection());
    }

    @PutMapping("/selection")
    public Result selection1(@CookieValue("user") String user, @RequestBody SelectionForm selectionForm) {
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getResult(studentService.putSelection(selectionForm) > 0);
    }

    @DeleteMapping("/selection")
    public Result selection2(@CookieValue("user") String user, @RequestBody SelectionForm selectionForm) {
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getResult(studentService.delSelection(selectionForm) > 0);
    }
}
