package app.attractionfinder.webapp.ui;

import app.attractionfinder.webapp.common.dao.TagDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UiConfig {
	@Bean
	public UiHandler uiHandler(final TagDao tagDao) {
		return new UiHandler(tagDao);
	}

	@Bean
	public UiController uiController(final UiHandler uiHandler) {
		return new UiController(uiHandler);
	}
}
