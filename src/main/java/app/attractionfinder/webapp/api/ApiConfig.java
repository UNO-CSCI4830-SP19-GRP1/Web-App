package app.attractionfinder.webapp.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
	@Bean
	public ApiController apiController() {
		return new ApiController();
	}
}
