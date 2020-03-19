package com.hs.mvc.repository;

import com.hs.mvc.entity.ClockOn;
import com.hs.mvc.entity.Status;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClockOnDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ClockOn> queryByEmpNoToday(String empNo) {
        String sql = "SELECT * FROM ClockOn Where emp_no = ? AND DateDiff(clock_on, NOW())=0";
        return jdbcTemplate.query(sql, new Object[]{empNo}, new BeanPropertyRowMapper<>(ClockOn.class));
    }
    
    public void save(ClockOn clockOn) {
        String sql = "Insert Into CLOCKON(emp_no, status_id, image) values(?, ?, ?)";
        jdbcTemplate.update(sql,
                clockOn.getEmpNo(), clockOn.getStatusId(), clockOn.getImage());
    }

}
