
package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.RevueDAO;
import metier.RevuePOJO;


public class SQLRevueDAO  implements RevueDAO {
	
	private static SQLRevueDAO instance;
	
	private SQLRevueDAO() {}
	

	public static RevueDAO getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new SQLRevueDAO();
		}
		
		return instance;
	}


	public ArrayList<RevuePOJO> findAll() {
		
		
		ArrayList<RevuePOJO> liste = new ArrayList<RevuePOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Revue");			
			
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = (res.getInt(1));
				String title = (res.getString(2));
				String des = (res.getString(3));
				double tarif = (res.getDouble(4));
				String visu = (res.getString(5));
				int period = (res.getInt(6));
				RevuePOJO r = new RevuePOJO(id,title,des,tarif,visu,period);
				
				liste.add(r);
	
				
				
			}
		
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
	
			
		}
		
		catch (SQLException e )
		{
			System.out.println(e);
		}
		return liste;
	
	}
	
public static int NombreAboByRevue(int id1) {
		
		
		int nb = 0 ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Abonnement where id_revue =? ");			
			requete.setInt(1, id1);
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				nb = nb+1;
			
				
			}
		
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
	
			
		}
		
		catch (SQLException e )
		{
			System.out.println(e);
		}
		return nb;
	
	}
	

	public static ArrayList<RevuePOJO> getByTitle(String t) {
		
		
		ArrayList<RevuePOJO> liste = new ArrayList<RevuePOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Revue where title=? ");			
			requete.setString(1, t);
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = (res.getInt(1));
				String title = (res.getString(2));
				String des = (res.getString(3));
				double tarif = (res.getDouble(4));
				String visu = (res.getString(5));
				int period = (res.getInt(6));
				RevuePOJO r = new RevuePOJO(id,title,des,tarif,visu,period);
				
				liste.add(r);
	
				
				
			}
		
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
	
			
		}
		
		catch (SQLException e )
		{
			System.out.println(e);
		}
		return liste;
	
	}
	

	public static ArrayList<RevuePOJO> getByTitleAndId(String t, int id1) {
		
		
		ArrayList<RevuePOJO> liste = new ArrayList<RevuePOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Revue where title=? and id_revue=? ");			
			requete.setString(1, t);
			requete.setInt(2, id1);
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = (res.getInt(1));
				String title = (res.getString(2));
				String des = (res.getString(3));
				double tarif = (res.getDouble(4));
				String visu = (res.getString(5));
				int period = (res.getInt(6));
				RevuePOJO r = new RevuePOJO(id,title,des,tarif,visu,period);
				
				liste.add(r);
	
				
				
			}
		
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
	
			
		}
		
		catch (SQLException e )
		{
			System.out.println(e);
		}
		return liste;
	
	}
	
	
	
	public static ArrayList<RevuePOJO> getByDescAndId(String t, int id1) {
		
		
		ArrayList<RevuePOJO> liste = new ArrayList<RevuePOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Revue where description=? and id_revue=? ");			
			requete.setString(1, t);
			requete.setInt(2, id1);
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = (res.getInt(1));
				String title = (res.getString(2));
				String des = (res.getString(3));
				double tarif = (res.getDouble(4));
				String visu = (res.getString(5));
				int period = (res.getInt(6));
				RevuePOJO r = new RevuePOJO(id,title,des,tarif,visu,period);
				
				liste.add(r);
	
				
				
			}
		
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
	
			
		}
		
		catch (SQLException e )
		{
			System.out.println(e);
		}
		return liste;
	
	}
	
	
	public static ArrayList<RevuePOJO> getByTarifAndId(double t, int id1) {
		
		
		ArrayList<RevuePOJO> liste = new ArrayList<RevuePOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Revue where tarif=? and id_revue=? ");			
			requete.setDouble(1, t);
			requete.setInt(2, id1);
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = (res.getInt(1));
				String title = (res.getString(2));
				String des = (res.getString(3));
				double tarif = (res.getDouble(4));
				String visu = (res.getString(5));
				int period = (res.getInt(6));
				RevuePOJO r = new RevuePOJO(id,title,des,tarif,visu,period);
				
				liste.add(r);
	
				
				
			}
		
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
	
			
		}
		
		catch (SQLException e )
		{
			System.out.println(e);
		}
		return liste;
	
	}
	
	public static ArrayList<RevuePOJO> getByVisuelAndId(String t, int id1) {
		
		
		ArrayList<RevuePOJO> liste = new ArrayList<RevuePOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Revue where visuel=? and id_revue=? ");			
			requete.setString(1, t);
			requete.setInt(2, id1);
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = (res.getInt(1));
				String title = (res.getString(2));
				String des = (res.getString(3));
				double tarif = (res.getDouble(4));
				String visu = (res.getString(5));
				int period = (res.getInt(6));
				RevuePOJO r = new RevuePOJO(id,title,des,tarif,visu,period);
				
				liste.add(r);
	
				
				
			}
		
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
	
			
		}
		
		catch (SQLException e )
		{
			System.out.println(e);
		}
		return liste;
	
	}
	
	
	public static ArrayList<RevuePOJO> getByPeriodAndId(int t, int id1) {
		
		
		ArrayList<RevuePOJO> liste = new ArrayList<RevuePOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Revue where id_periodicite=? and id_revue=? ");			
			requete.setInt(1, t);
			requete.setInt(2, id1);
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = (res.getInt(1));
				String title = (res.getString(2));
				String des = (res.getString(3));
				double tarif = (res.getDouble(4));
				String visu = (res.getString(5));
				int period = (res.getInt(6));
				RevuePOJO r = new RevuePOJO(id,title,des,tarif,visu,period);
				
				liste.add(r);
	
				
				
			}
		
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
	
			
		}
		
		catch (SQLException e )
		{
			System.out.println(e);
		}
		return liste;
	
	}
	
	
	
	
	
	

	public static ArrayList<RevuePOJO> getByTitleAndDesc (String t, String d) {
		
		
		ArrayList<RevuePOJO> liste = new ArrayList<RevuePOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Revue where title=? and description=? ");			
			requete.setString(1, t);
			requete.setString(2, d);
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = (res.getInt(1));
				String title = (res.getString(2));
				String des = (res.getString(3));
				double tarif = (res.getDouble(4));
				String visu = (res.getString(5));
				int period = (res.getInt(6));
				RevuePOJO r = new RevuePOJO(id,title,des,tarif,visu,period);
				
				liste.add(r);
	
				
				
			}
		
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
	
			
		}
		
		catch (SQLException e )
		{
			System.out.println(e);
		}
		return liste;
	
	}
	

	public static ArrayList<RevuePOJO> getByDesc(String t) {
		
		
		ArrayList<RevuePOJO> liste = new ArrayList<RevuePOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Revue where description=? ");			
			requete.setString(1, t);
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = (res.getInt(1));
				String title = (res.getString(2));
				String des = (res.getString(3));
				double tarif = (res.getDouble(4));
				String visu = (res.getString(5));
				int period = (res.getInt(6));
				RevuePOJO r = new RevuePOJO(id,title,des,tarif,visu,period);
				
				liste.add(r);
	
				
				
			}
		
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
	
			
		}
		
		catch (SQLException e )
		{
			System.out.println(e);
		}
		return liste;
	
	}
	
	
