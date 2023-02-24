package com.capg.ipl.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler{
	@Value(value="${message1}")
	private String message1;
	
	@Value(value="${message2}")
	private String message2;
	
	@Value(value="${message3}")
	private String message3;
	
	@Value(value="${message4}")
	private String message4;
	
	@Value(value="${message5}")
	private String message5;
	
	@Value(value="${message6}")
	private String message6;
	
	@Value(value="${message7}")
	private String message7;
	
	@Value(value="${message8}")
	private String message8;
	
	@Value(value="${message9}")
	private String message9;
	
	@Value(value="${message10}")
	private String message10;
	
	@Value(value="${message11}")
	private String message11;
	
	@Value(value="${message12}")
	private String message12;
	
	@Value(value="${message13}")
	private String message13;
	
	
	@ExceptionHandler(value=InvalidAdminException.class)
	public ResponseEntity<Object> InvalidAdminException  (InvalidAdminException ex) {
		return new ResponseEntity<>(message1,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=MatchAlreadyInProgressException.class)
	public ResponseEntity<Object>  MatchAlreadyInProgressException(MatchAlreadyInProgressException ex) {
		return new ResponseEntity<>(message2,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=TeamNotFoundException.class)
	public ResponseEntity<Object> TeamNotFoundException(TeamNotFoundException ex) {
		return new ResponseEntity<>(message3,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=TeamAlreadyExistException.class)
	public ResponseEntity<Object> TeamAlreadyExistException(TeamAlreadyExistException ex) {
		return new ResponseEntity<>(message4,HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(value=MatchNotFoundException.class)
	public ResponseEntity<Object> MatchNotFoundException(MatchNotFoundException ex) {
		return new ResponseEntity<>(message5,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=BiddingNotStartedException.class)
	public ResponseEntity<Object> BiddingNotStartedException(BiddingNotStartedException ex) {
		return new ResponseEntity<>(message6,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=BidderNotFoundException.class)
	public ResponseEntity<Object> BidderNotFoundExceptio(BidderNotFoundException ex) {
		return new ResponseEntity<>(message7,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=BidAlreadyExistException.class)
	public ResponseEntity<Object> BidAlreadyExistException(BidAlreadyExistException ex) {
		return new ResponseEntity<>(message8,HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(value=UserAlreadyExistException.class)
	public ResponseEntity<Object> UserAlreadyExistException(UserAlreadyExistException ex) {
		return new ResponseEntity<>(message9,HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<Object> UserNotFoundException(UserNotFoundException ex) {
		return new ResponseEntity<>(message10,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=BidNotFoundException.class)
	public ResponseEntity<Object> BidNotFoundException(BidNotFoundException ex) {
		return new ResponseEntity<>(message11,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=MatchAlreadyExistsException.class)
	public ResponseEntity<Object> MatchAlreadyExistsException(MatchAlreadyExistsException ex) {
		return new ResponseEntity<>(message12,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=MatchNotStartedException.class)
	public ResponseEntity<Object> MatchNotStartedException(MatchNotStartedException ex) {
		return new ResponseEntity<>(message13,HttpStatus.NOT_FOUND);
	}
	
	
}
