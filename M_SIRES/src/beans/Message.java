package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean


public class Message {
	private String id;
	private String nom;
	private String email;
	private String message;
	
	
	public Message() {
		
	}
	public Message(String id, String nom, String email, String message) {
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.message = message;
	}
	
	
	public Message(String nom, String email, String message) {
		super();
		this.nom = nom;
		this.email = email;
		this.message = message;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
