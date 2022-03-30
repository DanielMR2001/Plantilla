package MODELO;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Modelo {
	
	public static void main (String [] args) throws Exception {
        
		SessionFactory sessionFactory = null;
        Session session=null;
        
        try {      	
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
            sessionFactory.getCurrentSession();
            
            try {
            	session = sessionFactory.getCurrentSession();
            	session.beginTransaction();
            	Query query = session.createSQLQuery("SELECT * FROM CARTA;");		
            	List<Object[]> resultado = query.list();
            	for (Object[] fila : resultado) {		
            		Integer id = (Integer) fila[0]; 
            		String nombre = (String) fila[1]; 
            		String posicion = (String) fila[2]; 
            		String pais = (String) fila[3]; 
            		String equipo = (String) fila[4]; 
            		String liga = (String) fila[5]; 
            		Integer precio = (Integer) fila[6]; 
            		Integer media = (Integer) fila[7]; 
    			
            		System.out.println(id+"-"+nombre+"-"+posicion+"-"+pais+"-"+equipo+"-"+liga+"-"+precio+"€-"+media);
            		System.out.println("-------------------------------------------------------------------");			
            	}
            }catch(HibernateException e) { e.printStackTrace();
				if (null != session) { session.getTransaction().rollback(); }
            } finally { if (null != session) { session.close(); } }
            
        } catch (Exception e) { e.printStackTrace(); throw e;
		} finally { if(sessionFactory != null) { sessionFactory.close(); } }
    }

}
