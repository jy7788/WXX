package com.cn.hnust.quartz;

import org.quartz.JobExecutionException;

import com.cn.hnust.kit.kit.DuplicateMessageKit;

public class ClearMessageTask {
	public void clearMessage()
			throws JobExecutionException {
		DuplicateMessageKit.clear();
	}
}
