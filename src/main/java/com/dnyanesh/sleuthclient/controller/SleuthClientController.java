package com.dnyanesh.sleuthclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/rest/hello")
public class SleuthClientController {

	private static Logger LOGGER = LoggerFactory.getLogger(SleuthClientController.class);

	@Autowired
	RestTemplate restTemplate;

	@Value("${server.port}")
	private String port;

	@GetMapping("/client")
	@Timed(value = "sleuth-client-hello-req", histogram = true, extraTags = { "version", "1.0" })
	public String hello() {

		LOGGER.info("Before the calling Server :: In Client");
		String response = restTemplate.getForObject("http://localhost:9090/server/rest/hello/server", String.class);
		LOGGER.info("After Server the calling service :: In Client");
		return "Client Port: "+port+response;

		//return "Response from port: " + port;
	}
}
