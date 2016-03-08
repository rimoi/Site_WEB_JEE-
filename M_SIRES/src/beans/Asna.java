package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@RequestScoped
@ManagedBean
public class Asna {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String cin;
	
	
	
	public Asna() {
	
	}
	public Asna(int id, String nom, String prenom) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
