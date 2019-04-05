package app.attractionfinder.webapp.common.config;

import app.attractionfinder.webapp.common.repository.TagRepository;
import app.attractionfinder.webapp.common.repository.TagRepositoryDatabaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RepositoryConfig {
	@Bean
	public TagRepository tagRepository(final JdbcTemplate jdbcTemplate) {
		return new TagRepositoryDatabaseImpl(jdbcTemplate);
	}
}
