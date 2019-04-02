package app.attractionfinder.webapp.common.config;

import app.attractionfinder.webapp.common.mvc.advice.exception.GlobalControllerExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class MvcConfig {
	@Bean
	public GlobalControllerExceptionHandler globalControllerExceptionHandler() {
		return new GlobalControllerExceptionHandler();
	}

	//	@Bean
	//	public Jaxb2RootElementHttpMessageConverter addHttpMessageConverter() {
	//		return new Jaxb2RootElementHttpMessageConverter();
	//	}
}
