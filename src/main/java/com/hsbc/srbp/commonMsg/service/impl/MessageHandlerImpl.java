package com.hsbc.srbp.commonMsg.service.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;
import com.hsbc.srbp.commonMsg.domain.CommonMessage;
import com.hsbc.srbp.commonMsg.service.MessageHandler;
import com.hsbc.srbp.commonMsg.service.MessageProcessService;

public class MessageHandlerImpl implements MessageHandler{
	private static Logger logger = Logger.getLogger(MessageHandlerImpl.class);

	private AtomicInteger counter = new AtomicInteger();
	
	private MessageProcessService messageProcessService;
	
	//重点是这里因为MessageHandlerImpl和jdbc inbound adapter处于同一个线程如果线程池爆掉了必须抛出让SI去处理--》roll back transaction
	//如果在messageProcessService.processMessage(msg) try catch了exception那么就必须手动处理，虽然抛出了异常但是transaction依然commit
	public void handleMessage(Message<?> message) throws Exception {
		int count = counter.incrementAndGet();
		logger.info("#####start #"+count+" handleMessage#######");
		List<CommonMessage> list = (List<CommonMessage>) message.getPayload();
		for (CommonMessage msg : list) {
			logger.info(" process message start");
			messageProcessService.processMessage(msg);
			logger.info(" process message end");
		}
		logger.info("#####end #"+count+" handleMessage#######");
	}

	public void setMessageProcessService(MessageProcessService messageProcessService) {
		this.messageProcessService = messageProcessService;
	}
	
}
