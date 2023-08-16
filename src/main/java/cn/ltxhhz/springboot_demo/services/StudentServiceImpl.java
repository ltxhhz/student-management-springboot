package cn.ltxhhz.springboot_demo.services;

import cn.ltxhhz.springboot_demo.DAO.StudentDao;
import cn.ltxhhz.springboot_demo.entity.SelectionForm;
import cn.ltxhhz.springboot_demo.entity.Student;
import cn.ltxhhz.springboot_demo.entity.StudentForm;
import cn.ltxhhz.springboot_demo.entity.StudentSelection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> list(boolean basic) {
        return studentDao.list(basic);
    }

    @Override
    public int add(StudentForm student) {
        return studentDao.add(student);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public int delete(Long id) {
        return studentDao.delete(id);
    }

    @Override
    public List<StudentSelection> selection() {
        return studentDao.selections();
    }

    @Override
    public int putSelection(SelectionForm selectionForm) {
        return studentDao.putSelection(selectionForm);
    }

    @Override
    public int delSelection(SelectionForm selectionForm) {
        return studentDao.delSelection(selectionForm);
    }
}