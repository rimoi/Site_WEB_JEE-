package daos;

import java.util.Vector;
import java.sql.ResultSet;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import beans.Annonces;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

@RequestScoped
@ManagedBean
public class AnnonceDao {
	
	Annonces annonce = new Annonces();
	
	public Annonces getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonces annonce) {
		this.annonce = annonce;
	}

	public AnnonceDao() {

	}
 
	public Vector<Annonces> liste_ann3() {
		Vector<Annonces> lesAnn=new Vector<Annonces>();
		Annonces ann=null;
		try{ 
			
			Statement st= (Statement) Connexion.getConnx().createStatement();		
		    String req="SELECT * FROM  annonce ORDER BY id DESC LIMIT 3";
	        ResultSet rs= st.executeQuery(req);
	while (rs.next()) {
		 ann =new Annonces(rs.getString("id"),rs.getString("titre"),rs.getString("intitule"));
		lesAnn.add(ann);
	}
	}catch(Exception e){
		System.out.println(e.getMessage());}
		return lesAnn;		
	}
	
	public String get_ann(int id) {

		try {
			
			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from annonce where id="+id;
			
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				annonce.setId(rs.getString("id"));
				annonce.setTitre(rs.getString("titre"));
				annonce.setIntitule(rs.getString("intitule"));
				 
				System.out.println("id: "+annonce.getId());
				System.out.println("Titre: "+annonce.getTitre());
				System.out.println("INTitule: "+annonce.getIntitule());
			}
			

		} catch (Exception e) {
			System.out.println("Erreur: "+e.getMessage());
		}

		return "ModifAnnonce";

	}

	public Vector<Annonces> liste_ann() {
		Vector<Annonces> lesAnn = new Vector<Annonces>();
		Annonces ann = null;
		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from annonce order by id desc";
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				ann = new Annonces(rs.getString("id"), rs.getString("titre"),
						rs.getString("intitule"));
				lesAnn.add(ann);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lesAnn;

	}

	public String Insert(Annonces ann) {

		try {

			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
					.prepareStatement(
							"insert into annonce(titre,intitule) values(?,?)");

			st.setString(1, ann.getTitre());
			st.setString(2, ann.getIntitule());
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
					.prepareStatement("delete from annonce where id=?");

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
					.prepareStatement("update annonce set titre=?, intitule=? where id=?");
			System.out.println("updte");
			System.out.println(annonce.getId());
			System.out.println(annonce.getIntitule());
             
			st.setString(1, annonce.getTitre());
			st.setString(2, annonce.getIntitule());
			st.setString(3, annonce.getId());
			st.executeUpdate();
			
			System.out.println("id ann: "+annonce.getId());
			System.out.println("Titre ann: "+annonce.getTitre());
			System.out.println("Intitule ann: "+annonce.getIntitule());
		
			FacesMessage message = new FacesMessage(
					"La modification est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			System.out.println("Erreur Update"+e.getMessage());
		}
		return "GestAnnonces";

	}

}
