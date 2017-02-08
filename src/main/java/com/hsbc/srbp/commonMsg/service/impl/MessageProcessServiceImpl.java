package com.hsbc.srbp.commonMsg.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hsbc.srbp.commonMsg.domain.CommonMessage;
import com.hsbc.srbp.commonMsg.service.MessageProcessService;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, readOnly = false, transactionManager = "processorTxnManager")
public class MessageProcessServiceImpl implements MessageProcessService {
	private static Logger logger = Logger.getLogger(MessageProcessServiceImpl.class);
	
	private AtomicInteger counter = new AtomicInteger();
	@Async
	public void processMessage(CommonMessage msg) throws Exception {
		int count = counter.incrementAndGet();
		logger.info("********start process "+count+" msg async**********");
		logger.info("********start process "+count+" msg sleep**********");
		Thread.sleep(1000000);
		logger.info("********start process "+count+" msg wake up**********");
		logger.info("********end process "+count+" msg async**********");

	}

}
