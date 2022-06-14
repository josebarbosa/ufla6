package br.com.josebarbosa.jsonxml.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	private Integer id;
	private String content;
	private String description;
	private String title; 
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date createdAt;
	@JsonManagedReference
	private List<Comment> comments = new ArrayList<>();
}
