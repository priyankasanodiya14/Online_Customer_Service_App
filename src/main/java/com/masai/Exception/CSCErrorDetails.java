package com.masai.Exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CSCErrorDetails {

	String Message;
	String Description;
	LocalDateTime ldt = LocalDateTime.now();

}
