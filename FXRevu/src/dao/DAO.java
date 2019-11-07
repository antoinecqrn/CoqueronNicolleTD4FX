package dao;

import java.util.ArrayList;

import metier.RevuePOJO;

public interface DAO <T>{
	
	public abstract T getById(int id);
	public abstract Exception create(T objet);
	public abstract boolean update(T objet);
	public abstract boolean delete(T objet);
	public abstract ArrayList<T> findAll();
	

}
