package com.codegym.controller;

import com.codegym.model.Department;
import com.codegym.model.Employee;
import com.codegym.service.DepartmentService;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ModelAndView listDepartment() {
        Iterable<Department> departments = departmentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/department/list");
        modelAndView.addObject("departments", departments);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/department/create");
        modelAndView.addObject("department", new Department());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveCategory(@ModelAttribute("department") Department department) {
        departmentService.save(department);

        ModelAndView modelAndView = new ModelAndView("/department/create");
        modelAndView.addObject("department", new Department());
        modelAndView.addObject("message", "created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editDepartmentForm(@PathVariable Long id) {
        Department department = departmentService.findById(id);
        if (department != null) {
            ModelAndView modelAndView = new ModelAndView("/department/edit");
            modelAndView.addObject("department", department);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/update")
    public ModelAndView updateDepartment(@ModelAttribute("department") Department department) {
        departmentService.save(department);
        ModelAndView modelAndView = new ModelAndView("/department/edit");
        modelAndView.addObject("department", department);
        modelAndView.addObject("message", "department updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteDepartment(@PathVariable Long id) {
        Department department = departmentService.findById(id);
        if (department != null) {
            ModelAndView modelAndView = new ModelAndView("/department/delete");
            modelAndView.addObject("department", department);
            modelAndView.addObject("message", "delete successfully");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/remove")
    public ModelAndView deleteDepartment(@ModelAttribute("department") Department department) {
        departmentService.delete(department.getId());
        ModelAndView modelAndView = new ModelAndView("/department/delete");
        modelAndView.addObject("department", department);
        modelAndView.addObject("message", "delete success");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewDepartment(@PathVariable("id") Long id) {
        Department department = departmentService.findById(id);
        if (department == null) {
            return new ModelAndView("/error-404");
        } else {
            Iterable<Employee> employees = employeeService.findAllByDepartment(department);

            ModelAndView modelAndView = new ModelAndView("/department/information");
            modelAndView.addObject("department", department);
            modelAndView.addObject("employees", employees);
            return modelAndView;
        }
    }
}
