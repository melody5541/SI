package com.hsbc.srbp.commonMsg.domain;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Async;

public class Test {
	private static Logger logger = Logger.getLogger(JdbcMessageHandler.class);

	private AtomicInteger counter = new AtomicInteger();
	
	public void hand(Message<?> message) throws InterruptedException{
		logger.info("# "+counter.incrementAndGet()+" poll " +message);
		String p = (String) message.getPayload();
		if(p.equals("hello")){
			throw new RuntimeException("abc");
//			logger.info("sleep");
//			Thread.currentThread().sleep(50000);
//			logger.info("wake");
		}
		
	}
}
