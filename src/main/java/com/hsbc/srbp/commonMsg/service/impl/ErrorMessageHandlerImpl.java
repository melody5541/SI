package com.hsbc.srbp.commonMsg.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;
import com.hsbc.srbp.commonMsg.service.MessageHandler;

public class ErrorMessageHandlerImpl implements MessageHandler{
	private static Logger logger = Logger.getLogger(ErrorMessageHandlerImpl.class);

	private AtomicInteger counter = new AtomicInteger();
	
	public void handleMessage(Message<?> message) throws Exception {
		logger.info(message);
	}

}
