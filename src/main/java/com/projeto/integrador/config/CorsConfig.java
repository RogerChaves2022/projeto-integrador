/*
 * package com.projeto.integrador.config;
 * 
 * import java.util.List;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.web.cors.CorsConfiguration; import
 * org.springframework.web.cors.UrlBasedCorsConfigurationSource; import
 * org.springframework.web.filter.CorsFilter;
 * 
 * @Configuration public class CorsConfig {
 * 
 * @Bean public CorsFilter corsFilter() { CorsConfiguration corsConfiguration =
 * new CorsConfiguration(); corsConfiguration.setAllowedOrigins(List.of("*"));
 * // //Substitua pela origem do seu aplicativo front-end
 * corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
 * corsConfiguration.setAllowCredentials(true);
 * 
 * UrlBasedCorsConfigurationSource source = new
 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
 * corsConfiguration);
 * 
 * return new CorsFilter(source); } }
 */