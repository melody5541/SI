package com.hsbc.srbp.commonMsg.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

public class JdbcMessageStore {


	private JdbcMessageStore() {
	}

	/**
	 * Load the Spring Integration Application Context
	 * @param <T>
	 *
	 * @param args
	 *            - command line arguments
	 */
	public static void main(final String... args) {

		final AbstractApplicationContext context = new ClassPathXmlApplicationContext("jdbcMessageStoreApplicationContext.xml");
		MessageChannel channel = context.getBean("inputChannel",QueueChannel.class);
		MessageChannel channel1 = context.getBean("outputChannel",DirectChannel.class);
		for(int i=0;i<10;i++){
			channel.send(new GenericMessage<String>("hello"));
		}
		for(int i=0;i<10;i++){
			channel.send(new GenericMessage<String>("world"));
		}
	}
}
