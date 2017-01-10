package com.javarticles.spring.integration.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

public class SpringIntegrationJdbcInboundRowMapperExample {

    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "jdbcInboundApplicationContext.xml");
//        PollableChannel inputChannel = context.getBean("dataChannel", PollableChannel.class);
//		inputChannel.send(new GenericMessage<String>("World"));
//		inputChannel.receive().getPayload();
//        context.start();
        MessageChannel inputChannel = context.getBean("insertChannel", MessageChannel.class);
        inputChannel.send(new GenericMessage<String>("World"));
    }
    
}
