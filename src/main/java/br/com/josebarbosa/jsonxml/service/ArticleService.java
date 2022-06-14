package br.com.josebarbosa.jsonxml.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.josebarbosa.jsonxml.model.Article;

@Service
public class ArticleService {
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Article> retrieveAllArticles(){
		List<Article> articles = new ArrayList<>();
		Article[] allArticles = this.restTemplate.getForObject("https://62a8b721943591102ba876aa.mockapi.io/articles", 
				Article[].class);
		articles.addAll(Arrays.asList(allArticles));
		return articles; 
	}
	
	public Article createArticle(Article article) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON); 
		HttpEntity request = new HttpEntity(article, headers);
		
		Article articleCreated = this.restTemplate.postForObject(
				"https://62a8b721943591102ba876aa.mockapi.io/articles",
				request, Article.class);
		return articleCreated; 
		
	}
}
