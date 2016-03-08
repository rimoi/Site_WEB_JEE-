package beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@RequestScoped
public class Etudiant {
	private String id;
	private String nom;
	private String prenom;
	private String email;
	private String id_prom;
	
	private String promo;
	
	
	public String getId_prom() {
		return id_prom;
	}


	public void setId_prom(String id_prom) {
		this.id_prom = id_prom;
	}


	public String getPromo() {
		return promo;
	}


	public void setPromo(String promo) {
		this.promo = promo;
	}


	
	
	
	public Etudiant() {
	}


	public Etudiant(String id, String nom, String prenom, String email,
			String id_prom) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.id_prom = id_prom;
		
	}
	public Etudiant(String id, String nom, String prenom, String email,
			String id_prom,String promo) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.id_prom = id_prom;
		this.promo = promo;
		
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
}
