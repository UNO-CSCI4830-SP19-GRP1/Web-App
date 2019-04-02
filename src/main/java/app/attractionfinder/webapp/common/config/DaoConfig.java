package app.attractionfinder.webapp.common.config;

import app.attractionfinder.webapp.common.dao.TagDao;
import app.attractionfinder.webapp.common.dao.TagDaoMapImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {
	@Bean
	public TagDao tagDao() {
		return new TagDaoMapImpl();
	}
}
