package daos;



import java.sql.ResultSet;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.Statement;

import beans.Admin;

@ManagedBean
@SessionScoped
public class ConnAdmin {
	
	private Admin admin= new Admin();
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
	
	

	public String GetCL(){
		
		//Admin admin=null;
	try{ 
			
			Statement st= (Statement) Connexion.getConnx().createStatement();		
		    String req="select login,pass from admin where login='"+admin.getLogin()+"' and pass='"+admin.getPass()+"'";
	        ResultSet rs= st.executeQuery(req);
	        
	if (rs.next()) {
		System.out.println("Admin log "+admin.getLogin());
		admin =new Admin(rs.getString("login"),rs.getString("pass"));
		
	}else {
		
		admin = new Admin();
		
	
	}
	

	
	if (admin.getLogin() != null && admin.getPass() != null) {
		
		return "GestAnnonces";
	} else{
		FacesMessage message=new FacesMessage("Login ou password incorrect");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
	}}catch(Exception e){
		System.out.println(".............."+e.getMessage());}
	return null;
				
	}
	
	
	public String deconexion() {
		admin= new Admin();
		return "Accueil";
		
	}
		}

