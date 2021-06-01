package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManagerFactory {
	private  static MyEntityManagerFactory instance;
	private EntityManager em;
	private MyEntityManagerFactory(){
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("PTUD_DHKTPM11A_DOAN_NHOM20_FINAL");
		em=fac.createEntityManager();
	}
	
	public synchronized static MyEntityManagerFactory getInstance(){
		if(instance==null)
			instance=new MyEntityManagerFactory();
		return instance;
		
	}
	public EntityManager getEntityManager(){
		return em;
	}
}
