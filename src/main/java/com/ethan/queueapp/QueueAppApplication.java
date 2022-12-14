package com.ethan.queueapp;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class QueueAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueueAppApplication.class, args);
	}

	// @Bean
	// public WebMvcConfigurer corsConfigurer() {
	// 	return new WebMvcConfigurer() {
	// 		@Override
	// 		public void addCorsMappings(CorsRegistry registry) {
	// 			registry.addMapping("/**").allowedOrigins("http://localhost:4200")
    //                       .allowedMethods("PUT", "DELETE", "GET", "POST", "OPTIONS");
	// 		}
	// 	};
	// }

	@Bean
	public CorsFilter corsFilter() {
	CorsConfiguration corsConfiguration = new CorsConfiguration();
	corsConfiguration.setAllowCredentials(true);
	corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:5173"));
	corsConfiguration.setAllowedHeaders(Arrays.asList("Origin",
	"Access-Control-Allow-Origin", "Content-Type",
	"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
	"Access-Control-Request-Method", "Access-Control-Request-Headers"));
	corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type",
	"Accept", "Authorization",
	"Access-Control-Allow-Origin", "Access-Control-Allow-Origin",
	"Access-Control-Allow-Credentials"));
	corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT",
	"DELETE", "OPTIONS"));
	UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new
	UrlBasedCorsConfigurationSource();
	urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",
	corsConfiguration);
	System.out.println("asdflaksdfjafs");
	return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
