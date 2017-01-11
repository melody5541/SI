package com.hsbc.srbp.commonMsg.test;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SiJdbcInboundAutoOneByOne {

    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "jdbcInboundApplicationContext.xml");
    }
    
}
