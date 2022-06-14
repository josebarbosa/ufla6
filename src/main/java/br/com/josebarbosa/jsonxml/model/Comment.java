package br.com.josebarbosa.jsonxml.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date createdAt;
	private String text; 
	@JsonBackReference
	private Post post;
}
