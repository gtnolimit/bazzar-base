package com.bazzar.base.job.batch;

import java.util.Map;

public abstract class Job {

	public abstract void execute(Map<Object, Object> params);

}
