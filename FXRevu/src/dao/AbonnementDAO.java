package dao;
import java.util.ArrayList;

import metier.AbonnementPOJO;


public abstract interface AbonnementDAO<T> extends DAO<AbonnementPOJO>{
	
	public abstract AbonnementPOJO getById(int id1, int id2);

	Exception create(AbonnementPOJO objet);

	boolean delete(AbonnementPOJO objet);

	boolean update(AbonnementPOJO objet);

	}


