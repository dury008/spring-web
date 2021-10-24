package kr.ko.dury008.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerCronConfiguration {
	@Autowired
	GlobalConfig config;
	
	@Bean
	public String schedulerCronExample1() {
		return config.getSchedulerCronExample1();
	}
}
