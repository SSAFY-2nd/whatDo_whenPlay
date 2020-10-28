package com.ssafy.play;

import java.util.Arrays;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.play.interceptor.JwtInterceptor;

@SpringBootApplication
@MapperScan(basePackages = { "com.ssafy.play.mapper" })
public class PlayApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(PlayApplication.class, args);
	}
	@Autowired
	private JwtInterceptor jwtInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor).addPathPatterns("/play/**")
				.excludePathPatterns(Arrays.asList("/play/signup/**"))
				.excludePathPatterns(Arrays.asList("/play/login/**"))
				.excludePathPatterns(Arrays.asList("/play/user/**"));
	}
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*")
				.exposedHeaders("jwt-auth-token");
	}


}
