package kr.ko.dury008.framework.web.bind.annnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestConfig { //RequeesConfig 어노테이션 생성
	boolean loginCheck() default true; //로그인 세션이 구현되있으면 true로 바꾼다
	
}
