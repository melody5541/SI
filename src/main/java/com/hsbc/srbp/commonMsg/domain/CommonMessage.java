package com.hsbc.srbp.commonMsg.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class CommonMessage implements Serializable{
    private int message_id;
    private String message_name;
    private String message_content;
    private Timestamp message_createdatetime;
    private Timestamp message_updatedatetime;
    private String message_status;


	public Timestamp getMessage_updatedatetime() {
		return message_updatedatetime;
	}

	public void setMessage_updatedatetime(Timestamp message_updatedatetime) {
		this.message_updatedatetime = message_updatedatetime;
	}

	public int getMessage_id() {
		return message_id;
	}


	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}


	public String getMessage_name() {
		return message_name;
	}


	public void setMessage_name(String message_name) {
		this.message_name = message_name;
	}


	public String getMessage_content() {
		return message_content;
	}


	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}


	public Timestamp getMessage_createdatetime() {
		return message_createdatetime;
	}


	public void setMessage_createdatetime(Timestamp message_createdatetime) {
		this.message_createdatetime = message_createdatetime;
	}


	public String getMessage_status() {
		return message_status;
	}


	public void setMessage_status(String message_status) {
		this.message_status = message_status;
	}


	public String toString() {
        StringBuilder sb = new StringBuilder("message_id: ");
        sb.append(message_id).append(", message_name: ").append(message_name).append(", message_content: ")
                .append(message_content).append(", message_createdatetime: ").append(message_createdatetime)
                .append(", message_updatedatetime: ").append(message_updatedatetime)
                .append(", message_status:").append(message_status);
        return sb.toString();
    }
}
