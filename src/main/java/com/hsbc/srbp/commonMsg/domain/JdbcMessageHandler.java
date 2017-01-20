package com.hsbc.srbp.commonMsg.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

public class JdbcMessageHandler {
	private static Logger logger = Logger.getLogger(JdbcMessageHandler.class);

	private AtomicInteger counter = new AtomicInteger();

	public void handleMessage(Message<?> message) throws Exception {
		if (message.getPayload() instanceof ArrayList<?>) {
			int count = counter.incrementAndGet();
			List<CommonMessage> list = (List<CommonMessage>) message.getPayload();
			logger.info("Current Thread:" + Thread.currentThread().getName() + " sleeping in #"+count+" poll");
			Thread.sleep(5000);
			logger.info("Current Thread:" + Thread.currentThread().getName() + " waking up in #"+count+" poll");
			for (CommonMessage msg : list) {
				logger.info(Thread.currentThread().getName() + " prepared message #" + count + " for message #"
						+ msg.getMessage_id() + ": " + msg);
			}
		} else {
			throw new Exception("message not a instance of CommonMessage");
		}

	}
}
