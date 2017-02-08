package com.hsbc.srbp.commonMsg.service;

import com.hsbc.srbp.commonMsg.domain.CommonMessage;

public interface MessageProcessService {
	public void processMessage(CommonMessage msg) throws Exception;
}
