package cn.ltxhhz.springboot_demo.DAO;

import cn.ltxhhz.springboot_demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Course> list() {
        String sql = "select * from course";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course.class));
    }
}
