package com.hsbc.srbp.commonMsg.test;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hsbc.srbp.commonMsg.domain.CommonMsg;
import com.hsbc.srbp.commonMsg.service.CommonMsgService;

public class SiJdbcInboundPoller {
	
	private static final Logger LOGGER = Logger.getLogger(Main.class);

	private SiJdbcInboundPoller() { }

	/**
	 * Load the Spring Integration Application Context
	 *
	 * @param args - command line arguments
	 */
	public static void main(final String... args) {

		LOGGER.info("\n========================================================="
				  + "\n                                                         "
				  + "\n          Welcome to Spring SiJdbcInboundPoller!                 "
				  + "\n                                                         "
				  + "\n                                                         "
				  + "\n=========================================================" );

		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("poller.xml");

		context.registerShutdownHook();

		final Scanner scanner = new Scanner(System.in);


		final CommonMsgService MessageService = context.getBean(CommonMsgService.class);

		LOGGER.info("\n========================================================="
				  + "\n                                                         "
				  + "\n    Please press 'q + Enter' to quit the application.    "
				  + "\n                                                         "
				  + "\n=========================================================" );

		System.out.println("Please enter a choice and press <enter>: ");
		System.out.println("\t1. Create a new Message detail");
		System.out.println("\tq. Quit the application");
		System.out.print("Enter you choice: ");
		while (true) {
			final String input = scanner.nextLine();
			if("1".equals(input.trim())) {
				createMessageDetails(scanner, MessageService);
			} else if("q".equals(input.trim())) {
				break;
			} else {
				System.out.println("Invalid choice\n\n");
			}

			System.out.println("Please enter a choice and press <enter>: ");
			System.out.println("\t1. Create a new Message detail");
			System.out.println("\tq. Quit the application");
			System.out.print("Enter you choice: ");
		}

		LOGGER.info("Exiting application...bye.");

		System.exit(0);

	}

	private static void createMessageDetails(final Scanner scanner,CommonMsgService service) {
		while(true) {
			System.out.print("\nEnter the Message's name:");
			String msgName = scanner.nextLine();
			System.out.print("\nEnter the Message's content:");
			String content = scanner.nextLine();

			CommonMsg message = new CommonMsg();
			message.setMsg_content(content);
			message.setMsg_name(msgName);
			message = service.createCommonMsg(message);
			System.out.println("Created Message record with id: " + message);
			System.out.print("Do you want to create another Message? (y/n)");
			String choice  = scanner.nextLine();
			if(!"y".equalsIgnoreCase(choice))
				break;
		}
	}
}
