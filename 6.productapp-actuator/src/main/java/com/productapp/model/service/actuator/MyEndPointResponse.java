package com.productapp.model.service.actuator;

public class MyEndPointResponse {
	private int id;
	private String name;
	private String statusMsg;
	private boolean status;

	public MyEndPointResponse() {
	}

	public MyEndPointResponse(String name, String statusMsg, boolean status) {
		this.name = name;
		this.statusMsg = statusMsg;
		this.status = status;
	}

	public MyEndPointResponse(int id, String name, String statusMsg, boolean status) {
		this.id = id;
		this.name = name;
		this.statusMsg = statusMsg;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyEndPointResponse [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", statusMsg=");
		builder.append(statusMsg);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
