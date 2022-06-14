package br.com.josebarbosa.jsonxml.utils;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestResponseLogginInterceptor implements ClientHttpRequestInterceptor{

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		logRequest(request, body);
		ClientHttpResponse response = execution.execute(request, body);
		return response;
	}
	
	private void logRequest(HttpRequest request, byte[] body) throws IOException{
		log.debug("Request begin...");
		log.debug("URI       : {} ", request.getURI());
		log.debug("Method    : {} ", request.getMethod());
		log.debug("Header    : {} ", request.getHeaders());
		log.debug("Body      : {} ", new String(body, "UTF-8"));
		log.debug("Request ends.");
	}
	
	private void logResponse(ClientHttpResponse response) throws IOException{
		log.debug("Response begins...");
		log.debug("Status code: {}", response.getStatusCode());
		log.debug("Response body: {} ", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
	}
	
}
