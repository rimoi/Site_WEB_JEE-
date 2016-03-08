package daos;

import java.sql.ResultSet;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import beans.Etudiant;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

@ManagedBean
@RequestScoped
public class EtudDao {


	String id;
	

	public EtudDao() {
	}
	public Vector<Etudiant> getLesEtud() {
		return lesEtud;
	}

	public void setLesEtud(Vector<Etudiant> lesEtud) {
		this.lesEtud = lesEtud;
	}
	
	

	Etudiant etudiant=new Etudiant();

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}



	Vector<Etudiant> lesEtud=new Vector<Etudiant>();
	
	Vector<String> ListEmail=new Vector<String>();

	private String promo;
	
	public String listeEtParPromo(int id) {
		
		lesEtud=new Vector<Etudiant>();
		try{ 
			
			Statement st= (Statement) Connexion.getConnx().createStatement();		
		String req="select * from  etudiant where id_promo="+id;
	        ResultSet rs= st.executeQuery(req);
	while (rs.next()) {
		
		etudiant =new Etudiant(rs.getString("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("id_promo"));
		lesEtud.add(etudiant);
		
		
	}
	}catch(Exception e){
		System.out.println(e.getMessage());}
	
		return "etud_rapp";	
		
	}
	
	
	public Vector<Etudiant> listParPromotion(int id) {
		
		
		try{ 
			lesEtud=new Vector<Etudiant>();
			
			Statement st= (Statement) Connexion.getConnx().createStatement();		
		String req="select * from  etudiant where id_promo="+id;
	        ResultSet rs= st.executeQuery(req);
	while (rs.next()) {
		
		etudiant =new Etudiant(rs.getString("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("id_promo"));
		lesEtud.add(etudiant);
		
		
	}
	}catch(Exception e){
		System.out.println(e.getMessage());}
	
		System.out.println("*********************************************************");
		
		return lesEtud;
		
	}
	
	
//	public Vector<Enseignant> liste_ens() {
//		Vector<Enseignant> lesEns=new Vector<Enseignant>();
//		Enseignant en=null;
//		try{ 
//			
//			Statement st= (Statement) Connexion.getConnx().createStatement();		
//		String req="select * from enseignant";
//	        ResultSet rs= st.executeQuery(req);
//	while (rs.next()) {
//		en =new Enseignant(rs.getString("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("tele"),rs.getString("ville"),rs.getString("ProfilsCours"));
//		lesEns.add(en);
//	}
//	}catch(Exception e){
//		System.out.println(e.getMessage());}
//		return lesEns;		
//	}
	
	
	public String getIdParPromo(String annee) {
		
		
		try{ 
			
			Statement st= (Statement) Connexion.getConnx().createStatement();		
		String req="select id from  promotion where annee='"+annee+"'";
	        ResultSet rs= st.executeQuery(req);
	while (rs.next()) {
		
           	id=rs.getString("id");
           	System.out.println("idpar promo: "+id);
	}
	
	}catch(Exception e){
		System.out.println(e.getMessage());}
		return id;
	
	}
	
	
public String getPromoParId(String id) {
		
		
		try{ 
			
			Statement st= (Statement) Connexion.getConnx().createStatement();		
		String req="select annee from  promotion where id='"+id+"'";
	        ResultSet rs= st.executeQuery(req);
	while (rs.next()) {
		
           promo=rs.getString("annee");
	}
	
	}catch(Exception e){
		System.out.println(e.getMessage());}
		return promo;
	
	}
	
	public String Insert(Etudiant Etud) {

		try {
			
			String idpromo=getIdParPromo(Etud.getPromo());

			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
			.prepareStatement("insert into etudiant(nom,prenom,email,id_promo) values(?,?,?,?)");

			st.setString(1, Etud.getNom());
			st.setString(2, Etud.getPrenom());
			st.setString(3, Etud.getEmail());
			st.setString(4, idpromo);
			
			
			st.executeUpdate();

			FacesMessage message = new FacesMessage("L'ajout est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			System.out.println("N'est pas Ajouté: " + e.getMessage());
		}
		return "GestEtudiant";

	}

	
	
	public void Delete(int id) {

		try {

			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
			.prepareStatement("delete from etudiant where id=?");

			st.setInt(1, id);
			st.executeUpdate();

			FacesMessage message = new FacesMessage(
					"La suppression est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			System.out.println("Erroooooooooooooooooor: " + e.getMessage());
		}

	}

	public String Update(Etudiant Etud) {

		try {
			System.out.println("-------------------------------Update--------------------------");
			String idpromo=getIdParPromo(Etud.getPromo());
			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
					.prepareStatement(
							"update etudiant set nom=?, prenom=?, email=?, id_promo=?  where id=?");

			st.setString(1, Etud.getNom());
			st.setString(2, Etud.getPrenom());
			st.setString(3, Etud.getEmail());
			st.setString(4, idpromo );
			st.setString(5, Etud.getId() );
			st.executeUpdate();
			

			System.out.println("Nom: "+Etud.getNom());
			System.out.println("Prenom: "+Etud.getPrenom());
			System.out.println("Email: "+Etud.getEmail());
			
			System.out.println("--------------------------------------------------------------");
			FacesMessage message = new FacesMessage(
					"La modification est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			System.out.println("Errrrrrrrrrrrrorrrrrrrrrrrrrrrr Update :"+e.getMessage());
		}
		return "GestEtudiant";

	}
	
	
	public String get_Etudiant(int id) {

		try {
			
			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from etudiant where id="+id;
			
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				etudiant.setId(rs.getString("id"));
				etudiant.setNom(rs.getString("nom"));
				etudiant.setPrenom(rs.getString("prenom"));
				etudiant.setEmail(rs.getString("email"));
				
				String promo=getPromoParId(rs.getString("id_promo"));
				etudiant.setId_prom(promo);
			}
			

		} catch (Exception e) {
			System.out.println("Erooooooooooooor: "+e.getMessage());
		}

		return "ModifEtudiant";
	}

	
	
public Vector<String> getEmails() {
	ListEmail=new Vector<String>();
		
		try{ 
			
			Statement st= (Statement) Connexion.getConnx().createStatement();		
		String req="select distinct email from  etudiant";
	        ResultSet rs= st.executeQuery(req);
	while (rs.next()) {
		
		ListEmail.add(rs.getString("email"));
	}
	
	}catch(Exception e){
		System.out.println(e.getMessage());}
		return ListEmail;
	
	}
}
