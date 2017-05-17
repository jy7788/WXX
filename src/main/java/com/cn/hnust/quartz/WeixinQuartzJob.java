package com.cn.hnust.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class WeixinQuartzJob extends QuartzJobBean {
	private RefreshAccessTokenTask refreshAccessTokenTask;
	private RefreshJsApiTicketTask refreshJsApiTicketTask;
	public void setRefreshAccessTokenTask(
			RefreshAccessTokenTask refreshAccessTokenTask, RefreshJsApiTicketTask refreshJsApiTicketTask) {
		this.refreshAccessTokenTask = refreshAccessTokenTask;
		this.refreshJsApiTicketTask = refreshJsApiTicketTask;
	}

	protected void executeInternal(JobExecutionContext ctx)
			throws JobExecutionException {
		refreshAccessTokenTask.refreshToken();
		refreshJsApiTicketTask.refreshJsapiTicket();
	}

}
