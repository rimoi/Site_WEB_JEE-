package daos;

import java.util.Vector;
import java.sql.ResultSet;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import beans.Asna;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

@RequestScoped
@ManagedBean
public class AsnaDao {
	
	Asna asna = new Asna();
	
	public Asna getAsna() {
		return asna;
	}

	public void setAsna(Asna asna) {
		this.asna = asna;
	}

	public AsnaDao() {

	}
 
	public Vector<Asna> liste_ann3() {
		Vector<Asna> lesAnn=new Vector<Asna>();
		Asna asna=null;
		try{ 
			
			Statement st= (Statement) Connexion.getConnx().createStatement();		
		    String req="SELECT * FROM  asna ORDER BY id DESC LIMIT 3";
	        ResultSet rs= st.executeQuery(req);
	while (rs.next()) {
		 asna =new Asna(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"));
		lesAnn.add(asna);
	}
	}catch(Exception e){
		System.out.println(e.getMessage());}
		return lesAnn;		
	}
	
	public String get_ann(int id) {

		try {
			
			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from asna where id="+id;
			
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				asna.setId(rs.getInt("id"));
				asna.setNom(rs.getString("nom"));
				asna.setPrenom(rs.getString("prenom"));
				 
				System.out.println("id: "+asna.getId());
				System.out.println("nom: "+asna.getNom());
				System.out.println("prenom: "+asna.getPrenom());
			}
			

		} catch (Exception e) {
			System.out.println("Erreur: "+e.getMessage());
		}

		return "ModifAnnonce";

	}

	public Vector<Asna> liste_ann() {
		Vector<Asna> lesAnn = new Vector<Asna>();
		Asna asn = null;
		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from asna order by id desc";
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				asn = new Asna(rs.getInt("id"), rs.getString("nom"),
						rs.getString("prenom"));
				lesAnn.add(asn);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lesAnn;

	}

	public String Insert(Asna asn) {

		try {

			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
					.prepareStatement(
							"insert into asna(nom,prenom) values(?,?)");

			st.setString(1, asn.getNom());
			st.setString(2, asn.getPrenom());
			st.executeUpdate();

			FacesMessage mess = new FacesMessage("L'ajout est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, mess);

		} catch (Exception e) {
			System.out.println("N'est pas Ajout�: " + e.getMessage());
		}
		return "GestAnnonces";

	}

	public void Delete(int id) {

		try {

			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
					.prepareStatement("delete from asna where id=?");

			st.setInt(1, id);
			st.executeUpdate();

			FacesMessage messa = new FacesMessage(
					"La suppression est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, messa);

		} catch (Exception e) {
			System.out.println("Erroooooooooooooooooor: " + e.getMessage());
		}

	}

	public String Update() {

		try {

			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
					.prepareStatement("update asna set nom=?, prenom=? where id=?");
			System.out.println("updte");
			System.out.println(asna.getId());
			System.out.println(asna.getNom());
             
			st.setString(1, asna.getNom());
			st.setString(2, asna.getPrenom());
			st.setInt(3, asna.getId());
			st.executeUpdate();
			
			System.out.println("id ann: "+asna.getId());
			System.out.println("Titre ann: "+asna.getNom());
			System.out.println("Intitule ann: "+asna.getPrenom());
		
			FacesMessage message = new FacesMessage(
					"La modification est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			System.out.println("Erreur Update"+e.getMessage());
		}
		return "GestAnnonces";

	}

}
