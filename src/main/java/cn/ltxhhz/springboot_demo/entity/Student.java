package cn.ltxhhz.springboot_demo.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Student {
    private Long sid;
    private String name;
    private String gender;
    private Date birthdate;

    private String clname;
    private String telephone;
    private String headTeacher;
}
