package listememoire;






import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import dao.AbonnementDAO;
import metier.AbonnementPOJO;

public class ListeMemoireAbonnementDAO implements AbonnementDAO {

	private static ListeMemoireAbonnementDAO instance;

	private ArrayList<AbonnementPOJO> donnees;


	public static ListeMemoireAbonnementDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireAbonnementDAO();
		}

		return instance;
	}

	private ListeMemoireAbonnementDAO() {

		this.donnees = new ArrayList<AbonnementPOJO>();
		

		String date1 = "08/08/2019" ; 
		String date2 = "12/10/2019" ;
		
	    DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate d1 = LocalDate.parse(date1, formatage);
		LocalDate d2 = LocalDate.parse(date2, formatage);


		this.donnees.add(new AbonnementPOJO(0,1,d1,d2));
	}


	@Override
	public Exception create(AbonnementPOJO objet) {

		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId_client(objet.getId_client());
			objet.setNum_abo(objet.getNum_abo());
		}
		
		try {
		boolean ok = this.donnees.add(objet);
		}catch(NullPointerException e) {
			return e;
		}
	
		return null;
	}

	@Override
	public boolean update(AbonnementPOJO objet) {
		
		// Ne fonctionne que si l'objet métier est bien fait...
		
		
		AbonnementPOJO abo = this.donnees.get(objet.getNum_abo()-1);
		
		int idx = this.donnees.indexOf(abo);
		
		
		//int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, objet);
		}
		
		return true;
	}

	@Override
	public boolean delete(AbonnementPOJO objet) {


		AbonnementPOJO abo = this.donnees.get(objet.getNum_abo()-1);

		
		int idx = this.donnees.indexOf(abo);
		
		
		// Ne fonctionne que si l'objet métier est bien fait...
		// int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			abo = this.donnees.remove(idx);
		}
		
		return objet.equals(abo);
	}

	@Override
	public AbonnementPOJO getById(int id1,int id2) {
		
		for (int i =0; i< this.donnees.size(); i++) {
			if (this.donnees.get(i).getNum_abo()==id1){
				return this.donnees.get(i);
			}
		}
		
		return null;
		

	
	}
	
public AbonnementPOJO getByNumAbo(int id1) {
		
		for (int i =0; i< this.donnees.size(); i++) {
			if (this.donnees.get(i).getNum_abo()==id1){
				return this.donnees.get(i);
			}
		}
		
		return null;
	}

public AbonnementPOJO getByClient(int id1) {
	
	for (int i =0; i< this.donnees.size(); i++) {
		if (this.donnees.get(i).getId_client()==id1){
			return this.donnees.get(i);
		}
	}
	
	return null;
}

public AbonnementPOJO getByDatedeb(LocalDate d) {
	
	for (int i =0; i< this.donnees.size(); i++) {
		if (this.donnees.get(i).getDatedeb()==d){
			return this.donnees.get(i);
		}
	}
	
	return null;
}

public AbonnementPOJO getByDatefin(LocalDate d) {
	
	for (int i =0; i< this.donnees.size(); i++) {
		if (this.donnees.get(i).getDatefin()==d){
			return this.donnees.get(i);
		}
	}
	
	return null;
}







	public ArrayList<AbonnementPOJO> findAll() {
		return this.donnees;
	}

	@Override
	public AbonnementPOJO getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
