package com.hsbc.srbp.commonMsg.domain;

public class CommonMsg {
    private int msg_id;
    private String msg_name;
    private String msg_content;
    private String msg_createdatetime;
    private String msg_status;


    public int getMsg_id() {
		return msg_id;
	}


	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}

	public String getMsg_name() {
		return msg_name;
	}

	public void setMsg_name(String msg_name) {
		this.msg_name = msg_name;
	}

	public String getMsg_content() {
		return msg_content;
	}

	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}

	
	public String getMsg_createdatetime() {
		return msg_createdatetime;
	}


	public void setMsg_createdatetime(String msg_createdatetime) {
		this.msg_createdatetime = msg_createdatetime;
	}


	public String getMsg_status() {
		return msg_status;
	}

	public void setMsg_status(String msg_status) {
		this.msg_status = msg_status;
	}



	public String toString() {
        StringBuilder sb = new StringBuilder("msg_id: ");
        sb.append(msg_id).append(", msg_name: ").append(msg_name).append(", msg_content: ")
                .append(msg_content).append(", msg_createdatetime: ").append(msg_createdatetime)
                .append(", msg_status:").append(msg_status);
        return sb.toString();
    }
}
