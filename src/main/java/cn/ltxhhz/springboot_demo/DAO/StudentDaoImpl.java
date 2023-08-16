package cn.ltxhhz.springboot_demo.DAO;

import cn.ltxhhz.springboot_demo.entity.*;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> list() {
        String sql = "SELECT sid,name,gender,birthdate,clname,telephone,tname headTeacher FROM student,class,teacher where student.clid=class.clid and class.tid=teacher.tid";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public List<Student> list(boolean basic) {
        if (basic) {
            String sql = "SELECT sid,name FROM student";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        }
        return list();
    }

    @Override
    public int add(StudentForm student) {
        String sql = "INSERT INTO student VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, student.getSid(), student.getName(), student.getGender(), student.getBirthdate(), student.getClid(), student.getTelephone());
    }

    @Override
    public int update(Student student) {
        String sql = "UPDATE student SET name=?, age=? WHERE id=?";
        return jdbcTemplate.update(sql, student.getName(), student.getBirthdate(), student.getSid());
    }

    @Override
    public int delete(Long id) {
        String sql = "DELETE FROM student WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<StudentSelection> selections() {
        String sql = "select student.sid,name,clname,JSON_ARRAYAGG(JSON_OBJECT('cid',course.cid,'cname',cname,'usual_grade',usual_grade,'final_grade',final_grade)) as selections from student,class,select_course,course where student.sid=select_course.sid and student.clid=class.clid and select_course.cid=course.cid group by student.sid,name,clname;";
        RowMapper<StudentSelection> rowMapper = (rs, rowNum) -> {
            StudentSelection ss = new StudentSelection();
            ss.setSid(rs.getLong("sid"));
            ss.setName(rs.getString("name"));
            ss.setClname(rs.getString("clname"));
            List<CourseSelection> cs = JSON.parseObject(rs.getString("selections"), new TypeReference<>() {
            });
            ss.setSelections(cs);
            return ss;
        };
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public int putSelection(SelectionForm selectionForm) {
        String sql = "insert into select_course(sid,cid) values(?,?)";
        return jdbcTemplate.update(sql, selectionForm.getSid(), selectionForm.getCid());
    }

    @Override
    public int delSelection(SelectionForm selectionForm) {
        String sql="delete from select_course where sid=? and cid=?";
        return  jdbcTemplate.update(sql, selectionForm.getSid(), selectionForm.getCid());
    }
}
