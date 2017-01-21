package com.hsbc.srbp.commonMsg.test;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.SubscribableChannel;

public class SiJdbcInboundAutoOneByOne {

    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "jdbcInboundApplicationContext.xml");
        MessageChannel channel = context.getBean("msgQueryOutputChannel",MessageChannel.class);
        if(channel instanceof SubscribableChannel){
        	System.out.println(true);
        }
    }
    
}
