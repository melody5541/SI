/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hsbc.srbp.commonMsg.test;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.PollableChannel;

import com.hsbc.srbp.commonMsg.domain.CommonMsg;
import com.hsbc.srbp.commonMsg.service.CommonMsgService;


public final class Main {

	private Main() { }

	/**
	 * Load the Spring Integration Application Context
	 *
	 * @param args - command line arguments
	 */
	public static void main(final String... args) {


		final AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"jdbcInboundApplicationContext.xml");

		context.registerShutdownHook();

		final Scanner scanner = new Scanner(System.in);


		final CommonMsgService commonMsgService = context.getBean(CommonMsgService.class);

		System.out.println("\n========================================================="
				  + "\n                                                         "
				  + "\n    Please press 'q + Enter' to quit the application.    "
				  + "\n                                                         "
				  + "\n=========================================================" );

		System.out.println("Please enter a choice and press <enter>: ");
		System.out.println("\t1. Create a new msg detail");
		System.out.println("\tq. Quit the application");
		System.out.print("Enter you choice: ");
		while (true) {
			final String input = scanner.nextLine();
			if("1".equals(input.trim())) {
				createMsgDetails(scanner,commonMsgService,context);
			} else if("q".equals(input.trim())) {
				break;
			} else {
				System.out.println("Invalid choice\n\n");
			}

			System.out.println("Please enter a choice and press <enter>: ");
			System.out.println("\t1. Create a new msg detail");
			System.out.println("\tq. Quit the application");
			System.out.print("Enter you choice: ");
		}

		System.out.println("Exiting application....");

		System.exit(0);

	}

	private static void createMsgDetails(final Scanner scanner,CommonMsgService service,AbstractApplicationContext context) {
		while(true) {
			System.out.print("\nEnter the Msg`s name:");
			String msg_name = scanner.nextLine();
			System.out.print("\nEnter the Msg`s content:");
			String msg_content = scanner.nextLine();
			System.out.print("\nEnter the Msg`s status:");
			String msg_status = scanner.nextLine();
			CommonMsg msg = new CommonMsg();
			msg.setMsg_name(msg_name);
			msg.setMsg_status(msg_status);
			msg.setMsg_content(msg_content);
			msg = service.createCommonMsg(msg);
			System.out.println("Created msg record with name: " + msg);
			System.out.print("Do you want to create another msg? (y/n)");
			String choice  = scanner.nextLine();
			if(!"y".equalsIgnoreCase(choice))
				break;
		}
	}
	
}
