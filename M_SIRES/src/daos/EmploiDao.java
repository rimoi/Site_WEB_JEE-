package daos;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import beans.Emploi;

@ManagedBean
@RequestScoped
public class EmploiDao {
	
	public Emploi emp=new Emploi();
	

	public Emploi getEmp() {
		return emp;
	}



	private Part file;
	
	
	


	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}


	public void imageValidator(FacesContext context, UIComponent toValidate,
			Object value) throws ValidatorException {
		Part file = (Part) value;

		String fileName = UploadEmploi.getFileName(file);
		System.out.println("----- validator fileName: " + fileName);
		if (fileName.length() == 0) {
			FacesMessage message = new FacesMessage("Veillez choisir une image");
			throw new ValidatorException(message);
		} else if (fileName.length() > 100) {
			FacesMessage message = new FacesMessage(
					"Nom d'image est trop long !!");
			throw new ValidatorException(message);
		} else if (!fileName.endsWith(".jpg") && !fileName.endsWith(".JPG")) {
			FacesMessage message = new FacesMessage(
					"L'image doit être (JPG) !!");
			throw new ValidatorException(message);
		}
	}
	
	
	public void addEmploi() throws SQLException {

		//ObjectContainer db = Db4oEmbedded.openFile("c:/client.db4o");
		
		//this.client.setImage(String.valueOf(this.hashCode())+".jpg");
		//db.store(client);
		//System.out.println("ID:"+db.ext().getID(client));
		
		
		PreparedStatement st = (PreparedStatement) Connexion.getConnx()
				.prepareStatement("insert into emploi_temps (emploi,semestre) values(?,?)");
		
		//long id = db.ext().getID(client);

		String sem=emp.getSemestre();
		
		st.setString(1, emp.setEmploi(sem+".jpg"));
		
		st.setString(2, sem);
		
		st.executeUpdate();
		
		
		try {

			UploadEmploi.uploadFile(getFile(), sem);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			;
		}

		
		//return "";
	}
	
	

	public String emploiS(String s){
		System.out.println("111111111111111");
		try {
			Statement st= (Statement) Connexion.getConnx().createStatement();
			System.out.println("22222222222");
			String req="select * from  emploi_temps where semestre='"+s+"'";
			
			System.out.println("333333333");
			
			ResultSet rs= st.executeQuery(req);
			
			while(rs.next()){
				System.out.println( rs.getString("emploi"));
				emp =new Emploi(rs.getString("id"), rs.getString("emploi"),rs.getString("semestre"));
			}
			}catch(Exception e){
			System.out.println(e.getMessage());}
		return "emploi";
	}
	
	
//	
//	public String addCustomer() throws SQLException {
//
//		Customer c  =  (Customer) db.queryByExample(client).next();
//		long id = db.ext().getID(client);
//		c.setImage(String.valueOf(id)+".jpg");
//		db.store(client);
//		db.close();
//		try {
//
//			UploadEmploi.uploadFile(getFile(), id);
//
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//			;
//		}
//
//		
//		return "index?faces-redirect=true";
//	}
	
}
