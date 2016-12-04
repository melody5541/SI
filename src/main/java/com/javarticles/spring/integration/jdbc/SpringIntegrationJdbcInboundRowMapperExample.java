package com.javarticles.spring.integration.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

public class SpringIntegrationJdbcInboundRowMapperExample {

    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "jdbcInboundApplicationContext.xml");
        PollableChannel inputChannel = context.getBean("dataChannel1", PollableChannel.class);
		inputChannel.send(new GenericMessage<String>("World"));
		inputChannel.receive().getPayload();
        Thread.sleep(1000);
        context.close();
    }
    
}
