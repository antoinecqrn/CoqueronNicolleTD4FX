
package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ClientDAO;
import metier.ClientPOJO;

public class SQLClientDAO  implements ClientDAO {
	
	private static SQLClientDAO instance;
	
	private SQLClientDAO() {}
	

	public static ClientDAO getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new SQLClientDAO();
		}
		
		return instance;
	}

	public ArrayList<ClientPOJO> findAll() {
		
		
		ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
		
		
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Client");			
			
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = res.getInt(1);
				String nom = (res.getString(2));
				String pnom= (res.getString(3));
				String numrue =(res.getString(4));
				String rue =(res.getString(5));
				String cp = (res.getString(6));
				String city = (res.getString(7));
				String pays =(res.getString(8));
				ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
				
				liste.add(cli);
	
				
				
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
	
	
public static ArrayList<ClientPOJO> getByNom(String n) {
		
		
		ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
		
		
		
		try {

			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Client where nom =?");			
			requete.setString(1, n);
			
			res = requete.executeQuery();
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				

				int id = res.getInt(1);
				String nom = (res.getString(2));
				String pnom= (res.getString(3));
				String numrue =(res.getString(4));
				String rue =(res.getString(5));
				String cp = (res.getString(6));
				String city = (res.getString(7));
				String pays =(res.getString(8));
				ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
				
				liste.add(cli);
	
				
				
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


public static ArrayList<ClientPOJO> getByNomAndId(String n, int id1) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where nom =? and id_client=?");			
		requete.setString(1, n);
		requete.setInt(2, id1);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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

public static ArrayList<ClientPOJO> getByPrenomAndId(String n, int id1) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where prenom =? and id_client=?");			
		requete.setString(1, n);
		requete.setInt(2, id1);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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


public static ArrayList<ClientPOJO> getByNomAndPrenom(String n, String p) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where nom =? AND prenom =?");			
		requete.setString(1, n);
		requete.setString(2, p);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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



public static ArrayList<ClientPOJO> getByNomAndPrenomAndId(String n, String p, int id1) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where nom =? AND prenom =? and id_client=?");			
		requete.setString(1, n);
		requete.setString(2, p);
		requete.setInt(3,id1);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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
public static ArrayList<ClientPOJO> getByPrenom(String n) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where prenom =?");			
		requete.setString(1, n);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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


public static ArrayList<ClientPOJO> getByNomAndVille(String n, String v) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where prenom =? and city=?");			
		requete.setString(1, n);
		requete.setString(2, v);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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

public static ArrayList<ClientPOJO> getByNomAndVilleAndId(String n, String v, int idx) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where nom =? and city=? and id_client =?");			
		requete.setString(1, n);
		requete.setString(2, v);
		requete.setInt(3, idx);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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

public static ArrayList<ClientPOJO> getByVilleAndId (String n, int idx) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where city =? and id_client=?");			
		requete.setString(1, n);
		requete.setInt(2, idx);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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


public static ArrayList<ClientPOJO> getByNomAndPays(String n, String v) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where prenom =? and country=?");			
		requete.setString(1, n);
		requete.setString(2, v);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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


public static ArrayList<ClientPOJO> getByNomAndCP(String n, String v) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where prenom =? and cp=?");			
		requete.setString(1, n);
		requete.setString(2, v);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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


public static ArrayList<ClientPOJO> getByNRue(String n) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where num_rue =?");			
		requete.setString(1, n);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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



public static ArrayList<ClientPOJO> getByNRueAndId(String n, int idx) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where num_rue =? and id_client = ?");			
		requete.setString(1, n);
		requete.setInt(2, idx);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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

public static ArrayList<ClientPOJO> getByRue(String n) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where rue =?");			
		requete.setString(1, n);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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


public static ArrayList<ClientPOJO> getByRueAndId(String n, int idx) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where rue =? and id_client = ?");			
		requete.setString(1, n);
		requete.setInt(2, idx);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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


public static ArrayList<ClientPOJO> getByCp(String n) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where cp=?");			
		requete.setString(1, n);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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


public static ArrayList<ClientPOJO> getByCpAndId(String n, int idx) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where cp =? and id_client = ?");			
		requete.setString(1, n);
		requete.setInt(2, idx);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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


public static ArrayList<ClientPOJO> getByCity(String n) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where city =?");			
		requete.setString(1, n);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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


public static ArrayList<ClientPOJO> getByCountryAndId(String n, int idx) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where country =? and id_client = ?");			
		requete.setString(1, n);
		requete.setInt(2, idx);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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

public static ArrayList<ClientPOJO> getByCountry(String n) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where country =?");			
		requete.setString(1, n);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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



public static ArrayList<ClientPOJO> getByAdresse(String n, String r, String v, String cpo, String c) {
	
	
	ArrayList<ClientPOJO> liste = new ArrayList<ClientPOJO>() ;
	
	
	
	try {

		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		ResultSet res;
		
		requete = laConnexion.prepareStatement("select * from Client where num_rue =? and rue =? and city=? and cp =? and country=?");			
		requete.setString(1, n);
		requete.setString(2, r);
		requete.setString(3, v);
		requete.setString(4, cpo);
		requete.setString(5,c);
		
		res = requete.executeQuery();
		
		
		
		while (res.next()) {
			
			System.out.println("requête executée");
			

			int id = res.getInt(1);
			String nom = (res.getString(2));
			String pnom= (res.getString(3));
			String numrue =(res.getString(4));
			String rue =(res.getString(5));
			String cp = (res.getString(6));
			String city = (res.getString(7));
			String pays =(res.getString(8));
			ClientPOJO cli = new ClientPOJO(id,nom,pnom,numrue,rue,cp,city,pays);
			
			liste.add(cli);

			
			
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
	public ClientPOJO getById(int id) {
		// TODO Auto-generated method stub
		
	
		ClientPOJO cli = new ClientPOJO();
		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Client where id_client =?");			
			requete.setInt(1, id);
			
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				
	
				cli.setId_client(res.getInt(1));
				cli.setNom(res.getString(2));
				cli.setPrenom(res.getString(3));
				cli.setNum_rue(res.getString(4));
				cli.setRue(res.getString(5));
				cli.setCp(res.getString(6));
				cli.setCity(res.getString(7));
				cli.setCountry(res.getString(8));
				
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
		return cli;
		
	}



	@Override
	public Exception create(ClientPOJO objet) {
		// TODO Auto-generated method stub
		

	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
	

		try {
			
			requete = laConnexion.prepareStatement("INSERT INTO Client(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays) VALUES(?,?,?,?,?,?,?,?)");
			
			requete.setInt(1,objet.getId_client());
			requete.setString(2,objet.getNom());
			requete.setString(3,objet.getPrenom());
			requete.setString(4,objet.getNum_rue());
			requete.setString(5,objet.getRue());
			requete.setString(6,objet.getCp());
			requete.setString(7,objet.getCity());
			requete.setString(8,objet.getCountry());
			
			requete.executeUpdate();
			
		     
			ResultSet res;
		
	
			
			res = requete.executeQuery("select * from Client");
			

			
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
	public boolean update(ClientPOJO objet) {
		// TODO Auto-generated method stub
		

	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			
			requete = laConnexion.prepareStatement("UPDATE Client SET nom =? , prenom=?, no_rue=?, voie=?, code_postal=?, ville=?, pays=? WHERE id_client =?");
			
			requete.setInt(8,objet.getId_client());
			requete.setString(1,objet.getNom());
			requete.setString(2,objet.getPrenom());
			requete.setString(3,objet.getNum_rue());
			requete.setString(4,objet.getRue());
			requete.setString(5,objet.getCp());
			requete.setString(6,objet.getCity());
			requete.setString(7,objet.getCountry());
			
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
	public boolean delete(ClientPOJO objet) {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		


		try {

			requete = laConnexion.prepareStatement("delete from Client where id_client=?");
			requete.setInt(1, objet.getId_client());
			
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

