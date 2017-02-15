package com.niit.collaboration_backend_master.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration_backend_master.model.Blog;
import com.niit.collaboration_backend_master.model.Comment;

@Repository("blogDao")
@EnableTransactionManagement
@Transactional
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;

	public void create(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}

	public void update(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}

	public Blog getBlogById(long blogId) {
		String hql = "from Blog where blogId=" + blogId;
		Blog blog = null;
		try {
			blog = (Blog) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace(System.err);
		}
		return blog;
	}

	public void remove(Blog blog) {
		sessionFactory.getCurrentSession().delete(blog);
	}

	@SuppressWarnings("unchecked")
	public List<Blog> listNewBlogs() {
		List<Blog> blogs = sessionFactory.getCurrentSession().createQuery("from Blog where status='NEW'").getResultList();
		return blogs;
	}

	@SuppressWarnings("unchecked")
	public List<Blog> listApprovedBlogs() {
		List<Blog> blogs = sessionFactory.getCurrentSession().createQuery("from Blog where status='APPROVED'").getResultList();
		return blogs;
	}

	@SuppressWarnings("unchecked")
	public List<Comment> getCommentsByBlogId(long blogId) {
		String hql = "from Comment where blogId=" + blogId;
		List<Comment> comments = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return comments;
	}

	public void makeComment(Comment comment) {
		sessionFactory.getCurrentSession().saveOrUpdate(comment);
	}
}
