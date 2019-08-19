package com.codegym.formatter;

import com.codegym.model.Department;
import com.codegym.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class DepartmentFormatter implements Formatter<Department> {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentFormatter(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public Department parse(String text, Locale locale) throws ParseException {
        return departmentService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Department object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}