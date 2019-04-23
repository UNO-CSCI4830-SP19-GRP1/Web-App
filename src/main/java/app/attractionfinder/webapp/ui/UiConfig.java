package app.attractionfinder.webapp.ui;

import app.attractionfinder.webapp.common.repository.AttractionRepository;
import app.attractionfinder.webapp.common.repository.AttractionTagRepository;
import app.attractionfinder.webapp.common.repository.TagRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UiConfig {
	@Bean
	public UiHandler uiHandler(final TagRepository tagRepository,
							   final AttractionRepository attractionRepository,
							   final AttractionTagRepository attractionTagRepository) {
		return new UiHandler(tagRepository, attractionRepository, attractionTagRepository);
	}

	@Bean
	public UiController uiController(final UiHandler uiHandler) {
		return new UiController(uiHandler);
	}
}
