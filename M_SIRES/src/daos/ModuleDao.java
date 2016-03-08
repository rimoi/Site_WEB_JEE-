package daos;

import java.sql.ResultSet;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import beans.Enseignant;
import beans.Module;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

@ManagedBean
@SessionScoped
@RequestScoped
public class ModuleDao {

	Vector<Module> lesMod = new Vector<Module>();
	Module module = new Module();

	public Module getModule() {
		return module;
	}

	public Vector<Module> getLesModulessem() {
		return lesModulessem;
	}

	public void setLesModulessem(Vector<Module> lesModulessem) {
		this.lesModulessem = lesModulessem;
	}

	Vector<Module> lesModulessem = new Vector<Module>();

	private String id;
	private String nom;

	public Vector<Module> getLesMod() {
		return lesMod;
	}

	public void setLesMod(Vector<Module> lesMod) {
		this.lesMod = lesMod;
	}

	public Vector<Module> liste_mod() {

		Module mod = null;
		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from module";
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				mod = new Module(rs.getString("id"), rs.getString("intitule"),
						rs.getString("volume_hor"), rs.getString("semestre"),
						rs.getString("id_ens"));
				lesMod.add(mod);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lesMod;
	}

	public Vector<Module> liste_mod_S1() {
		Vector<Module> lesModS1 = new Vector<Module>();
		Module mod = null;
		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from module where semestre='s1'";
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				mod = new Module(rs.getString("id"), rs.getString("intitule"),
						rs.getString("volume_hor"), rs.getString("semestre"),
						rs.getString("id_ens"));
				lesModS1.add(mod);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lesModS1;
	}

	public Vector<Module> liste_mod_S2() {
		Vector<Module> lesModS2 = new Vector<Module>();
		Module mod = null;
		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from module where semestre='s2'";
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				mod = new Module(rs.getString("id"), rs.getString("intitule"),
						rs.getString("volume_hor"), rs.getString("semestre"),
						rs.getString("id_ens"));
				lesModS2.add(mod);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lesModS2;
	}

	public Vector<Module> liste_mod_S3() {
		Vector<Module> lesModS3 = new Vector<Module>();
		Module mod = null;
		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from module where semestre='s3'";
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				mod = new Module(rs.getString("id"), rs.getString("intitule"),
						rs.getString("volume_hor"), rs.getString("semestre"),
						rs.getString("id_ens"));
				lesModS3.add(mod);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lesModS3;
	}

	public Vector<Module> liste_mod_S4() {
		Vector<Module> lesModS4 = new Vector<Module>();
		Module mod = null;
		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from module where semestre='s4'";
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				mod = new Module(rs.getString("id"), rs.getString("intitule"),
						rs.getString("volume_hor"), rs.getString("semestre"),
						rs.getString("id_ens"));
				lesModS4.add(mod);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lesModS4;
	}

	public String ensParId(String id) {
		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select nom from  enseignant where id=" + id;
			ResultSet rs = st.executeQuery(req);
			nom = rs.getString("nom");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return nom;
	}

	public Vector<Module> ModulesParsemstre(String sem) {

		// lesMod=new Vector<Module>();
		try {
			lesModulessem = new Vector<Module>();
			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select m.id, intitule, volume_hor, semestre, id_ens, e.nom from module m, enseignant e where semestre='"
					+ sem + "' and e.id=m.id_ens";
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {

				// String nomEn=ensParId(rs.getString("id_ens"));

				module = new Module(rs.getString("m.id"),
						rs.getString("intitule"), rs.getString("volume_hor"),
						rs.getString("semestre"), rs.getString("id_ens"),
						rs.getString("e.nom"));
				lesModulessem.add(module);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lesModulessem;
	}

	public String liste_mod_Modif(String sem) {

		Module mod = null;
		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from module where semestre='" + sem + "'";
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				mod = new Module(rs.getString("id"), rs.getString("intitule"),
						rs.getString("volume_hor"), rs.getString("semestre"),
						rs.getString("id_ens"));
				lesMod.add(mod);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "ModifModules";
	}

	public String GetIdByNomEns(String nom) {

		try {

			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select id from enseignant where nom='" + nom + "'";
			ResultSet rs = st.executeQuery(req);

			while (rs.next()) {
				id = rs.getString("id");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return id;

	}

	public String Insert(Module mod) {

		try {

			String id_ens = GetIdByNomEns(mod.getNom_ens());

			PreparedStatement st = (PreparedStatement) Connexion
					.getConnx()
					.prepareStatement(
							"insert into module(intitule,volume_hor,semestre,id_ens) values(?,?,?,?)");

			st.setString(1, mod.getIntitule());
			st.setString(2, mod.getVol_hor());
			st.setString(3, mod.getSemestre());
			st.setString(4, id_ens);

			st.executeUpdate();

			FacesMessage message = new FacesMessage("L'ajout est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			System.out.println("N'est pas Ajouté: " + e.getMessage());
		}
		return "GestModules";

	}

	public void Delete(int id) {

		try {

			System.out
					.println("*****************************************************");

			PreparedStatement st = (PreparedStatement) Connexion.getConnx()
					.prepareStatement("delete from module where id=?");

			st.setInt(1, id);
			st.executeUpdate();

			FacesMessage message = new FacesMessage(
					"La suppression est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			System.out.println("Erroooooooooooooooooor: " + e.getMessage());
		}

		// lesMod=liste_mod() ;
	}

	public String Update(Module modu) {

		try {

			System.out
					.println(".................................Update..........................................");

			id=GetIdByNomEns(modu.getNom_ens());
			
			PreparedStatement st = (PreparedStatement) Connexion
					.getConnx()
					.prepareStatement(
							"update module set intitule=?, volume_hor=?, semestre=?, id_ens=? where id=?");

			st.setString(1, modu.getIntitule());
			st.setString(2, modu.getVol_hor());
			st.setString(3, modu.getSemestre());
			st.setString(4, id);
			st.setString(5, modu.getId());

			System.out.println("Intitulé : " + modu.getIntitule());
			System.out.println("getVol_hor : " + modu.getVol_hor());
			System.out.println("getSemestre : " + modu.getSemestre());
			System.out.println("getId_ens : " + modu.getId_ens());
			System.out.println("getId : " + modu.getId());
			st.executeUpdate();

			FacesMessage message = new FacesMessage(
					"La modification est bien fait");
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {
			System.out.println("Erroooooooooooooooooooooooooor Update"
					+ e.getMessage());
		}

		System.out
				.println(".............................................................................................");

		return "GestModules";

	}

	public String liste_modParId(String id) {

		// Module mod=null;
		try {
			// lesMod=new Vector<Module>();
			System.out
					.println(".................................List For Update..........................................");
			Statement st = (Statement) Connexion.getConnx().createStatement();
			String req = "select * from module where id=" + id;
			ResultSet rs = st.executeQuery(req);
			while (rs.next()) {
				module = new Module(rs.getString("id"),
						rs.getString("intitule"), rs.getString("volume_hor"),
						rs.getString("semestre"), rs.getString("id_ens"));

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "ModifModules";
	}

}
