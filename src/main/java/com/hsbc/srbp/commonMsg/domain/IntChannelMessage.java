package com.hsbc.srbp.commonMsg.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Blob;

public class IntChannelMessage implements Serializable{
    private String message_id;
    private String group_key;
    private BigInteger created_date;
    private int message_priority;
    private BigInteger message_sequence;
    private Blob message_bytes;
    private String region;
	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	public String getGroup_key() {
		return group_key;
	}
	public void setGroup_key(String group_key) {
		this.group_key = group_key;
	}
	public BigInteger getCreated_date() {
		return created_date;
	}
	public void setCreated_date(BigInteger created_date) {
		this.created_date = created_date;
	}
	public int getMessage_priority() {
		return message_priority;
	}
	public void setMessage_priority(int message_priority) {
		this.message_priority = message_priority;
	}
	public BigInteger getMessage_sequence() {
		return message_sequence;
	}
	public void setMessage_sequence(BigInteger message_sequence) {
		this.message_sequence = message_sequence;
	}
	public Blob getMessage_bytes() {
		return message_bytes;
	}
	public void setMessage_bytes(Blob message_bytes) {
		this.message_bytes = message_bytes;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	@Override
	public String toString() {
		return "IntChannelMessage [message_id=" + message_id + ", group_key=" + group_key + ", created_date="
				+ created_date + ", message_priority=" + message_priority + ", message_sequence=" + message_sequence
				+ ", message_bytes=" + message_bytes + ", region=" + region + "]";
	}
    
}
