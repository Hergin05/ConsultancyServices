package com.consultancy.dao;

import com.consultancy.model.Jobs;

public interface JobsDao 
{
	public boolean addJobs(Jobs jobs);
	public boolean updateJobs(Jobs jobs);
	public boolean deleteJobs(int jobId);

}
