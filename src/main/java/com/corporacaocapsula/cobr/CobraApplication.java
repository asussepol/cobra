package com.corporacaocapsula.cobr;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class CobraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CobraApplication.class, args);
	}
	
	@Bean
	public FixedLocaleResolver localeResolver(){
		
		return new FixedLocaleResolver(new Locale("pt","BR"));
	}
	
}
