package cn.ltxhhz.springboot_demo.DAO;

import cn.ltxhhz.springboot_demo.entity.SelectionForm;
import cn.ltxhhz.springboot_demo.entity.Student;
import cn.ltxhhz.springboot_demo.entity.StudentForm;
import cn.ltxhhz.springboot_demo.entity.StudentSelection;

import java.util.List;


public interface StudentDao {
    List<Student> list();

    List<Student> list(boolean basic);

    int add(StudentForm student);

    int update(Student student);

    int delete(Long id);

    List<StudentSelection> selections();

    int putSelection(SelectionForm selectionForm);
    int delSelection(SelectionForm selectionForm);
}
