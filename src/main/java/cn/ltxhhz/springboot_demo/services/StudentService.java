package cn.ltxhhz.springboot_demo.services;

import cn.ltxhhz.springboot_demo.entity.SelectionForm;
import cn.ltxhhz.springboot_demo.entity.Student;
import cn.ltxhhz.springboot_demo.entity.StudentForm;
import cn.ltxhhz.springboot_demo.entity.StudentSelection;

import java.util.List;

public interface StudentService {
    List<Student> list(boolean basic);

    int add(StudentForm student);

    int update(Student student);

    int delete(Long id);

    List<StudentSelection> selection();

    int putSelection(SelectionForm selectionForm);

    int delSelection(SelectionForm selectionForm);
}