package com.hsbc.srbp.commonMsg.test;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hsbc.srbp.commonMsg.domain.CommonMessage;
import com.hsbc.srbp.commonMsg.service.CommonMessageService;

public class SiJdbcInboundManualInput {

	private SiJdbcInboundManualInput() {
	}

	/**
	 * Load the Spring Integration Application Context
	 *
	 * @param args
	 *            - command line arguments
	 */
	public static void main(final String... args) {

		final AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"SiJdbcInboundManualInput.xml");

		context.registerShutdownHook();

		final Scanner scanner = new Scanner(System.in);

		final CommonMessageService commonMessageService = context.getBean(CommonMessageService.class);

		System.out.println("\n========================================================="
				+ "\n                                                         "
				+ "\n    Please press 'q + Enter' to quit the application.    "
				+ "\n                                                         "
				+ "\n=========================================================");

		System.out.println("Please enter a choice and press <enter>: ");
		System.out.println("\t1. Create a new message detail");
		System.out.println("\tq. Quit the application");
		System.out.print("Enter you choice: ");
		while (true) {
			final String input = scanner.nextLine();
			if ("1".equals(input.trim())) {
				createMessageDetails(scanner, commonMessageService, context);
			} else if ("q".equals(input.trim())) {
				break;
			} else {
				System.out.println("Invalid choice\n\n");
			}

			System.out.println("Please enter a choice and press <enter>: ");
			System.out.println("\t1. Create a new message detail");
			System.out.println("\tq. Quit the application");
			System.out.print("Enter you choice: ");
		}

		System.out.println("Exiting application....");

		System.exit(0);

	}

	private static void createMessageDetails(final Scanner scanner, CommonMessageService service,
			AbstractApplicationContext context) {
		while (true) {
			System.out.print("\nEnter the Message`s name:");
			String message_name = scanner.nextLine();
			System.out.print("\nEnter the Message`s content:");
			String message_content = scanner.nextLine();
			System.out.print("\nEnter the Message`s status:");
			String message_status = scanner.nextLine();
			CommonMessage message = new CommonMessage();
			message.setMessage_name(message_name);
			message.setMessage_status(message_status);
			message.setMessage_content(message_content);
			message = service.createCommonMessage(message);
			System.out.println("Created message record with name: " + message);
			System.out.print("Do you want to create another message? (y/n)");
			String choice = scanner.nextLine();
			if (!"y".equalsIgnoreCase(choice))
				break;
		}
	}
}
