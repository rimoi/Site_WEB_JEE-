package beans;

import java.sql.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean
@RequestScoped
public class Preinscription {
	private String id;
	private String nom;
	private String prenom;
	private String email;
	private String cin;
	private String ville;
	private String pays;
	private String adresse;
	private int tel;
	private String universite;
	private String mention;
	private String anne;
	private String autre;
	private String dernier;
	public int confirmer;
	public Preinscription(){}
	public Preinscription(String id, String nom, String prenom, String email,
			String cin, String ville, String pays, String adresse, int tel,
			String dernier, String universite, String mention,
			String anne, String autre, int confirmer) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.cin = cin;
		this.ville = ville;
		this.pays = pays;
		this.adresse = adresse;
		this.tel = tel;
		this.dernier = dernier;
		this.universite = universite;
		this.mention = mention;
		this.anne = anne;
		this.autre = autre;
		this.confirmer=confirmer;
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
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getDernier() {
		return dernier;
	}
	public void setDernier(String dernier) {
		this.dernier = dernier;
	}
	public String getUniversite() {
		return universite;
	}
	public void setUniversite(String universite) {
		this.universite = universite;
	}
	public String getMention() {
		return mention;
	}
	public void setMention(String mention) {
		this.mention = mention;
	}
	public String getAnne() {
		return anne;
	}
	public void setAnne(String anne) {
		this.anne = anne;
	}
	public String getAutre() {
		return autre;
	}
	public void setAutre(String autre) {
		this.autre = autre;
	}
	public int getConfirmer() {
		return 1;
	}
	public void setConfirmer(int confirmer) {
		this.confirmer = confirmer;
	}
	

}
