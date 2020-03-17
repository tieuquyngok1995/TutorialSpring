package org.java.hellorestful.controller;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
	
	
	@Bean
	public RestTemplate restTemplate() {
//		RestTemplate rt = new RestTemplate();
//		ClientHttpRequestInterceptor inter = new ClientHttpRequestInterceptor() {
//			
//			@Override
//			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
//					throws IOException {
//				 HttpHeaders headers = request.getHeaders();
//				   	headers.add("Content-Type", "application/json");
//				    return execution.execute(request, body);
//			}
//		};
//		rt.setInterceptors(Arrays.asList(inter));
		return new RestTemplate();
		}

}
