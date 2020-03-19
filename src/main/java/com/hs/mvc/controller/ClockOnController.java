package com.hs.mvc.controller;

import com.hs.mvc.entity.ClockOn;
import com.hs.mvc.entity.Employee;
import com.hs.mvc.repository.ClockOnDao;
import com.hs.mvc.repository.EmployeeDao;
import com.hs.mvc.repository.StatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/clock_on")
public class ClockOnController {
    @Autowired
    private StatusDao statusDao;
    
    @Autowired
    private ClockOnDao clockOnDao;
    
    @Autowired
    private EmployeeDao employeeDao;
    
    @RequestMapping("/input")
    public String input(Model model) {
        ClockOn clockOn = new ClockOn();
        model.addAttribute("clockOn", clockOn);
        model.addAttribute("list_status", statusDao.queryAllList());
        model.addAttribute("empName", "");
        model.addAttribute("list_clockon", null);
        return "clock_on";
    }
    
    @RequestMapping("/in")
    public String in(Model model, ClockOn clockOn, @RequestBody MultiValueMap<String, String> formData) {
        String empName = employeeDao.getNameByNo(clockOn.getEmpNo());
        if(empName != null) {
            clockOnDao.save(clockOn);
        }
        model.addAttribute("clockOn", clockOn);
        model.addAttribute("list_status", statusDao.queryAllList());
        model.addAttribute("empName", empName == null ? "無此員工" : empName);
        model.addAttribute("list_clockon", clockOnDao.queryByEmpNoToday(clockOn.getEmpNo()));
        return "clock_on";
    }
    
    
}
