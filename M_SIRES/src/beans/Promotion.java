package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean
@RequestScoped
public class Promotion {
	private String id;
	private String annee;
		
	
	public Promotion() {
	}
	public Promotion(String id, String annee) {
	
		this.id = id;
		this.annee = annee;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	

}
