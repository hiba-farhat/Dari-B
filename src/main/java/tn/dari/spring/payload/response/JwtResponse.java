package tn.dari.spring.payload.response;

import java.util.List;

import lombok.Data;
import lombok.Getter;
@Data

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private List<String> roles;
	private boolean stateUser;
	private String nom;
	private String prenom;
	private String tel;

	public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles,boolean stateUser
			,String nom,String prenom,String tel) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.stateUser=stateUser;
		this.nom=nom;
		this.prenom=prenom;
		this.tel=tel;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}
