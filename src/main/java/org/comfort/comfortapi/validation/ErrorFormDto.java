package org.comfort.comfortapi.validation;

public class ErrorFormDto {
	
	
	private String field;
	private String msg;
	
	
	
	
	public ErrorFormDto(String field, String msg) {
		super();
		this.field = field;
		this.msg = msg;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	

}
