package com.hsbc.srbp.commonMsg.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

public class CommonMsgRowMapper implements RowMapper<CommonMsg> {

    public CommonMsg mapRow(ResultSet rs, int rowNum) throws SQLException {
        String msg_name = rs.getString("message_name");
        String msg_status = rs.getString("message_status");
        String msg_content = rs.getString("message_content");
        Timestamp msg_createdatetime = rs.getTimestamp("message_create_date_time");
        int msg_id = rs.getInt("message_id");
        CommonMsg commonMsg = new CommonMsg();
        commonMsg.setMsg_id(msg_id);
        commonMsg.setMsg_content(msg_content);
        commonMsg.setMsg_createdatetime(msg_createdatetime);
        commonMsg.setMsg_name(msg_name);
        commonMsg.setMsg_status(msg_status);
        return commonMsg;
    }

}
