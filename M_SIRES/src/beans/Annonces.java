package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@RequestScoped
@ManagedBean
public class Annonces {
	private String id;
	private String titre;
	private String intitule;
	
	
	
	public Annonces() {
	
	}
	public Annonces(String id, String titre, String intitule) {
		
		this.id = id;
		this.titre = titre;
		this.intitule = intitule;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
}