public static ArrayList<RevuePOJO> getByVisuel(String t) {
		
		
		ArrayList<RevuePOJO> liste = new ArrayList<RevuePOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Revue where visuel=? ");			
			requete.setString(1, t);
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = (res.getInt(1));
				String title = (res.getString(2));
				String des = (res.getString(3));
				double tarif = (res.getDouble(4));
				String visu = (res.getString(5));
				int period = (res.getInt(6));
				RevuePOJO r = new RevuePOJO(id,title,des,tarif,visu,period);
				
				liste.add(r);
	
				
				
			}
		
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
	
			
		}
		
		catch (SQLException e )
		{
			System.out.println(e);
		}
		return liste;
	
	}

public static ArrayList<RevuePOJO> getByPeriod(int id1) {
	
	
	ArrayList<RevuePOJO> liste = new ArrayList<RevuePOJO>() ;
	
	
	
	try {
		
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Revue where id_periode =?");			
		requete.setInt(1, id1);
		
		res = requete.executeQuery();
		
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = (res.getInt(1));
			String title = (res.getString(2));
			String des = (res.getString(3));
			double tarif = (res.getDouble(4));
			String visu = (res.getString(5));
			int period = (res.getInt(6));
			RevuePOJO r = new RevuePOJO(id,title,des,tarif,visu,period);
			
			liste.add(r);

			
			
		}
	
		
		if (res != null)
			res.close();
		
		if (requete != null)
			requete.close();
		
		if (laConnexion !=null) 
			laConnexion.close();

		
	}
	
	catch (SQLException e )
	{
		System.out.println(e);
	}
	return liste;

}


