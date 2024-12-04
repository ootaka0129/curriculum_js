package com.example.blog.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Blog {
	@Id
    private int id;
    private String title;
    private String content;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public LocalDateTime getUpdatedAt(){
    	return updatedAt;
    }
    public LocalDateTime getDeletedAt(){
        return deletedAt;
    }

    public void setId(int id) {
    	this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
    	this.createdAt = createdAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
    	this.updatedAt = updatedAt;
    }
    public void setDeletedAt(LocalDateTime deletedAt) {
    	this.deletedAt = deletedAt;
    }
}
