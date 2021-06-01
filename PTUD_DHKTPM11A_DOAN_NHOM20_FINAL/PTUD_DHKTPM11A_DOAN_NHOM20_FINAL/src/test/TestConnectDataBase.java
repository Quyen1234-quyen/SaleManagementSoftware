package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.MyEntityManagerFactory;

public class TestConnectDataBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = MyEntityManagerFactory.getInstance().getEntityManager();   
		EntityTransaction trans = em.getTransaction(); 
		try {
			trans.begin();  
			System.out.println("ketnoithanhcong");
			trans.commit();
		}catch(Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}

}
