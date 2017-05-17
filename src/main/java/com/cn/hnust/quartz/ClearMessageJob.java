package com.cn.hnust.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ClearMessageJob extends QuartzJobBean {
	private ClearMessageTask clearMessageTask;
	

	public ClearMessageTask getClearMessageTask() {
		return clearMessageTask;
	}

	public void setClearMessageTask(ClearMessageTask clearMessageTask) {
		this.clearMessageTask = clearMessageTask;
	}

	protected void executeInternal(JobExecutionContext ctx)
			throws JobExecutionException {
		clearMessageTask.clearMessage();
	}

}
