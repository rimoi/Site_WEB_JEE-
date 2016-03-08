package daos;

import java.sql.ResultSet;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import beans.Enseignant;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
@ManagedBean
@RequestScoped
public class EnseignantDao {
	
	Enseignant Enseignant= new Enseignant();
	private String nom;
	
	
	public Enseignant getEnseignant() {
		return Enseignant;
	}


	public void setEnseignant(Enseignant enseignant) {
		Enseignant = enseignant;
	}

	

	public Enseignant ensParId(int id){
		Enseignant en= null;
		try {
			
			Statement st= (Statement) Connexion.getConnx().createStatement();		
			String req="select * from  enseignant where id="+id;
			ResultSet rs= st.executeQuery(req);
			while (rs.next()){
			en =new Enseignant(rs.getString("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("tele"),rs.getString("ville"),rs.getString("ProfilsCours"));
			System.out.println("Enseignant"+rs.getString("nom"));
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());}
		return en;
	}
	
	
public String get_Ens(int id) {

		
		try {
			
			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from enseignant where id="+id;
			
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				
				Enseignant.setId(rs.getString("id"));
				Enseignant.setNom(rs.getString("nom"));
				Enseignant.setPrenom(rs.getString("prenom"));
				Enseignant.setEmail(rs.getString("email"));
				Enseignant.setNum_tel(rs.getString("tele"));
				Enseignant.setVille(rs.getString("ville"));
				Enseignant.setProfilsCours(rs.getString("ProfilsCours"));
			}
			

		} catch (Exception e) {
			System.out.println("Erooooooooooooor: "+e.getMessage());
		}

		return "ModifEnseignant";

	}


public Enseignant get_EnsparId(int id){
	Enseignant en= null;
	try {
		
		Statement st= (Statement) Connexion.getConnx().createStatement();		
		String req="select * from  enseignant where id="+id;
		ResultSet rs= st.executeQuery(req);
		en =new Enseignant(rs.getString("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("tele"),rs.getString("ville"),rs.getString("ProfilsCours"));
	}catch(Exception e){
		System.out.println(e.getMessage());}
	return en;
}

	public Vector<Enseignant> liste_Ens() {
		Vector<Enseignant> lesEns = new Vector<Enseignant>();
		Enseignant ens = null;
		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from enseignant";
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				ens =new Enseignant(rs.getString("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("tele"),rs.getString("ville"),rs.getString("ProfilsCours"));
				lesEns.add(ens);
			}
			
			for (int i = 0; i < lesEns.size(); i++) {
				System.out.println(lesEns.get(i).getEmail());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lesEns;

	}

	
	public Vector<String> Nom_Ens() {
		Vector<String> NomEns = new Vector<String>();

		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select nom from enseignant";
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				
				NomEns.add(rs.getString("nom"));
			}
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return NomEns;

	}
	
	public String Insert(Enseignant Ens) {

		try {

			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
			.prepareStatement("insert into enseignant(nom,prenom,email,tele,ville,ProfilsCours) values(?,?,?,?,?,?)");

			st.setString(1, Ens.getNom());
			st.setString(2, Ens.getPrenom());
			st.setString(3, Ens.getEmail());
			st.setString(4, Ens.getNum_tel());
			st.setString(5, Ens.getVille());
			st.setString(6, Ens.getProfilsCours());
			
			st.executeUpdate();

			FacesMessage message = new FacesMessage("L'ajout est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			System.out.println("N'est pas Ajout�: " + e.getMessage());
		}
		return "GestEnseignants";

	}

	public void Delete(int id) {

		try {

			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
			.prepareStatement("delete from enseignant where id=?");

			st.setInt(1, id);
			st.executeUpdate();

			FacesMessage message = new FacesMessage(
					"La suppression est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			System.out.println("Erreur de suppression d enseignant: " + e.getMessage());
		}

	}

	public String Update(Enseignant ens) {

		try {

			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
					.prepareStatement(
							"update enseignant set nom=?, prenom=?, email=?, tele=?, ville=?, ProfilsCours=?  where id=?");

			st.setString(1, ens.getNom());
			st.setString(2, ens.getPrenom());
			st.setString(3, ens.getEmail());
			st.setString(4, ens.getNum_tel());
			st.setString(5, ens.getVille());
			st.setString(6, ens.getProfilsCours());
			st.setString(7, ens.getId());
			st.executeUpdate();

			FacesMessage message = new FacesMessage("La modification est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "GestEnseignants";

	}

	

	
	public Vector<Enseignant> liste_ens() {
		Vector<Enseignant> lesEns=new Vector<Enseignant>();
		Enseignant en=null;
		try{ 
			
			Statement st= (Statement) Connexion.getConnx().createStatement();		
		String req="select * from enseignant";
	        ResultSet rs= st.executeQuery(req);
	while (rs.next()) {
		en =new Enseignant(rs.getString("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("tele"),rs.getString("ville"),rs.getString("ProfilsCours"));
		lesEns.add(en);
	}
	}catch(Exception e){
		System.out.println(e.getMessage());}
		return lesEns;		
	}
	
	

	
}
