package kr.ko.dury008.configuration.exception;

import kr.ko.dury008.configuration.http.BaseResponseCode;

public abstract class AbstractBaseException extends RuntimeException { //커스텀으로 예외클래스를 생성

	  private static final long serialVersionUID = 8342235231880246631L;
	  
	  protected BaseResponseCode responseCode;
	  protected Object[] args;
	  
	  public AbstractBaseException() {
	  }
	  
	  public AbstractBaseException(BaseResponseCode responseCode) {
	  	this.responseCode = responseCode;
	  }
	  
	  public BaseResponseCode getResponseCode() {
	  	return responseCode;
	  }
	  
	  public Object[] getArgs() {
	  	return args;
	  }
}
