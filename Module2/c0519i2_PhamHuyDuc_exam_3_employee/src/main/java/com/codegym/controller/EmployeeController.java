package com.codegym.controller;

import com.codegym.model.Department;
import com.codegym.model.Employee;
import com.codegym.model.EmployeeForm;
import com.codegym.service.DepartmentService;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    Environment env;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @ModelAttribute("departments")
    public Iterable<Department> departments() {
        return departmentService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView listEmployee(@PageableDefault(sort = "salary", size = 5, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employeeForm", new EmployeeForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveEmployee(@ModelAttribute("employee") EmployeeForm employeeForm) {
        MultipartFile multipartFile = employeeForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("upload_file");
        try {
            FileCopyUtils.copy(employeeForm.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Employee employee = new Employee(employeeForm.getName(), employeeForm.getAddress()
                , employeeForm.getSalary(), fileName, employeeForm.getBirthDate());
        employee.setDepartment(employeeForm.getDepartment());
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("message", "created new employee");
        modelAndView.addObject("employeeForm", new EmployeeForm());

        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editDepartmentForm(@PathVariable Long id){
        Department department = departmentService.findById(id);
        if (department != null) {
            ModelAndView modelAndView = new ModelAndView("/department/edit");
            modelAndView.addObject("department", department );
            return modelAndView;
        }else {
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
        }else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }
    @PostMapping("/remove")
    public ModelAndView deleteDepartment(@ModelAttribute ("department") Department department){
        departmentService.delete(department.getId());
        ModelAndView modelAndView = new ModelAndView("/department/delete");
        modelAndView.addObject("department", department);
        modelAndView.addObject("message", "delete success");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewDepartment(@PathVariable("id") Long id){
        Department department = departmentService.findById(id);
        if(department == null){
            return new ModelAndView("/error-404");
        }else {
            Iterable<Employee> employees = employeeService.findAllByDepartment(department);

            ModelAndView modelAndView = new ModelAndView("/department/information");
            modelAndView.addObject("department", department);
            modelAndView.addObject("employees", employees);
            return modelAndView;
        }
    }

}