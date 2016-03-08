package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Emploi {
	
	 private String id;
	 private String emploi;
	 private String semestre;
	 
		public Emploi() {
			
		}
		
	public Emploi(String id, String emploi, String semestre) {
			this.id = id;
			this.emploi = emploi;
			this.semestre = semestre;
		}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmploi() {
		return emploi;
	}
	public String setEmploi(String emploi) {
		return this.emploi = emploi;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	 
	 
	 
	

}
