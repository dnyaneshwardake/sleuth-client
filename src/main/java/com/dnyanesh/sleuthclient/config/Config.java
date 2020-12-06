package com.dnyanesh.sleuthclient.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableEurekaClient
public class Config {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
