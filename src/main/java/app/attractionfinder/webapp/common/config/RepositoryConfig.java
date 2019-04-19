package app.attractionfinder.webapp.common.config;

import app.attractionfinder.webapp.common.repository.AttractionRepository;
import app.attractionfinder.webapp.common.repository.AttractionRepositoryDatabaseImpl;
import app.attractionfinder.webapp.common.repository.TagRepository;
import app.attractionfinder.webapp.common.repository.TagRepositoryDatabaseImpl;
import app.attractionfinder.webapp.common.repository.AttractionTagRepository;
import app.attractionfinder.webapp.common.repository.AttractionTagDatabaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RepositoryConfig {
	@Bean
	public TagRepository tagRepository(final JdbcTemplate jdbcTemplate) {
		return new TagRepositoryDatabaseImpl(jdbcTemplate);
	}

	@Bean
	public AttractionRepository attractionRepository(final JdbcTemplate jdbcTemplate) {
		return new AttractionRepositoryDatabaseImpl(jdbcTemplate);
	}

	@Bean
	public AttractionTagRepository attractionTagRepository(final JdbcTemplate jdbcTemplate) {
		return new AttractionTagDatabaseImpl(jdbcTemplate);
	}

}
