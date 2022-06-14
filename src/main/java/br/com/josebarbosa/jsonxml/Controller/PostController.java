package br.com.josebarbosa.jsonxml.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.josebarbosa.jsonxml.model.Comment;
import br.com.josebarbosa.jsonxml.model.Post;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
	private static List<Post> allPost = initPots();

    private static List<Post> initPots(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Post post1 = null;
        Comment comment1 = null;
        Comment comment2 = null;
        try {
        comment1 = Comment.builder()
                .createdAt(simpleDateFormat.parse("20/01/2021 13:10"))
                .id(1)
                .text("How to start learning flutter and spring?")
                .build();
            comment2 = Comment.builder()
                    .createdAt(simpleDateFormat.parse("22/01/2021 13:10"))
                    .id(2)
                    .text("Which one is better React Native or Flutter?")
                    .build();
             post1 = Post.builder()
            		 .id(1)
                    .createdAt(simpleDateFormat.parse("20/01/2021 13:10"))
                    .title("How to build apps in Flutter")
                    .content("Flutter is awesome so is Spring Boot")
                    .comments(Arrays.asList(comment1, comment2))
                    .build();
            comment1.setPost(post1);
            comment2.setPost(post1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Post> postList = new ArrayList<>();
        postList.add(post1);
        return postList;
    }

    @RequestMapping(value="/xml", method= RequestMethod.POST, 
    		produces = MediaType.APPLICATION_XML_VALUE,
    		consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> addPostXML(@RequestBody Post post){
    	PostController.initPots().add(post);
    	return ResponseEntity.status(HttpStatus.OK).body(post); 
    }
    
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllPost(){
		return ResponseEntity.ok(PostController.initPots());
	}
	@RequestMapping(value="/postxml", method= RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<?> getAllPostXML(){
		return ResponseEntity.ok(PostController.initPots());
	}
	
	
	
}
