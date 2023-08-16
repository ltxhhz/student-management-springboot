package cn.ltxhhz.springboot_demo.services;

import cn.ltxhhz.springboot_demo.DAO.CourseDao;
import cn.ltxhhz.springboot_demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;

    @Override
    public List<Course> list() {
        return courseDao.list();
    }
}
