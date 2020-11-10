package org.comfort.comfortapi.validation.config;

import java.util.ArrayList;
import java.util.List;

import org.comfort.comfortapi.validation.ErrorFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorValidationHandler {
	
	@Autowired
	private MessageSource messageSource;
	
   @ResponseStatus(code = HttpStatus.BAD_REQUEST)
   @ExceptionHandler(MethodArgumentNotValidException.class)
   public List<ErrorFormDto> handle(MethodArgumentNotValidException exception){
	   List<ErrorFormDto> listErrorDto = new ArrayList<ErrorFormDto>();
	   List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors();
	   
	   fieldErros.forEach(erro->{
		   String msg = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
		   ErrorFormDto errorFormDto = new ErrorFormDto(erro.getField(),msg);
		   listErrorDto.add(errorFormDto);
	   });
	   
	   return listErrorDto;
   }

}
