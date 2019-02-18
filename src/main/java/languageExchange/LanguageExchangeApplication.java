package languageExchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LanguageExchangeApplication {
//	private static final String PROPERTIES = "spring.config.location=classpath:/google.yml";
//	private static final String AP_PROPERTIES = "spring.config.location=classpath:/application.properties";

	public static void main(String[] args) {
//		new SpringApplicationBuilder(LanguageExchangeApplication.class)
//				.properties(PROPERTIES)
//				.properties(AP_PROPERTIES)
//				.build()
//				.run(args);
		SpringApplication.run(LanguageExchangeApplication.class, args);
	}
}