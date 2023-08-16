package cn.ltxhhz.springboot_demo.DAO;

import cn.ltxhhz.springboot_demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean verify(User user) {
        String sql = "select * from users where account=?";
        try {
            Map<String, Object> result = jdbcTemplate.queryForMap(sql, user.getAccount());
            return result.get("password").equals(user.getPassword());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
