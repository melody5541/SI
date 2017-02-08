package com.hsbc.srbp.commonMsg.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SiJdbcInboundPoller {


	private SiJdbcInboundPoller() {
	}

	/**
	 * Load the Spring Integration Application Context
	 *
	 * @param args
	 *            - command line arguments
	 */
	public static void main(final String... args) {

		final AbstractApplicationContext context = new ClassPathXmlApplicationContext("jdbcInboundApplicationContext.xml");

	}
}
