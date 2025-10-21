package com.lvnr.demo.micro.producto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class resTemplateConfig {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
