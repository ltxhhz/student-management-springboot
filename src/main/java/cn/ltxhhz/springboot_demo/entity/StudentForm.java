package cn.ltxhhz.springboot_demo.entity;

import lombok.Data;

@Data
public class StudentForm {
    private Long sid;
    private String name;
    private String gender;
    private String birthdate;
    private int clid;
    private String telephone;
}
