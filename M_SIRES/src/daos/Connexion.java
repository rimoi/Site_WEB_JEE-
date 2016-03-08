package daos;


import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
public class Connexion {	
	public static Connection getConnx(){		
		String url= "jdbc:mysql://localhost/master";
		String user="root";
		String password="root";
		Connection con = null;		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Error Driver : "+e.getMessage());
		}		
		try {
			 con= (Connection) DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Error BD : "+e.getClass()+" = "+e.getErrorCode()+" : "+e.getMessage());
		}		
		return con;
	}			
		public static void main(String[] args) {
			if (getConnx()==null)
				System.out.println("Connexion � la base de donn�es impossible !");
			else
				System.out.println("Connexion � la base de donn�es �tablie !");
		}
}
