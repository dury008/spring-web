package kr.ko.dury008.configuration.web.bind.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import kr.ko.dury008.configuration.exception.BaseException;
import kr.ko.dury008.configuration.http.BaseResponse;

@ControllerAdvice 
public class BaseControllerAdvice {// 예외가 발생하는 케이스에 대하여 정의하는클래스

	  @Autowired
	  private MessageSource messageSource;

		@ExceptionHandler(value = { BaseException.class })
		@ResponseStatus(HttpStatus.OK)
		@ResponseBody
		private BaseResponse<String> handleBaseException(BaseException e, WebRequest request) { // 컨트롤러,서비스,비즈니스 로직에서 예외가 발생할때 BaseException예외가 발생하면 해당 메소드가 실행된다
			return new BaseResponse<String>(e.getResponseCode(), messageSource.getMessage(e.getResponseCode().name(), e.getArgs(),null));
		}	
	}