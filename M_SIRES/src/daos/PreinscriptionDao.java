package daos;

import java.sql.ResultSet;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;






import beans.Enseignant;
import beans.Etudiant;
import beans.Preinscription;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

@ManagedBean
@RequestScoped
public class PreinscriptionDao {
	Preinscription etudiant=new Preinscription();
	public Preinscription getPreinscription() {
		return etudiant;
	}
	public void setPreinscription(Preinscription etudiant) {
		this.etudiant = etudiant;
	}
	public PreinscriptionDao() {
	}
	public Vector<Preinscription> getLesEtud() {
		return lesEtu;
	}
	public void setlesEtud(Vector<Preinscription> lesEtu) {
		this.lesEtu = lesEtu;
	}
	Vector<Preinscription> lesEtu=new Vector<Preinscription>();
	public Vector<Preinscription> liste_Etu() {
		Vector<Preinscription> lesEtu = new Vector<Preinscription>();
		Preinscription ens = null;
		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from preinscription where confirmer=1";
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				ens =new Preinscription(rs.getString("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("cin")
						,rs.getString("ville"),rs.getString("pays"),rs.getString("adresse"),rs.getInt("tel"),rs.getString("DernierDiplome")
						,rs.getString("universiteObtention"),rs.getString("mention"),rs.getString("AnneObtention"),rs.getString("AutreDiplome"),rs.getInt("confirmer"));
				lesEtu.add(ens);
			}
			
			for (int i = 0; i < lesEtu.size(); i++) {
				System.out.println(lesEtu.get(i).getEmail());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lesEtu;
	}
	
	public Vector<Preinscription> liste_Cand() {
		Vector<Preinscription> lesCand = new Vector<Preinscription>();
		Preinscription ens = null;
		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from preinscription where confirmer is null";
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				ens =new Preinscription(rs.getString("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("cin")
						,rs.getString("ville"),rs.getString("pays"),rs.getString("adresse"),rs.getInt("tel"),rs.getString("DernierDiplome")
						,rs.getString("universiteObtention"),rs.getString("mention"),rs.getString("AnneObtention"),rs.getString("AutreDiplome"),rs.getInt("confirmer"));
				lesCand.add(ens);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lesCand;
	}
	public String Insert(Preinscription pre) {
		try {
			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
			.prepareStatement("insert into preinscription(nom,prenom,email,cin,ville,pays,adresse,tel,dernierDiplome,universiteObtention,mention,anneObtention,autreDiplome)  values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			st.setString(1, pre.getNom());
			st.setString(2, pre.getPrenom());
			st.setString(3, pre.getEmail());
			st.setString(4, pre.getCin());
			st.setString(5, pre.getVille());
			st.setString(6, pre.getPays());
			st.setString(7, pre.getAdresse());
			st.setInt(8, pre.getTel());
			st.setString(9, pre.getDernier());
			st.setString(10, pre.getUniversite());
			st.setString(11, pre.getMention());
			st.setString(12, pre.getAnne());
			st.setString(13, pre.getAutre());
		//	st.setBoolean(14, pre.getConfirmer());
			st.executeUpdate();
			FacesMessage message = new FacesMessage("Inscription avec sucess");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			System.out.println("Erreur inscription: " + e.getMessage());
		}
		return "Accueil";
	}
	public void Delete(int id) {
		try {
			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
			.prepareStatement("delete from preinscription where id=?");
			st.setInt(1, id);
			st.executeUpdate();
			FacesMessage message = new FacesMessage(
					"La suppression est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			System.out.println("Erreur de supression: " + e.getMessage());
		}
	}
	public String Confirmer(int id) {
		try {
			Preinscription pre=new Preinscription();
			System.out.println("-------------------------------Confirmer--------------------------");
			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
					.prepareStatement("update preinscription set confirmer=?  where id=?");
			st.setInt(1, 1);
			st.setInt(2, id);
			st.executeUpdate();		
			System.out.println("--------------------------------------------------------------");
			FacesMessage message = new FacesMessage("Confirmation Bien fait");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			System.out.println("Erreur de confirmation :"+e.getMessage());
		}
		return "GestPreinscrit";
	}
	public String get_Etudiant(int id) {
		try {
			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from preinscription where id="+id;
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				//etudiant.setId(rs.getString("id"));
				etudiant.setNom(rs.getString("nom"));
				etudiant.setPrenom(rs.getString("prenom"));
				etudiant.setEmail(rs.getString("email"));	
			}
		} catch (Exception e) {
			System.out.println("Erreur: "+e.getMessage());
		}
		return "ModifPre";
	}
	public String Update(Preinscription Etud) {

		try {
			System.out.println("-------------------------------Update--------------------------");
			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
					.prepareStatement(
							"update preinscription set nom=?, prenom=?, email=?  where id=?");

			st.setString(1, Etud.getNom());
			st.setString(2, Etud.getPrenom());
			st.setString(3, Etud.getEmail());
			st.setString(4, Etud.getId() );
			st.executeUpdate();
			
			System.out.println("--------------------------------------------------------------");
			FacesMessage message = new FacesMessage(
					"La modification est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			System.out.println("Erreur Update :"+e.getMessage());
		}
		return "GestPreinscrit";

	}
	public String get_Pre(int id) {

		try {
			
			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from preinscription where id="+id;
			
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				etudiant.setId(rs.getString("id"));
				etudiant.setNom(rs.getString("nom"));
				etudiant.setPrenom(rs.getString("prenom"));
				etudiant.setEmail(rs.getString("email"));
				
			}
			

		} catch (Exception e) {
			System.out.println("Erooooooooooooor: "+e.getMessage());
		}

		return "EditEtud";
	}
}
