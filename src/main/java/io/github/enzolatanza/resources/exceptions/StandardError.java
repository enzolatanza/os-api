package io.github.enzolatanza.resources.exceptions;

public class StandardError {
	private Long timestamp; //momento que ocorreu o erro
	private Integer status;//valor do erro
	private String error;//recebe o erro
	public StandardError() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StandardError(Long timestamp, Integer status, String error) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
}
