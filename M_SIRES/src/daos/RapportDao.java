package daos;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import beans.Rapport;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

@ManagedBean
@RequestScoped
public class RapportDao {
	
	private Rapport rapport = new Rapport();

	private Part file;
	
	String id;
	
	public Rapport getRapport() {
		return rapport;
	}

	public void setRapport(Rapport rapport) {
		this.rapport = rapport;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

//
//	public void imageValidator(FacesContext context, UIComponent toValidate,
//			Object value) throws ValidatorException {
//		Part file = (Part) value;
//
//		String fileName = UploadEmploi.getFileName(file);
//		System.out.println("----- validator fileName: " + fileName);
//		if (fileName.length() == 0) {
//			FacesMessage message = new FacesMessage("Veillez choisir une image");
//			throw new ValidatorException(message);
//		} else if (fileName.length() > 100) {
//			FacesMessage message = new FacesMessage(
//					"Nom d'image est trop long !!");
//			throw new ValidatorException(message);
//		} else if (!fileName.endsWith(".jpg") && !fileName.endsWith(".JPG")) {
//			FacesMessage message = new FacesMessage(
//					"L'image doit être (JPG) !!");
//			throw new ValidatorException(message);
//		}
//	}
	
	
	public void addRapp() throws SQLException {
		
		id=EtudiantParEmail(rapport.getEmailEtud());
		
		
		PreparedStatement st = (PreparedStatement) Connexion.getConnx()
				.prepareStatement("insert into rapport (intitule, Rapp, id_etud) values(?,?,?)");
		
		//String rap=rapport.getId_etudiant();
		
		st.setString(1, rapport.getIntitule());
		
		st.setString(2, rapport.setRap(id+".pdf"));
		
		st.setString(3,   id);
		
		st.executeUpdate();
		
		
		try {

			UploadRapport.uploadFile(getFile(), id);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		}}
	
	public Rapport rappEtud(int id){
		Rapport rapp= null;
		try {
			
			Statement st= (Statement) Connexion.getConnx().createStatement();		
			String req="select * from  rapport where id_etud="+id;
			ResultSet rs= st.executeQuery(req);
			
			while(rs.next()){
				rapp =new Rapport(rs.getString("id"), rs.getString("intitule"),rs.getString("intitule"));
			}
			}catch(Exception e){
			System.out.println(e.getMessage());}
		return rapp;
	}
	
	
	public String rapStage(int id){		
		try {
			Statement st= (Statement) Connexion.getConnx().createStatement();		
			String req="select * from  rapport where id_etud="+id;
			ResultSet rs= st.executeQuery(req);
			
			while(rs.next()){
				rapport =new Rapport(rs.getString("id"), rs.getString("intitule"),rs.getString("id_etud"));
			}
			}catch(Exception e){
			System.out.println(e.getMessage());}
		return "rapportStage";
	}
	
	
	
	public String EtudiantParEmail(String email) {
		
		
		try{ 
			
			Statement st= (Statement) Connexion.getConnx().createStatement();		
		String req="select id from  etudiant where email='"+email+"'";
	        ResultSet rs= st.executeQuery(req);
	while (rs.next()) {
		
		id =rs.getString("id");
	}
	}catch(Exception e){
		System.out.println(e.getMessage());}
		return id;
	
	}

}
