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

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/department/create");
        modelAndView.addObject("department", new Department());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("department") Department department) {
        departmentService.save(department);
        ModelAndView modelAndView = new ModelAndView("/department/create");
        modelAndView.addObject("message", "Created!");
        modelAndView.addObject("department", new Department());
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView("/department/home");
        Iterable<Department> departments = departmentService.findAll();
        modelAndView.addObject("departments", departments);
        return modelAndView;
    }

    @GetMapping({"/edit/{id}"})
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/department/edit");
        Department department = departmentService.findById(id);
        modelAndView.addObject("department", department);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute("department") Department department) {
        ModelAndView modelAndView = new ModelAndView("/department/edit");
        departmentService.save(department);
        modelAndView.addObject("department", new Department());
        modelAndView.addObject("message", "Edited");
        return modelAndView;
    }

    @GetMapping({"/delete/{id}"})
    public ModelAndView showDeleteForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/department/delete");
        modelAndView.addObject("department", departmentService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("department") Department department) {
        ModelAndView modelAndView = new ModelAndView("/department/home");
        modelAndView.addObject("message", "Deleted!");
        departmentService.delete(department.getId());
        modelAndView.addObject("departments", departmentService.findAll());

        return modelAndView;
    }

    @GetMapping("/view")
    public ModelAndView findByDepartment(@RequestParam("departmentId") Long id) {
        Department department = departmentService.findById(id);
        Iterable<Employee> employees = employeeService.findAllByDepartment(department);
        ModelAndView modelAndView = new ModelAndView("/department/view");
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("department", department);
        return modelAndView;
    }

}
