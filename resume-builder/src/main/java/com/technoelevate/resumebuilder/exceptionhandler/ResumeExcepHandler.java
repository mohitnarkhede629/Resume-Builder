package com.technoelevate.resumebuilder.exceptionhandler;

import static com.technoelevate.resumebuilder.constants.ResumeConstants.SOMETHING_WENT_WRONG;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.technoelevate.resumebuilder.customexception.EmployeeIdNotFoundException;
import com.technoelevate.resumebuilder.response.Response;
import com.technoelevate.resumebuilder.response.ValidationResponse;

@RestControllerAdvice
public class ResumeExcepHandler {
	

	@ExceptionHandler(EmployeeIdNotFoundException.class)
	public ResponseEntity<Response> employeeIdNotFoundException(EmployeeIdNotFoundException e){
		
		return new ResponseEntity<>(new Response(true, e.getMessage(), null),HttpStatus.BAD_REQUEST);
		
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> exception(Exception e){
		
		return new ResponseEntity<>(new Response(true,SOMETHING_WENT_WRONG, null),HttpStatus.BAD_REQUEST);
		
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationResponse> validationFailed(MethodArgumentNotValidException e ){
		List<String> list = e.getBindingResult().getFieldErrors().stream().map(t -> t.getDefaultMessage()).toList();
		return new ResponseEntity<>(new ValidationResponse(false,list),HttpStatus.BAD_REQUEST);
	}
	
}

