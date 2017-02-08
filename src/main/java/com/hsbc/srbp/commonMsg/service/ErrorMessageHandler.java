package com.hsbc.srbp.commonMsg.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;
import com.hsbc.srbp.commonMsg.domain.CommonMessage;
import com.hsbc.srbp.commonMsg.service.MessageProcessService;

public interface ErrorMessageHandler{

	public void handleMessage(Message<?> message) throws Exception;
}
