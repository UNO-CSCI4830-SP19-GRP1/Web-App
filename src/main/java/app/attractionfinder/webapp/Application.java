package app.attractionfinder.webapp;

import app.attractionfinder.webapp.api.ApiConfig;
import app.attractionfinder.webapp.common.config.DaoConfig;
import app.attractionfinder.webapp.common.config.DatabaseConfig;
import app.attractionfinder.webapp.common.config.MvcConfig;
import app.attractionfinder.webapp.ui.UiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@Configuration
@Import({ApiConfig.class, DaoConfig.class, DatabaseConfig.class, MvcConfig.class, UiConfig.class})
public class Application {
	public static void main(final String[] args) {
		final SpringApplication app = setupApp();
		app.run(args);
	}

	private static SpringApplication setupApp() {
		final SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(Application.class);

		String appEnv = System.getenv("APP_ENV");
		if((appEnv == null) || appEnv.isEmpty()) {
			appEnv = "local";
		}

		appBuilder.profiles(appEnv);
		return appBuilder.build();
	}
}