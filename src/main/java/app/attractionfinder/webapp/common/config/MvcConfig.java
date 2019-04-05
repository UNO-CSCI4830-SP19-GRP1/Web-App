package app.attractionfinder.webapp.common.config;

import app.attractionfinder.webapp.common.mvc.advice.exception.GlobalControllerExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {
	@Bean
	public GlobalControllerExceptionHandler globalControllerExceptionHandler() {
		return new GlobalControllerExceptionHandler();
	}
}
