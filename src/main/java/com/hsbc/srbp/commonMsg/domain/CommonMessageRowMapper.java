package com.hsbc.srbp.commonMsg.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

public class CommonMessageRowMapper implements RowMapper<CommonMessage> {

    public CommonMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
        String message_name = rs.getString("message_name");
        String message_status = rs.getString("message_status");
        String message_content = rs.getString("message_content");
        Timestamp message_createdatetime = rs.getTimestamp("message_create_date_time");
        int message_id = rs.getInt("message_id");
        CommonMessage commonMessage = new CommonMessage();
        commonMessage.setMessage_id(message_id);
        commonMessage.setMessage_content(message_content);
        commonMessage.setMessage_createdatetime(message_createdatetime);
        commonMessage.setMessage_name(message_name);
        commonMessage.setMessage_status(message_status);
        return commonMessage;
    }

}
