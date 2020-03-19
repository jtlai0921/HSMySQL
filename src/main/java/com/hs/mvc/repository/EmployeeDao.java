package com.hs.mvc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getNameByNo(String empNo) {
        String sql = "SELECT emp_name FROM Employee Where emp_no = ?";
        try {
            return (String) jdbcTemplate.queryForObject(sql, new Object[] { empNo }, String.class);
        } catch (Exception e) {
        }
        return null;
    }

}
