package kr.ko.dury008.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 어노테이션을 붙이고 클래스 내에 하나 이상의 @Bean 메소드를 구현하면 스프링 컨테이너가 Bean 정의를 생성하고 런타임 시 그 Bean 들의 요청을 처리할 것을 선언
public class DatabaseConfiguration {
	
	
	@ConfigurationProperties(prefix = "spring.datasource") //외부 설정 파일(application.properties)를 참조할때 쓰는 방법 중 하나 
	//@Bean이 붙은 메소드에 붙여주면 Datasource 에 바인딩을 할 수 있다.
	//Datasource가 application.properties에 spring.datasource 로 시작되는 값들을 참조해서 사용
	@Bean
	public DataSource dataSource() { //커넥션풀의 커넥션을 관리하기 위한 객체
		return DataSourceBuilder.create().build();
		
	}
}
