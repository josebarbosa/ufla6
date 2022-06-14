package br.com.josebarbosa.jsonxml.model;


import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Generated("jsonschema2pojo")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

	@SerializedName("createdAt")
	@Expose
	private String createdAt;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("id")
	@Expose
	private String id;
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

}