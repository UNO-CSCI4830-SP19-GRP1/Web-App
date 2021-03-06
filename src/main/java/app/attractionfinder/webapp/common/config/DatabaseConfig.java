package app.attractionfinder.webapp.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	@Profile({"local", "ci"}) // Heroku and Spring handle the DEV/PROD database for us.
	public DataSource localDataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setName("testdb;DATABASE_TO_UPPER=false;MODE=PostgreSQL").build();
	}
}
