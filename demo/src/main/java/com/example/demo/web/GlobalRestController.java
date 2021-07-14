package com.example.demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ControllerAdvice
public class GlobalRestController {
	

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {ResourceNotFoundException.class})
	public String notFound(RuntimeException exception) {
		return exception.getMessage();
	}
	

}
