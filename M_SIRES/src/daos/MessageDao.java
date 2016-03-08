package daos;

import java.sql.ResultSet;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import beans.Annonces;
import beans.Message;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


@ManagedBean
@RequestScoped
public class MessageDao {
	
	Message message = new Message();
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Vector<Message> getVecMes() {
		return vecMes;
	}

	public void setVecMes(Vector<Message> vecMes) {
		this.vecMes = vecMes;
	}

	Vector<Message> vecMes= new Vector<Message>();
	
	public void ajout_msg(String nom,String email,String message){
		try { Statement st= (Statement) Connexion.getConnx().createStatement();		
		String req="insert into message (nom,email,message) values('"+nom+"','"+email+"','"+message+"')";
	st.executeUpdate(req);
	FacesMessage mesage=new FacesMessage("votre message à été envoyé");
	FacesContext.getCurrentInstance().addMessage(null, mesage);
		}catch(Exception e){
			System.out.println(e.getMessage());}
	}
	
	
	public Vector<Message> liste_messages() {
		Vector<Message> vecMes = new Vector<Message>();
		 Message mes = null;
		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from message order by id desc";
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				mes = new Message(rs.getString("id"),rs.getString("nom"), rs.getString("email"),
						rs.getString("message"));
				vecMes.add(mes);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return vecMes;

	}
	
	public void Delete(int id) {

		try {

			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
					.prepareStatement("delete from message where id=?");

			st.setInt(1, id);
			st.executeUpdate();

			FacesMessage messa = new FacesMessage(
					"La suppression est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, messa);

		} catch (Exception e) {
			System.out.println("Erroooooooooooooooooor: " + e.getMessage());
		}

	}
	

}
