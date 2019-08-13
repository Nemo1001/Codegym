package com.codegym.controller;

import com.codegym.model.Department;
import com.codegym.model.Employee;
import com.codegym.model.EmployeeForm;
import com.codegym.service.DepartmentService;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private EmployeeService employeeService;
    @Autowired
    private Environment env;
    @Autowired
    private DepartmentService departmentService;

    @ModelAttribute("departments")
    public Iterable<Department> departments() {
        return departmentService.findAll();
    }

    @GetMapping("/home")
    public ModelAndView findAll(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/employee/home");
        modelAndView.addObject("employees", employeeService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employeeForm", new EmployeeForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("employeeForm") EmployeeForm employeeForm) {
        MultipartFile multipartFile = employeeForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload".toString());
        try {
            FileCopyUtils.copy(employeeForm.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Employee employee = new Employee(employeeForm.getName(), employeeForm.getBirthDate(), employeeForm.getAddress(), fileName, employeeForm.getSalary(), employeeForm.getDepartment());
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("message", "Created new employee succesfully!");
        modelAndView.addObject("employeeForm", new EmployeeForm());
        return modelAndView;
    }

    @GetMapping({"/detail/{id}"})
    public ModelAndView view(@PathVariable("id") Long id) {
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/employee/view");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        EmployeeForm employeeForm = new EmployeeForm(employee.getId(), employee.getName(),
                employee.getBirthDate(), employee.getAddress(), null, employee.getSalary(), employee.getDepartment());
        ModelAndView modelAndView = new ModelAndView("/employee/delete");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("employeeForm", employeeForm);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteReceptionist(@ModelAttribute("employee") Employee employee) {
        employeeService.delete(employee.getId());
        return "redirect:/employee/home";
    }

//    @GetMapping("/search")
//    public ModelAndView showSearchForm() {
//        ModelAndView modelAndView = new ModelAndView("/employee/search");
//        return modelAndView;
//    }
//
//    @PostMapping({"/search"})
//    public ModelAndView search(@RequestParam("name") String name) {
//        Receptionist receptionist = receptionistService.findByName(name);
//        ModelAndView modelAndView = new ModelAndView("/receptionist/search");
//        modelAndView.addObject("receptionist", receptionist);
//        if (receptionist == null) {
//            modelAndView.addObject("message", "No result!");
//        }
//        return modelAndView;
//    }

    @GetMapping({"/edit/{id}"})
    public ModelAndView showUpdateForm(@PathVariable("id") Long id) {
        Employee employee = employeeService.findById(id);
        EmployeeForm employeeForm = new EmployeeForm(employee.getId(), employee.getName(), employee.getBirthDate(), employee.getAddress(), null, employee.getSalary(), employee.getDepartment());
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employeeForm", employeeForm);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("employeeForm") EmployeeForm employeeForm) {
        MultipartFile multipartFile = employeeForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload".toString());
        try {
            FileCopyUtils.copy(employeeForm.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Employee employee = new Employee(employeeForm.getName(), employeeForm.getBirthDate(), employeeForm.getAddress(), fileName, employeeForm.getSalary(), employeeForm.getDepartment());
        employee.setId(employeeForm.getId());
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("receptionistForm", employee);
        modelAndView.addObject("message", "Update employee completed!");
        return modelAndView;
    }

    @GetMapping("/sort")
    public ModelAndView sortEmployee(@RequestParam("sortType") String sortType) {
        Page<Employee> employees;
        int select;
        if (sortType.equals("salaryDesc")) {
            Pageable pageable = new PageRequest(0, 20, new Sort(Sort.Direction.DESC, "salary"));
            employees = employeeService.findAll(pageable);
            select = 1;
        } else {
            Pageable pageable = new PageRequest(0,20,new Sort(Sort.Direction.ASC,"salary"));
            employees = employeeService.findAll(pageable);
            select = 2;
        }
        ModelAndView modelAndView = new ModelAndView("/employee/home");
        modelAndView.addObject("employees",employees);
        modelAndView.addObject("select",select);
        return modelAndView;
    }
}
