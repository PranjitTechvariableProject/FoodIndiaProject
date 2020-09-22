package com.techVariable.FoodIndia.response;

public class ApiResponse<T>
{
	private boolean success;
	private String message;
	private int reponseCode;
	private T data;
	
	public ApiResponse(boolean success, String message, int reponseCode, T data) 
	{
		this.success = success;
		this.message = message;
		this.reponseCode = reponseCode;
		this.data = data;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getReponseCode() {
		return reponseCode;
	}
	public void setReponseCode(int reponseCode) {
		this.reponseCode = reponseCode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
