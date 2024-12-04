package com.example.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.blog.entity.Blog;
import com.example.blog.form.BlogForm;
import com.example.blog.service.BlogService;

@Controller
public class BlogController {
	
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public String blogView(Model model) {
        List<Blog> blogs = blogService.list();
        model.addAttribute("blogs", blogs);
        return "blog/list";
    }

    @GetMapping("/blogs/new")
    public String createForm(Model model) {
        model.addAttribute("blog", new BlogForm());
        return "blog/form";
    }

    @PostMapping("/blogs")
    public String create(@ModelAttribute BlogForm blogForm) {
        blogService.create(blogForm);
        return "redirect:/blogs";
    }

    @GetMapping("/blogs/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        Blog blog = blogService.detail(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }
    
    @GetMapping("/blogs/{id}/edit")
    public String editform(@PathVariable("id") int id, Model model) {
    	Blog blog = blogService.detail(id);
    	BlogForm blogForm = new BlogForm();
    	blogForm.setTitle(blog.getTitle());
    	blogForm.setContent(blog.getContent());
    	model.addAttribute("blog", blogForm);
    	return "blog/form";
    }
    
    @PostMapping("/blogs/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute BlogForm blogForm) {
        blogService.update(id, blogForm);
        return "redirect:/blogs";
    }

    @PostMapping("/blogs/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        blogService.delete(id);
        return "redirect:/blogs";
    }

}
