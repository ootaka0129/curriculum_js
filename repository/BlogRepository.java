package com.example.blog.repository;

import java.util.List;

import com.example.blog.entity.Blog;

public interface BlogRepository {
	
    public List<Blog> findAll();
    
    public void save(Blog blog);
    
    public Blog findById(int id);
    
    public void update(Blog blog);
    
    public void delete(int id);
    
}
