package app.attractionfinder.webapp.api;

import app.attractionfinder.webapp.common.repository.AttractionRepository;
import app.attractionfinder.webapp.common.repository.TagRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
	@Bean
	public ApiHandler apiHandler(TagRepository tagRepo, AttractionRepository attractionRepo) {
		return new ApiHandler(tagRepo, attractionRepo);
	}

	@Bean
	public ApiController apiController(ApiHandler apiHandler) {
		return new ApiController(apiHandler);
	}
}