public static ArrayList<RevuePOJO> getByTarifInf(double id1) {
	
	
	ArrayList<RevuePOJO> liste = new ArrayList<RevuePOJO>() ;
	
	
	
	try {
		
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Revue where tarifnum <?");			
		requete.setDouble(1, id1);
		
		res = requete.executeQuery();
		
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = (res.getInt(1));
			String title = (res.getString(2));
			String des = (res.getString(3));
			double tarif = (res.getDouble(4));
			String visu = (res.getString(5));
			int period = (res.getInt(6));
			RevuePOJO r = new RevuePOJO(id,title,des,tarif,visu,period);
			
			liste.add(r);

			
			
		}
	
		
		if (res != null)
			res.close();
		
		if (requete != null)
			requete.close();
		
		if (laConnexion !=null) 
			laConnexion.close();

		
	}
	
	catch (SQLException e )
	{
		System.out.println(e);
	}
	return liste;

}


public static ArrayList<RevuePOJO> getByTarif(double id1) {
	
	
	ArrayList<RevuePOJO> liste = new ArrayList<RevuePOJO>() ;
	
	
	
	try {
		
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Revue where tarifnum =?");			
		requete.setDouble(1, id1);
		
		res = requete.executeQuery();
		
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = (res.getInt(1));
			String title = (res.getString(2));
			String des = (res.getString(3));
			double tarif = (res.getDouble(4));
			String visu = (res.getString(5));
			int period = (res.getInt(6));
			RevuePOJO r = new RevuePOJO(id,title,des,tarif,visu,period);
			
			liste.add(r);

			
			
		}
	
		
		if (res != null)
			res.close();
		
		if (requete != null)
			requete.close();
		
		if (laConnexion !=null) 
			laConnexion.close();

		
	}
	
	catch (SQLException e )
	{
		System.out.println(e);
	}
	return liste;

}





	@Override
	public RevuePOJO getById(int id) {
		// TODO Auto-generated method stub
		
		RevuePOJO rev = new RevuePOJO();

		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Revue where id_revue =?");			
			requete.setInt(1, id);
			
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				
				rev.setId_revue(res.getInt(1));
				rev.setTitle(res.getString(2));
				rev.setDescription(res.getString(3));
				rev.setTarifnum(res.getDouble(4));
				rev.setVisuel(res.getString(5));
				rev.setId_periode(res.getInt(6));
				
				
			
				
			}
			
	
	
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
	
			
		}
		
		catch (SQLException e )
		{
			System.out.println(e);
		}
		return rev;
		
	}


	

	@Override
	public Exception create(RevuePOJO objet) {
		// TODO Auto-generated method stub
		

	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
	

		try {

			requete = laConnexion.prepareStatement("INSERT INTO Revue (id_revue, titre, description, tarif_numero, visuel, id_periodicite) VALUES (?,?,?,?,?,?)");
			
			requete.setInt(1,objet.getId_revue());
			requete.setString(2, objet.getTitle());
			requete.setString(3, objet.getDescription());
			requete.setDouble(4,objet.getTarifnum());
			requete.setString(5, objet.getVisuel());
			requete.setInt(6,objet.getId_periode());
			
			requete.executeUpdate();
			
			
		     
			ResultSet res;
		
	
			
			res = requete.executeQuery("select * from Revue");
			

			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
			
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e;
			
		}
		
		return null;
	}


	@Override
	public boolean update(RevuePOJO objet) {
		// TODO Auto-generated method stub
		

	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			requete = laConnexion.prepareStatement("UPDATE Revue SET titre=?, description=?, tarif_numero=?, visuel=?, id_periodicite=? WHERE id_revue =?");
			
			requete.setInt(6,objet.getId_revue());
			requete.setString(1, objet.getTitle());
			requete.setString(2, objet.getDescription());
			requete.setDouble(3,objet.getTarifnum());
			requete.setString(4, objet.getVisuel());
			requete.setInt(5,objet.getId_periode());
			
			requete.executeUpdate();
		
		
				
		ResultSet res;
		
	
			
			res = requete.executeQuery("select * from Revue");
			

			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
			
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return false;
	}


	@Override
	public boolean delete(RevuePOJO objet) {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		


		try {
			
			requete = laConnexion.prepareStatement("delete from Revue where id_revue=?");
			requete.setInt(1, objet.getId_revue());
			
			requete.executeUpdate();
		

				
		ResultSet res;
		

			
			res = requete.executeQuery("select * from Revue");
			
	

			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
			
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return false;
	}




}
