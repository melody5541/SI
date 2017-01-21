package com.hsbc.srbp.commonMsg.domain;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

public class JdbcMessageHandler {
	private static Logger logger = Logger.getLogger(JdbcMessageHandler.class);

	private AtomicInteger counter = new AtomicInteger();
	
	
	public void handleMessage(Message<?> message) throws Exception {
			int count = counter.incrementAndGet();
			List<CommonMessage> list = (List<CommonMessage>) message.getPayload();
			for (CommonMessage msg : list) {
				if(msg.getMessage_name().equals("name1")){
					logger.info("Current Thread:" + Thread.currentThread().getName() + " simulater throws exception and sleeping with "+count+" poll");
					Thread.sleep(10000);
					throw new SQLException("simulater throws exception");
				}
				logger.info(Thread.currentThread().getName() + " handle message #" + msg.getMessage_id() + ": " + msg);
			}
	}
}
