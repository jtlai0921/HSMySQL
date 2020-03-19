package com.hs.mvc.repository;

import com.hs.mvc.entity.Status;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StatusDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Status> queryAllList() {
        String sql = "SELECT * FROM Status";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Status.class));
    }

}
