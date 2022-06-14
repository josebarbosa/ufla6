package br.com.josebarbosa.jsonxml.Controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.josebarbosa.jsonxml.model.Article;
import br.com.josebarbosa.jsonxml.service.ArticleService;

@RestController
@RequestMapping(value="/articles")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;

	@GetMapping
	public ResponseEntity<List<Article>> getAllArticles(){		
		return ResponseEntity.ok(this.articleService.retrieveAllArticles()); 
	}
	
	@PostMapping
	public ResponseEntity<?> createArticle(@RequestBody Article article){
		Article createdArticle = this.articleService.createArticle(article);
		return ResponseEntity.ok(createdArticle); 
	}
	
}
