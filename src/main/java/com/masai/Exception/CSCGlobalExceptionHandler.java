package com.masai.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class CSCGlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CSCErrorDetails> exception(Exception e, WebRequest wr){
		
		CSCErrorDetails ed = new CSCErrorDetails();
		ed.setMessage(e.getMessage());
		ed.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(CSCException.class)
	public ResponseEntity<CSCErrorDetails> CSCException(CSCException e, WebRequest wr){
		
		CSCErrorDetails ed = new CSCErrorDetails();
		ed.setMessage(e.getMessage());
		ed.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CSCErrorDetails> MethodArgExceptionHandler(MethodArgumentNotValidException m){
		CSCErrorDetails details = new CSCErrorDetails();


        details.setMessage("Validation Error");
        details.setDescription(m.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

	
	
	@ExceptionHandler(CallException.class)
	public ResponseEntity<CSCErrorDetails> CallException(CallException e, WebRequest wr){
		
		CSCErrorDetails ed = new CSCErrorDetails();
		ed.setMessage(e.getMessage());
		ed.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<CSCErrorDetails> CustomerException(CustomerException e, WebRequest wr){
		
		CSCErrorDetails ed = new CSCErrorDetails();
		ed.setMessage(e.getMessage());
		ed.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(DepartmentException.class)
	public ResponseEntity<CSCErrorDetails> DepartmentException(DepartmentException e, WebRequest wr){
		
		CSCErrorDetails ed = new CSCErrorDetails();
		ed.setMessage(e.getMessage());
		ed.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@ExceptionHandler(IssueException.class)
	public ResponseEntity<CSCErrorDetails> IssueException(IssueException e, WebRequest wr){
		
		CSCErrorDetails ed = new CSCErrorDetails();
		ed.setMessage(e.getMessage());
		ed.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<CSCErrorDetails> LoginException(LoginException e, WebRequest wr){
		
		CSCErrorDetails ed = new CSCErrorDetails();
		ed.setMessage(e.getMessage());
		ed.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(OperatorException.class)
	public ResponseEntity<CSCErrorDetails> OperatorException(OperatorException e, WebRequest wr){
		
		CSCErrorDetails ed = new CSCErrorDetails();
		ed.setMessage(e.getMessage());
		ed.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(SolutionException.class)
	public ResponseEntity<CSCErrorDetails> SolutionException(SolutionException e, WebRequest wr){
		
		CSCErrorDetails ed = new CSCErrorDetails();
		ed.setMessage(e.getMessage());
		ed.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
		
	}
	




}
