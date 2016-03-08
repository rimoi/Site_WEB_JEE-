package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@RequestScoped
public class Enseignant {
	private String id;
	private String nom;
	private String prenom;
	private String email;
	private String num_tel;
	private String ville;
	private String profilsCours;

	
	
	
	public Enseignant() {
	}
	public Enseignant(String id, String nom, String prenom, String email,
			String num_tel, String ville, String profilsCours) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.num_tel = num_tel;
		this.ville = ville;
		this.profilsCours = profilsCours;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}
	public String getProfilsCours() {
		return profilsCours;
	}
	public void setProfilsCours(String profilsCours) {
		this.profilsCours = profilsCours;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
}
