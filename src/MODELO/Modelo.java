package MODELO;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JComboBox;

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
	
	public Usuario iniciarSesion(SessionFactory sessionFactory, String usuarioo) {
		Session session=null;
		Usuario u=null;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Query query = session.createSQLQuery("SELECT * FROM USUARIO WHERE USUARIO=:usuario");	
			query.setParameter("usuario", usuarioo);
			List<Object[]> resultado = query.getResultList();
			for (Object[] fila : resultado) {		
				int id = (Integer) fila[0]; 
				String nombre = (String) fila[1]; 
				String usuario = (String) fila[2]; 
				String contrasena = (String) fila[3]; 
				String email = (String) fila[4]; 
				u=new Usuario(nombre, usuario, contrasena, email);
			}
		}catch(HibernateException e2) { e2.printStackTrace();
			if (null != session) { session.getTransaction().rollback(); }
		} finally { if (null != session) { session.close(); } }	
		return u;
	}
	
	public void insertarDatos(SessionFactory sessionFactory, String nombre, String usuario, String contrasena, String email) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Usuario usuario1 =new Usuario();
			usuario1.setNombre(nombre);
			usuario1.setUsuario(usuario);
			usuario1.setContrasena(contrasena);
			usuario1.setEmail(email);
			session.saveOrUpdate(usuario1);	           
			session.getTransaction().commit();				
		}catch(HibernateException e2) { e2.printStackTrace();
			if (null != session) { session.getTransaction().rollback(); }
		} finally { if (null != session) { session.close(); } }
	}
	
	public void mandarMensaje(String email, String nombre, String usuario) {
		try {
        	Properties properties = new Properties();
        	properties.put("mail.smtp.host", "smtp.gmail.com");
        	properties.put("mail.smtp.starttls.enable", "true");
        	properties.put("mail.smtp.port", "25");
        	properties.put("mail.smtp.auth", "true");
            javax.mail.Session ses = javax.mail.Session.getInstance(properties);
            String remitente="danielmarchantero2001@gmail.com";
            String password="ciudadreal12";
            String receptor=email;
            String asunto="- - FIFA 22 - - ";
            String mensaje="¡Hola "+nombre+"!\nTe has registrado como '"+usuario+"'";
            MimeMessage message=new MimeMessage(ses);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
            message.setSubject(asunto);
            message.setText(mensaje);
            Transport t=ses.getTransport("smtp");
			t.connect("smtp.gmail.com", remitente, password);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();    
        } catch (MessagingException e1) { e1.printStackTrace(); }
	}
	
	public Carta sacarJugadores(SessionFactory sessionFactory, int idd) {
		Session session = null;
		Carta carta=null;
		 try {
         	session = sessionFactory.getCurrentSession();
         	session.beginTransaction();
         	Query query = session.createSQLQuery("SELECT * FROM CARTA WHERE ID_CARTA=:id");	
			query.setParameter("id", idd);  
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
         		carta=new Carta(nombre, posicion, pais, equipo, liga, precio, media);
         	}
         }catch(HibernateException e) { e.printStackTrace();
				if (null != session) { session.getTransaction().rollback(); }
         } finally { if (null != session) { session.close(); } }     
		 return carta;
	}
	
}
