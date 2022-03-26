package MODELO;

import java.math.BigInteger;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Modelo {
	
	public static void main (String [] args) throws Exception {
        SessionFactory sessionFactory = null;
        try {
        	
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
            sessionFactory.getCurrentSession().beginTransaction();
            Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM CARTA;");		
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
    			Integer ritmo = (Integer) fila[8]; 
    			Integer tiro = (Integer) fila[9]; 
    			Integer pase = (Integer) fila[10]; 
    			Integer regate = (Integer) fila[11]; 
    			Integer defensa = (Integer) fila[12]; 
    			Integer fisico = (Integer) fila[13]; 
    			System.out.println(id+"-"+nombre+"-"+posicion+"-"+pais+"-"+equipo+"-"+liga+"-"+precio+"€-"+media+"-RIT:"+ritmo
    					                   +"-TIR:"+tiro+"-PAS:"+pase+"-REG:"+regate+"-DEF:"+defensa+"-FIS:"+fisico);
		
    			 System.out.println("--------------------------------------------------------------------------------------------------------------");			
    		}
        } catch (Exception e) { e.printStackTrace(); throw e;
		} finally { if(sessionFactory != null) { sessionFactory.close(); } }
    }

}
