package br.com.josebarbosa.jsonxml.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import br.com.josebarbosa.jsonxml.utils.RequestResponseLogginInterceptor;

@Configuration
public class RestTemplateConfiguration {

	@Bean
	public RestTemplate createRestTemplate() {
		
		ClientHttpRequestFactory factory = 
				new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
		
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new RequestResponseLogginInterceptor());
		
		RestTemplate restTemplate = new RestTemplate(factory);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}
}
