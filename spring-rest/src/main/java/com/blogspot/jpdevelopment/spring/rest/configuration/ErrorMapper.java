package com.blogspot.jpdevelopment.spring.rest.configuration;

import com.blogspot.jpdevelopment.spring.rest.core.domain.rest.domain.NoDataFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorMapper extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ErrorMapper.class);

	private static final HttpHeaders HEADERS = new HttpHeaders();
	static {
		HEADERS.setContentType(MediaType.APPLICATION_JSON);
	}

	@ExceptionHandler({NoDataFoundException.class})
	protected ResponseEntity<Object> handleNoDataFoundException(Exception e, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(e, request.getDescription(false));
		errorMessage.setCode(HttpStatus.NO_CONTENT.value());
		LOGGER.debug("No data found: {}", e.getMessage());

		return handleExceptionInternal(e, errorMessage, HEADERS, HttpStatus.NO_CONTENT, request);
	}

	@ExceptionHandler({Exception.class})
	protected ResponseEntity<Object> handleDefaultException(Exception e, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(e, request.getDescription(false));
		errorMessage.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		LOGGER.warn("Cought an exception from REST layer", e);

		return handleExceptionInternal(e, errorMessage, HEADERS, HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
