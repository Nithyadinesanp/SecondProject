package com.niit.collaboration_backend_master.dao;

import java.util.List;

import com.niit.collaboration_backend_master.model.AppliedJob;
import com.niit.collaboration_backend_master.model.Job;

public interface JobDao {

	void add(Job job);
	
	void update(Job job);
	
	Job getJobById(long jobId);
	
	List<Job> listJobs();
	
	List<AppliedJob> listAppliedJobs(long userId);
	
	void saveAppliedJob(AppliedJob appliedJob);
	
}
