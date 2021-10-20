package kr.ko.dury008.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.ko.dury008.configuration.servlet.handler.BaseHandlerInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer{
	
	
	@Bean //다국어 프로퍼티를 사용하기위한 아래 메세지 소스를 빈으로 등록
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasename("classpath:/messages/message");
		source.setDefaultEncoding("UTF-8");
		source.setCacheSeconds(60);
		source.setDefaultLocale(Locale.KOREAN);
		source.setUseCodeAsDefaultMessage(true);
		return source;
			
	}
	
	@Bean public BaseHandlerInterceptor baseHandlerInterceptor() { 
		return new BaseHandlerInterceptor(); 
		}

	@Override public void addInterceptors(InterceptorRegistry registry) { 
		registry.addInterceptor(baseHandlerInterceptor()); 
		}
}
