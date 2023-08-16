package cn.ltxhhz.springboot_demo.DAO;

import cn.ltxhhz.springboot_demo.entity.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassDaoImpl implements ClassDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Class> list() {
        String sql="select * from class";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Class.class));
    }
}
