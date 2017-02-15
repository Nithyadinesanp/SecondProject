package com.niit.collaboration_backend_master.dao;

import java.util.List;

import com.niit.collaboration_backend_master.model.Blog;
import com.niit.collaboration_backend_master.model.Comment;

public interface BlogDao {

	void create(Blog blog);
	
	void update(Blog blog);
	
	void remove(Blog blog);
	
	Blog getBlogById(long blogId);
	
	List<Blog> listNewBlogs();
	
	List<Blog> listApprovedBlogs();
	
	List<Comment> getCommentsByBlogId(long blogId);
	
	void makeComment(Comment comment);
	
}