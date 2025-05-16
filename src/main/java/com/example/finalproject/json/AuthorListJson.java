package com.example.finalproject.json;

import java.util.ArrayList;
import java.util.List;

import com.example.finalproject.model.Author;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AuthorListJson {
	private long id;
	private String authorname;
	private String biography;
	
	
	public static AuthorListJson packJson(Author author) {
		AuthorListJson authorListJson=new AuthorListJson();
		authorListJson.setId(author.getId());
		authorListJson.setAuthorname(author.getAuthorName());
		authorListJson.setBiography(author.getBiography());
		return authorListJson;
		
	}
	public static List<AuthorListJson> packJsons(List<Author> authors){
		List<AuthorListJson> authorListJson = new ArrayList<AuthorListJson>();
		for(Author author : authors) {
			authorListJson.add(packJson(author));
		}
		return authorListJson;
	}
}
