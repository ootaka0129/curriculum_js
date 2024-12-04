package com.example.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.entity.Blog;
import com.example.blog.form.BlogForm;
import com.example.blog.repository.BlogRepository;

@Service
public class BlogService {
	@Autowired
    private BlogRepository blogRepository;

    public List<Blog> list() {
        return blogRepository.findAll();
    }
    
    public void create(BlogForm form) {
        Blog blog = new Blog();
        blog.setTitle(form.getTitle());
        blog.setContent(form.getContent());
        blogRepository.save(blog);
    }

    public Blog detail(int id) {
        return blogRepository.findById(id);
    }

    public void update(int id, BlogForm form) {
        Blog blog = blogRepository.findById(id);
        if (blog != null) {
            blog.setTitle(form.getTitle());
            blog.setContent(form.getContent());
            blogRepository.update(blog);
        }
    }
    public void delete(int id) {
        blogRepository.delete(id);
    }
}
