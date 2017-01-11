package com.hsbc.srbp.commonMsg.domain;

import java.util.List;

public class JdbcMessageHandler {
    public void handleMessage(List<CommonMsg> commonMsg) {
        System.out.println("In JdbcMessageHandler:" + commonMsg);
    }
}
