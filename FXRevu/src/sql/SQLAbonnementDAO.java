
package sql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import dao.AbonnementDAO;
import metier.AbonnementPOJO;


public class SQLAbonnementDAO  implements AbonnementDAO {
	
	private static SQLAbonnementDAO instance;
	
	private SQLAbonnementDAO() {}
	

	public static AbonnementDAO getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new SQLAbonnementDAO();
		}
		
		return instance;
	}
	
	
	public ArrayList<AbonnementPOJO> findAll() {
		
		
		ArrayList<AbonnementPOJO> liste = new ArrayList<AbonnementPOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Abonnement");			
			
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = res.getInt(1);
				int num = (res.getInt(2));
				LocalDate deb = (res.getDate(3).toLocalDate());
				LocalDate fin = (res.getDate(4).toLocalDate());
				AbonnementPOJO abo = new AbonnementPOJO(id,num,deb,fin);
				
				liste.add(abo);
	
				
				
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
	
	
	public static ArrayList<AbonnementPOJO> getByClient(int id1) {
		
		
		ArrayList<AbonnementPOJO> liste = new ArrayList<AbonnementPOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Abonnement where id_client=?");			
			requete.setInt(1, id1);
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = res.getInt(1);
				int num = (res.getInt(2));
				LocalDate deb = (res.getDate(3).toLocalDate());
				LocalDate fin = (res.getDate(4).toLocalDate());
				AbonnementPOJO abo = new AbonnementPOJO(id,num,deb,fin);
				
				liste.add(abo);
	
				
				
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
	

	public static ArrayList<AbonnementPOJO> getByAbo(int id1) {
		
		
		ArrayList<AbonnementPOJO> liste = new ArrayList<AbonnementPOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Abonnement where num_abo=?");			
			requete.setInt(1, id1);
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = res.getInt(1);
				int num = (res.getInt(2));
				LocalDate deb = (res.getDate(3).toLocalDate());
				LocalDate fin = (res.getDate(4).toLocalDate());
				AbonnementPOJO abo = new AbonnementPOJO(id,num,deb,fin);
				
				liste.add(abo);
	
				
				
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
	
	

	public static ArrayList<AbonnementPOJO> getByAboAndId(int id1, int idx) {
		
		
		ArrayList<AbonnementPOJO> liste = new ArrayList<AbonnementPOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Abonnement where num_abo=? and id_client=?");			
			requete.setInt(1, id1);
			requete.setInt(2, idx);
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = res.getInt(1);
				int num = (res.getInt(2));
				LocalDate deb = (res.getDate(3).toLocalDate());
				LocalDate fin = (res.getDate(4).toLocalDate());
				AbonnementPOJO abo = new AbonnementPOJO(id,num,deb,fin);
				
				liste.add(abo);
	
				
				
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
	
public static ArrayList<AbonnementPOJO> getByDatedeb(LocalDate d) {
		
		
		ArrayList<AbonnementPOJO> liste = new ArrayList<AbonnementPOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Abonnement where datedeb=?");			
			requete.setDate(1, java.sql.Date.valueOf(d));
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = res.getInt(1);
				int num = (res.getInt(2));
				LocalDate deb = (res.getDate(3).toLocalDate());
				LocalDate fin = (res.getDate(4).toLocalDate());
				AbonnementPOJO abo = new AbonnementPOJO(id,num,deb,fin);
				
				liste.add(abo);
	
				
				
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



public static ArrayList<AbonnementPOJO> getByDatedebAndId(LocalDate d, int idx) {
	
	
	ArrayList<AbonnementPOJO> liste = new ArrayList<AbonnementPOJO>() ;
	
	
	
	try {
		
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Abonnement where datedeb=? and id_client =?");			
		requete.setDate(1, java.sql.Date.valueOf(d));
		requete.setInt(2, idx);
		res = requete.executeQuery();
		
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			int num = (res.getInt(2));
			LocalDate deb = (res.getDate(3).toLocalDate());
			LocalDate fin = (res.getDate(4).toLocalDate());
			AbonnementPOJO abo = new AbonnementPOJO(id,num,deb,fin);
			
			liste.add(abo);

			
			
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


public static ArrayList<AbonnementPOJO> getByDatefin(LocalDate d) {
	
	
	ArrayList<AbonnementPOJO> liste = new ArrayList<AbonnementPOJO>() ;
	
	
	
	try {
		
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Abonnement where datefin=?");			
		requete.setDate(1, java.sql.Date.valueOf(d));
		res = requete.executeQuery();
		
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			int num = (res.getInt(2));
			LocalDate deb = (res.getDate(3).toLocalDate());
			LocalDate fin = (res.getDate(4).toLocalDate());
			AbonnementPOJO abo = new AbonnementPOJO(id,num,deb,fin);
			
			liste.add(abo);

			
			
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


public static ArrayList<AbonnementPOJO> getByDatefinAndId(LocalDate d, int idx) {
	
	
	ArrayList<AbonnementPOJO> liste = new ArrayList<AbonnementPOJO>() ;
	
	
	
	try {
		
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Abonnement where datefin=? and id_client =?");			
		requete.setDate(1, java.sql.Date.valueOf(d));
		requete.setInt(2, idx);
		res = requete.executeQuery();
		
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			int num = (res.getInt(2));
			LocalDate deb = (res.getDate(3).toLocalDate());
			LocalDate fin = (res.getDate(4).toLocalDate());
			AbonnementPOJO abo = new AbonnementPOJO(id,num,deb,fin);
			
			liste.add(abo);

			
			
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

public static ArrayList<AbonnementPOJO> getByDates(LocalDate d1, LocalDate d2) {
	
	
	ArrayList<AbonnementPOJO> liste = new ArrayList<AbonnementPOJO>() ;
	
	
	
	try {
		
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Abonnement where datedeb=? AND  datefin=?");			
		requete.setDate(1, java.sql.Date.valueOf(d1));
		requete.setDate(2, java.sql.Date.valueOf(d2));
		res = requete.executeQuery();
		
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			int num = (res.getInt(2));
			LocalDate deb = (res.getDate(3).toLocalDate());
			LocalDate fin = (res.getDate(4).toLocalDate());
			AbonnementPOJO abo = new AbonnementPOJO(id,num,deb,fin);
			
			liste.add(abo);

			
			
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


public static ArrayList<AbonnementPOJO> getByDatesAndRevue(LocalDate d1, LocalDate d2, int r) {
	
	
	ArrayList<AbonnementPOJO> liste = new ArrayList<AbonnementPOJO>() ;
	
	
	
	try {
		
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Abonnement where datedeb=? AND  datefin=? AND id_revue =? ");			
		requete.setDate(1, java.sql.Date.valueOf(d1));
		requete.setDate(2, java.sql.Date.valueOf(d2));
		requete.setInt(3, r);
		res = requete.executeQuery();
		
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			int num = (res.getInt(2));
			LocalDate deb = (res.getDate(3).toLocalDate());
			LocalDate fin = (res.getDate(4).toLocalDate());
			AbonnementPOJO abo = new AbonnementPOJO(id,num,deb,fin);
			
			liste.add(abo);

			
			
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



public static ArrayList<AbonnementPOJO> getByDatesAndClient(LocalDate d1, LocalDate d2, int r) {
	
	
	ArrayList<AbonnementPOJO> liste = new ArrayList<AbonnementPOJO>() ;
	
	
	
	try {
		
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Abonnement where datedeb=? AND  datefin=? AND id_client =? ");			
		requete.setDate(1, java.sql.Date.valueOf(d1));
		requete.setDate(2, java.sql.Date.valueOf(d2));
		requete.setInt(3, r);
		res = requete.executeQuery();
		
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			int num = (res.getInt(2));
			LocalDate deb = (res.getDate(3).toLocalDate());
			LocalDate fin = (res.getDate(4).toLocalDate());
			AbonnementPOJO abo = new AbonnementPOJO(id,num,deb,fin);
			
			liste.add(abo);

			
			
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




public static ArrayList<AbonnementPOJO> getByDateDebAndRevue(LocalDate d1, int d2) {
	
	
	ArrayList<AbonnementPOJO> liste = new ArrayList<AbonnementPOJO>() ;
	
	
	
	try {
		
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Abonnement where datedeb=? AND id_revue=?");			
		requete.setDate(1, java.sql.Date.valueOf(d1));
		requete.setInt(2,d2);
		res = requete.executeQuery();
		
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			int num = (res.getInt(2));
			LocalDate deb = (res.getDate(3).toLocalDate());
			LocalDate fin = (res.getDate(4).toLocalDate());
			AbonnementPOJO abo = new AbonnementPOJO(id,num,deb,fin);
			
			liste.add(abo);

			
			
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


public static ArrayList<AbonnementPOJO> getByDateFinAndRevue(LocalDate d1, int d2) {
	
	
	ArrayList<AbonnementPOJO> liste = new ArrayList<AbonnementPOJO>() ;
	
	
	
	try {
		
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Abonnement where datefin=? AND id_revue=?");			
		requete.setDate(1, java.sql.Date.valueOf(d1));
		requete.setInt(2,d2);
		res = requete.executeQuery();
		
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			int num = (res.getInt(2));
			LocalDate deb = (res.getDate(3).toLocalDate());
			LocalDate fin = (res.getDate(4).toLocalDate());
			AbonnementPOJO abo = new AbonnementPOJO(id,num,deb,fin);
			
			liste.add(abo);

			
			
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
	public AbonnementPOJO getById(int id1, int id2) {
		// TODO Auto-generated method stub
		
		AbonnementPOJO abo = new AbonnementPOJO();

		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Abonnement where id_client =? and id_revue=? ");			
			requete.setInt(1, id1);
			requete.setInt(2, id2);
			
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				abo.setId_client(res.getInt(1));
				abo.setNum_abo(res.getInt(2));
				abo.setDatedeb(res.getDate(3).toLocalDate());
				abo.setDatefin(res.getDate(4).toLocalDate());
			
				
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
		return abo;
		
	}



	@Override
	public Exception create(AbonnementPOJO objet) {
		// TODO Auto-generated method stub
		

	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
	

		try {

			requete = laConnexion.prepareStatement("INSERT INTO Abonnement(id_client, id_revue, date_debut, date_fin) VALUES (?,?,?,?) ");
			requete.setInt(1, objet.getId_client());
			requete.setInt(2, objet.getNum_abo());
			requete.setDate(3, java.sql.Date.valueOf(objet.getDatedeb()));
			requete.setDate(4, java.sql.Date.valueOf(objet.getDatefin()));
			
			requete.executeUpdate(); 
		     
			ResultSet res;
		
	
			
			res = requete.executeQuery("select * from Abonnement");

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
	public boolean update(AbonnementPOJO objet) {
		// TODO Auto-generated method stub
		

	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			
			requete = laConnexion.prepareStatement("UPDATE Abonnement SET  date_debut =?, date_fin =? WHERE id_client =? AND id_revue =?  ");
			requete.setInt(3, objet.getId_client());
			requete.setInt(4, objet.getNum_abo());
			requete.setDate(1, java.sql.Date.valueOf(objet.getDatedeb()));
			requete.setDate(2, java.sql.Date.valueOf(objet.getDatefin()));
			
			requete.executeUpdate(); 
		
		
				
		ResultSet res;
		
	
			
			res = requete.executeQuery("select * from Abonnement");
			

			
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
	public boolean delete(AbonnementPOJO objet) {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		


		try {


			requete = laConnexion.prepareStatement("delete from Abonnement where id_client=? and id_revue =? ");
			requete.setInt(1, objet.getId_client());
			requete.setInt(2,objet.getNum_abo());
			requete.executeUpdate(); 
				
		ResultSet res;
		

			
			res = requete.executeQuery("select * from Abonnement");
		

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
	public AbonnementPOJO getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}




}

