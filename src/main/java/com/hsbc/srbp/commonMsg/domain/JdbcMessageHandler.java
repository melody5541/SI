package com.hsbc.srbp.commonMsg.domain;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

public class JdbcMessageHandler {
	private static Logger logger = Logger.getLogger(JdbcMessageHandler.class);
	
	private AtomicInteger hotDrinkCounter = new AtomicInteger();
	
    public void handleMessage(CommonMsg commonMsg) {
        try {
			Thread.sleep(5000);
			logger.info(Thread.currentThread().getName()
					+ " prepared msg #" + hotDrinkCounter.incrementAndGet() + " for message #"
					+ commonMsg.getMsg_id() + ": " + commonMsg);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
    }
}
