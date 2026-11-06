package com.example.dit.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dit.model.Item;


public class ItemDAO {
	
	//1. Get the EntityManagerFactory 
	//2. Get the EntityManager from the Factory when we need to 
	 //talk to the DB
	//3. Call one of the operations on the EntityManager i.e., persist

	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("mydb");


	public ItemDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void persist(Item item) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Item item) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(item));
		em.getTransaction().commit();
		em.close();
	}
	
	
	public Item merge(Item item) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Item updateItem = em.merge(item);
		em.getTransaction().commit();
		em.close();
		return updateItem;	
	}
	
	
	public List<Item> getAllMembers(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Item> items = new ArrayList<Item>();
		items = em.createQuery("from Item").getResultList();
		em.getTransaction().commit();
		em.close();
		return items;
		
	}
	
	public Item getItemById(int itemId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Item iId = em.createQuery("SELECT p FROM Item p WHERE p.itemId = :itemId", Item.class)
				.setParameter("itemId", itemId)
				.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return iId;
	}
	
	public Item getItesmByOwner(int userId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Item uItemId = em.createQuery("SELECT i FROM Item i WHERE i.itemOwner.userId = :userId", Item.class)
				.setParameter("userId", userId)
				.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return uItemId;
	}
	
	
	public Item getItemByQrCode(String itemQrCode) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Item qrC = em.createQuery("SELECT q FROM Item q WHERE q.itemQrCode = :itemQrCode", Item.class)
				.setParameter("itemQrCode", itemQrCode)
				.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return qrC;
	}
	
	
	
	

}
