package com.niit.collaboration_backend_master.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration_backend_master.model.AppliedJob;
import com.niit.collaboration_backend_master.model.Job;

@Repository("jobDao")
@EnableTransactionManagement
@Transactional
public class JobDaoImpl implements JobDao {

	@Autowired
	SessionFactory sessionFactory;

	public void add(Job job) {
		sessionFactory.getCurrentSession().saveOrUpdate(job);
	}

	public void update(Job job) {
		sessionFactory.getCurrentSession().saveOrUpdate(job);
	}

	public Job getJobById(long jobId) {
		String hql = "from Job where jobId=" + jobId;
		Job job = (Job) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		return job;
	}

	@SuppressWarnings("unchecked")
	public List<Job> listJobs() {
		String hql = "from Job";
		List<Job> jobs = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return jobs;
	}

	public void saveAppliedJob(AppliedJob appliedJob) {
		sessionFactory.getCurrentSession().saveOrUpdate(appliedJob);
	}

	@SuppressWarnings("unchecked")
	public List<AppliedJob> listAppliedJobs(long userId) {
		String hql = "from AppliedJob where userId=" + userId;
		List<AppliedJob> jobsApplied = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return jobsApplied;
	}
}
