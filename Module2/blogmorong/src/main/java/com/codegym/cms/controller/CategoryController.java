package com.codegym.cms.controller;

import com.codegym.cms.model.Category;
import com.codegym.cms.model.Post;
import com.codegym.cms.service.CategoryService;
import com.codegym.cms.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostService postService;

    @GetMapping("/list")
    public ModelAndView showCategoryForm(@RequestParam ("s") Optional <String> s, Pageable pageable){
        Page<Locale.Category> categories;

        if (s.isPresent()){
            categories = categoryService.findAllByNameContaining(s.get(), pageable);
        }else {
            categories = categoryService.findAll(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveCategory(@ModelAttribute("category") Locale.Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editCategoryForm(@PathVariable Long id){
        Locale.Category category = CategoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category );
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/update")
    public ModelAndView updateCategory(@ModelAttribute("category") Locale.Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "category updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCategoryForm(@PathVariable Long id) {
        Locale.Category category = CategoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("category", category);
            modelAndView.addObject("message", "delete successfully");
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/remove")
    public ModelAndView deleteCategory(@ModelAttribute ("category") Category category){
        categoryService.remove(category.getId());
        ModelAndView modelAndView = new ModelAndView("/category/delete");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "delete success");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCategory(@PathVariable("id") Long id){
        Locale.Category category = CategoryService.findById(id);
        if(category == null){
            return new ModelAndView("/error-404");
        }

        Iterable<Post> post = postService.findAllByCategory(category);

        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("category", category);
        modelAndView.addObject("post", post);
        return modelAndView;
    }

}