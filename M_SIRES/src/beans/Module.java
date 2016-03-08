package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean
@RequestScoped
public class Module {
	
	 private String id;
	 private String intitule;
	 private String vol_hor;
	 private String semestre;
	 private String id_ens;
	 
	 private String nom_ens;
	 
	
	public String getNom_ens() {
		return nom_ens;
	}
	public void setNom_ens(String nom_ens) {
		this.nom_ens = nom_ens;
	}
	public Module() {
	}
	public Module(String id, String intitule, String vol_hor, String semestre,
			String id_ens) {
		
		this.id = id;
		this.intitule = intitule;
		this.vol_hor = vol_hor;
		this.semestre = semestre;
		this.id_ens = id_ens;
	}
	public Module(String string, String intitule, String vol_hor, String semestre,
			String id_ens,String nom_ens ) {
		
		this.id = string;
		this.intitule = intitule;
		this.vol_hor = vol_hor;
		this.semestre = semestre;
		this.id_ens = id_ens;
		this.nom_ens = nom_ens;
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
	public String getVol_hor() {
		return vol_hor;
	}
	public void setVol_hor(String vol_hor) {
		this.vol_hor = vol_hor;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getId_ens() {
		return id_ens;
	}
	public void setId_ens(String id_ens) {
		this.id_ens = id_ens;
	}
}
