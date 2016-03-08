package daos;

import java.sql.ResultSet;
import java.util.Vector;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import beans.Etudiant;
import beans.Promotion;

import com.mysql.jdbc.Statement;

@ManagedBean
@RequestScoped

public class PromotionDao {
	
	
	Promotion promo= new Promotion();
	
	Etudiant etud=new Etudiant();

	public Etudiant getEtud() {
		return etud;
	}



	public void setEtud(Etudiant etud) {
		this.etud = etud;
	}



	public Vector<Etudiant> getLesEtud() {
		return lesEtud;
	}



	public void setLesEtud(Vector<Etudiant> lesEtud) {
		this.lesEtud = lesEtud;
	}


	Vector<Etudiant> lesEtud=new Vector<Etudiant>();
	
	Vector<String> lesPromo=new Vector<String>();
	


	public Vector<String> getLesPromo() {
		return lesPromo;
	}



	public void setLesPromo(Vector<String> lesPromo) {
		this.lesPromo = lesPromo;
	}



	public Promotion getPromo() {
		return promo;
	}



	public Vector<Promotion> liste_promo() {
		Vector<Promotion> lesPromo=new Vector<Promotion>();
		Promotion promo=null;
		try{ 
			
			Statement st= (Statement) Connexion.getConnx().createStatement();		
		String req="select distinct * from promotion";
	        ResultSet rs= st.executeQuery(req);
	while (rs.next()) {
		promo =new Promotion(rs.getString("id"),rs.getString("annee"));
		lesPromo.add(promo);
	}
	}catch(Exception e){
		System.out.println(e.getMessage());}
		return lesPromo;		
	}
	
	
	
public Vector<String> get_Promo() {

		
		try {
			
			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select annee from promotion";
			
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				
			
				lesPromo.add(rs.getString("annee"));
				
			}
			

		} catch (Exception e) {
			System.out.println("Erooooooooooooor: "+e.getMessage());
		}

		return lesPromo;

	}


public String listParPromotion(int id) {
	
	
	try{ 
		
		Statement st= (Statement) Connexion.getConnx().createStatement();		
	String req="select * from  etudiant where id_promo="+id;
        ResultSet rs= st.executeQuery(req);
while (rs.next()) {
	
	etud =new Etudiant(rs.getString("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("id_promo"));
	lesEtud.add(etud);
	
	
}
}catch(Exception e){
	System.out.println(e.getMessage());}

	System.out.println("*********************************************************");
	return "DetailPromo";	
	
}

}
