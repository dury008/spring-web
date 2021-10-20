package kr.ko.dury008.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 어노테이션을 붙이고 클래스 내에 하나 이상의 @Bean 메소드를 구현하면 스프링 컨테이너가 Bean 정의를 생성하고 런타임 시 그 Bean 들의 요청을 처리할 것을 선언
@MapperScan("kr.ko.dury008.mvc.repository") //연결할 DAO인터페이스를 담은 패키지 등록
public class MybatisConfiguration { //mybatis와 db를 연결하는 설정
	
	
	
	@Bean //mybatis와 db를 연결해주는 객체
	public SqlSessionFactory sqlSessionFactory(@Autowired DataSource dataSource, ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean(); //sqlsessionFactory를 생성해주는 클래스
		factoryBean.setDataSource(dataSource);
		factoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/sql/*.xml"));
		SqlSessionFactory  factory = factoryBean.getObject();
		factory.getConfiguration().setMapUnderscoreToCamelCase(true);	
		return factoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(@Autowired SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
