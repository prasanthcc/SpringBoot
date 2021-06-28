package com.spring.data.controller.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    public ErrorResponse(int value, String message) {
		// TODO Auto-generated constructor stub
    	this.status = value;
    	this.message=message;
	}
	private final int status;
    private final String message;
    private  String stackTrace;
    
    
  

	public String getStackTrace() {
		return stackTrace;
	}
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	
    

   
}