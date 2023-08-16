package cn.ltxhhz.springboot_demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class StudentSelection {
    private Long sid;
    private String name;
    private String clname;
    private List<CourseSelection> selections;
}
