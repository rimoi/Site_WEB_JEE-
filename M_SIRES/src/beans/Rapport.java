package beans;

import javax.faces.bean.RequestScoped;

@RequestScoped
public class Rapport {
	private String id;
	private String intitule;
	private String Rap;
	private String id_etudiant;
	
	private String emailEtud;
	
	
	public String getEmailEtud() {
		return emailEtud;
	}

	public void setEmailEtud(String emailEtud) {
		this.emailEtud = emailEtud;
	}

	public String getId_etudiant() {
		return id_etudiant;
	}

	public void setId_etudiant(String id_etudiant) {
		this.id_etudiant = id_etudiant;
	}

	public String getRap() {
		return Rap;
	}

	public String setRap(String rap) {
		return Rap = rap;
	}

	public Rapport() {
	}


	public Rapport(String id, String intitule, String rap, String id_etudiant,
			String emailEtud) {
		this.id = id;
		this.intitule = intitule;
		Rap = rap;
		this.id_etudiant = id_etudiant;
		this.emailEtud = emailEtud;
	}

	public Rapport(String id, String intitule, String rap) {
		super();
		this.id = id;
		this.intitule = intitule;
		Rap = rap;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	
	

}
