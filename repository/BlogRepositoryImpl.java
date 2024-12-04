package com.example.blog.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.blog.entity.Blog;
import com.example.blog.util.DatabaseUtil;

@Repository
public class BlogRepositoryImpl implements BlogRepository {
	
    @Autowired
    private DatabaseUtil databaseUtil;
    private String POSTGRES_DRIVER = "org.postgresql.Driver";
    List<Blog> blogList = new ArrayList<>();
    
    Connection connection = null;
    Statement statement = null;
    ResultSet result = null;
    PreparedStatement pstatement = null;

    @Override
    public List<Blog> findAll() {
        try{
        	 Class.forName(POSTGRES_DRIVER);
        	 connection = this.databaseUtil.getConnection();
             statement = connection.createStatement();
             String sql = "SELECT * FROM blog WHERE deleted_at IS NULL ORDER BY id DESC";
             result = statement.executeQuery(sql);

            while (result.next()) {
                Blog blog = new Blog();
                blog.setId(result.getInt("id"));
                blog.setTitle(result.getString("title"));
                blog.setContent(result.getString("content"));
                blog.setCreatedAt(result.getTimestamp("created_at").toLocalDateTime());
                blog.setUpdatedAt(result.getTimestamp("updated_at").toLocalDateTime());
                Timestamp deletedTimestamp = result.getTimestamp("deleted_at");
                LocalDateTime deletedAt = null;//あらかじめ値を空にしてLocalDataTime型にしてから値を代入する
                if (deletedTimestamp != null) {
                    deletedAt = deletedTimestamp.toLocalDateTime();
                }
                blog.setDeletedAt(deletedAt);
                blogList.add(blog);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
        	try {
        		if(result != null) {
        			result.close();
        		}
        		if(statement != null) {
        			statement.close();
        		}
        		if(connection != null) {
        			connection.close();
        		}
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
        }
        return blogList;
    }

    @Override
    public void save(Blog blog) {
        try{
        	 Class.forName(POSTGRES_DRIVER);
        	 connection = this.databaseUtil.getConnection();
        	 String sql = "INSERT INTO blog (title, content, created_at) VALUES (?, ?, CURRENT_TIMESTAMP)";
             pstatement = connection.prepareStatement(sql);

             pstatement.setString(1, blog.getTitle());
             pstatement.setString(2, blog.getContent());
             pstatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
        	try {
        		if(statement != null) {
        			statement.close();
        		}
        		if(connection != null) {
        			connection.close();
        		}
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
        }
    }

    @Override
    public Blog findById(int id) {
        try {
        	Class.forName(POSTGRES_DRIVER);
        	connection = this.databaseUtil.getConnection();
        	String sql = "SELECT * FROM blog WHERE id = ? AND deleted_at IS NULL";
            pstatement = connection.prepareStatement(sql);
            pstatement.setInt(1, id);
            result = pstatement.executeQuery();
            
                if (result.next()) {
                    Blog blog = new Blog();
                    
                    blog.setId(result.getInt("id"));
                    blog.setTitle(result.getString("title"));
                    blog.setContent(result.getString("content"));
                    blog.setCreatedAt(result.getTimestamp("created_at").toLocalDateTime());
                    blog.setUpdatedAt(result.getTimestamp("updated_at").toLocalDateTime());
                    Timestamp deletedAtTimestamp = result.getTimestamp("deleted_at");
                    LocalDateTime deletedAt = null;
                    if (deletedAtTimestamp != null) {
                        deletedAt = deletedAtTimestamp.toLocalDateTime();
                    }
                    blog.setDeletedAt(deletedAt);
                    return blog;
                }
                
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
        	try {
        		if(result != null) {
        			result.close();
        		}
        		if(statement != null) {
        			statement.close();
        		}
        		if(connection != null) {
        			connection.close();
        		}
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
        }
        return null;
    }

    @Override
    public void update(Blog blog) {
        try {
        	Class.forName(POSTGRES_DRIVER);
        	connection = this.databaseUtil.getConnection();
        	String sql = "UPDATE blog SET title = ?, content = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ? AND deleted_at IS NULL";
            pstatement = connection.prepareStatement(sql);

            pstatement.setString(1, blog.getTitle());
            pstatement.setString(2, blog.getContent());
            pstatement.setInt(3, blog.getId());
            pstatement.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
        	try {
        		if(pstatement != null) {
        			pstatement.close();
        		}
        		if(connection != null) {
        			connection.close();
        		}
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
        }
    }

    @Override
    public void delete(int id) {
        try {
        	 Class.forName(POSTGRES_DRIVER);
        	 connection = this.databaseUtil.getConnection();
        	 String sql = "UPDATE blog SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?";
             pstatement = connection.prepareStatement(sql);
             pstatement.setInt(1, id);
             pstatement.executeUpdate();
             
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
        	try {
        		if(pstatement != null) {
        			pstatement.close();
        		}
        	    if(connection != null) {
        		    connection.close();
        	    }
        	 }catch(SQLException e) {
        		 e.printStackTrace();
        	 }
        }
    }
}
