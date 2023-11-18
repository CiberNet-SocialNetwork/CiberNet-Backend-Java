package org.cibertec.edu.pe.dto;

import lombok.Data;

@Data
public class ResponseDTO {
	private int statusCode;
	private String message;
	private boolean isError;
	private Object data;
}
