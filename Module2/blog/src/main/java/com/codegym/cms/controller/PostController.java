package com.codegym.cms.controller;

import com.codegym.cms.model.Post;
import com.codegym.cms.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/Post")
public class PostController {
    @Autowired
    PostController postController;
    @Autowired
    PostService postService;

    @GetMapping("/list")
    public ModelAndView findall() {
        List<Post> PostList = postService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("post", PostList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView savePost(@ModelAttribute("post") Post post) {
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("message", "Created");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable long id) {
        Post post = postService.findById(id);
        if (post != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("post", post);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/remove/{id}")
    public ModelAndView removePost(@ModelAttribute("post") Post post) {
        postService.remove(post.getId());
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @PostMapping("/remove")
    public String deletePost(@ModelAttribute("post") Post post) {
        postService.remove(post.getId());
        return "redirect:list";
    }
}