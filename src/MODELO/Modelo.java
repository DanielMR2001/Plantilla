package MODELO;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import MODELO.Plantilla;

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
            	Query query = session.createSQLQuery("SELECT * FROM CARTAS;");		
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
	
	//consultar en la bbdd si se hace bien el inicio de sesion
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
				u=new Usuario(id, nombre, usuario, contrasena, email);
			}
		}catch(HibernateException e2) { e2.printStackTrace();
			if (null != session) { session.getTransaction().rollback(); }
		} finally { if (null != session) { session.close(); } }	
		return u;
	}
	
	//guardar en la bbdd los datos que se registren
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
	
	//mandar mensaje de confirmacion al correo con el que se ha registrado 
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
            String asunto="- - FIFA INTERNATIONAL SOCCER 2022 - - ";
            String mensaje="¡Hola "+nombre+"!\nTe has registrado en como '"+usuario+"'";
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
	
	//consultar todos las cartas de la bbdd para comprarlas
	public Cartas sacarJugadores(SessionFactory sessionFactory, int idd) {
		Session session = null;
		Cartas carta=null;
		 try {
         	session = sessionFactory.getCurrentSession();
         	session.beginTransaction();
         	Query query = session.createSQLQuery("SELECT * FROM CARTAS WHERE ID_CARTA=:id");	
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
         		carta=new Cartas(id, nombre, posicion, pais, equipo, liga, precio, media);
         	}
         }catch(HibernateException e) { e.printStackTrace();
				if (null != session) { session.getTransaction().rollback(); }
         } finally { if (null != session) { session.close(); } }     
		 return carta;
	}
	
	//consultar todos las cartas compradas de la bbdd
		public CartasCompradas sacarJugadoresComprados(SessionFactory sessionFactory, String pos) {
			Session session = null;
			CartasCompradas cartaComprada=null;
			 try {
	         	session = sessionFactory.getCurrentSession();
	         	session.beginTransaction();
	         	Query query = session.createSQLQuery("SELECT * FROM CARTAS_COMPRADAS WHERE POSICION_CARTA_COMPRADA=:pos");	
				query.setParameter("pos", pos);  
	         	List<Object[]> resultado = query.list();
	         	for (Object[] fila : resultado) {		
	         		String id = (String) fila[0]; 
	         		String nombre = (String) fila[1]; 
	         		String posicion = (String) fila[2]; 
	         		String pais = (String) fila[3]; 
	         		String equipo = (String) fila[4]; 
	         		String liga = (String) fila[5]; 
	         		Integer precio = (Integer) fila[6]; 
	         		Integer media = (Integer) fila[7];  			
	         		System.out.println(id+"-"+nombre+"-"+posicion+"-"+pais+"-"+equipo+"-"+liga+"-"+precio+"€-"+media);
	         		cartaComprada=new CartasCompradas(id, nombre, posicion, pais, equipo, liga, precio, media);
	         	}
	         }catch(HibernateException e) { e.printStackTrace();
					if (null != session) { session.getTransaction().rollback(); }
	         } finally { if (null != session) { session.close(); } }     
			 return cartaComprada;
		}
		
		//sacarPrecio para vender la carta
		public CartasCompradas sacarPrecio(SessionFactory sessionFactory, String nombre) {
			Session session = null;
			CartasCompradas cartaComprada=null;
			 try {
	         	session = sessionFactory.getCurrentSession();
	         	session.beginTransaction();
	         	Query query = session.createSQLQuery("SELECT * FROM CARTAS_COMPRADAS WHERE NOMBRE_CARTA_COMPRADA=:nombre");	
				query.setParameter("nombre", nombre);  
	         	List<Object[]> resultado = query.list();
	         	for (Object[] fila : resultado) {		
	         		String id = (String) fila[0]; 
	         		String nombree = (String) fila[1]; 
	         		String posicion = (String) fila[2]; 
	         		String pais = (String) fila[3]; 
	         		String equipo = (String) fila[4]; 
	         		String liga = (String) fila[5]; 
	         		Integer precio = (Integer) fila[6]; 
	         		Integer media = (Integer) fila[7];  			
	         		System.out.println(id+"-"+nombre+"-"+posicion+"-"+pais+"-"+equipo+"-"+liga+"-"+precio+"€-"+media);
	         		cartaComprada=new CartasCompradas(id, nombre, posicion, pais, equipo, liga, precio, media);
	         	}
	         }catch(HibernateException e) { e.printStackTrace();
					if (null != session) { session.getTransaction().rollback(); }
	         } finally { if (null != session) { session.close(); } }     
			 return cartaComprada;
		}
		
		public void borrarDatosCartaVendida(String nombre) {
			SessionFactory sessionFactory = null;
			Session session=null;
			try {
				Configuration configuration = new Configuration();
	            configuration.configure("hibernate.cfg.xml");
	            sessionFactory = configuration.buildSessionFactory();
	            sessionFactory.getCurrentSession();
	            
				session=sessionFactory.getCurrentSession();
				session.beginTransaction();
				Query q1=session.createQuery("FROM CartasCompradas WHERE nombreCartaComprada=:nombre");
				q1.setParameter("nombre", nombre);
				List<Object[]>lista=q1.list();
				for(Object list:lista) {
					session.delete(list);	
				}		
				session.getTransaction().commit();
			}catch(HibernateException e) {e.printStackTrace();
				if(session!=null) {session.getTransaction().rollback();}
			}finally {if(session!=null) {session.close();}}
		}
	
	//consultar en la bbdd la carta que se quiera comprar
	public Cartas comprarJugadores(SessionFactory sessionFactory, String nombre, String pais, int media, String equipo) {
		Session session = null;
		Cartas carta=null;
		 try {
         	session = sessionFactory.getCurrentSession();
         	session.beginTransaction();
         	Query query = session.createSQLQuery("SELECT * FROM CARTAS WHERE NOMBRE=:nombre AND PAIS=:pais AND EQUIPO=:equipo AND MEDIA=:media");	
			query.setParameter("nombre", nombre);  
			query.setParameter("pais", pais);  
			query.setParameter("equipo", equipo);  
			query.setParameter("media", media);  
         	List<Object[]> resultado = query.list();
         	for (Object[] fila : resultado) {		
         		Integer idJuagdor = (Integer) fila[0]; 
         		String nombreJuagdor = (String) fila[1]; 
         		String posicionJuagdor = (String) fila[2]; 
         		String paisJuagdor = (String) fila[3]; 
         		String equipoJuagdor = (String) fila[4]; 
         		String ligaJuagdor = (String) fila[5]; 
         		Integer precioJuagdor = (Integer) fila[6]; 
         		Integer mediaJuagdor = (Integer) fila[7]; 			
         		System.out.println("COMPRAR--"+idJuagdor+"-"+nombreJuagdor+"-"+posicionJuagdor+"-"+paisJuagdor+"-"+equipoJuagdor+"-"+ligaJuagdor+"-"+precioJuagdor+"€-"+mediaJuagdor);
         		carta=new Cartas(idJuagdor, nombreJuagdor, posicionJuagdor, paisJuagdor, equipoJuagdor, ligaJuagdor, precioJuagdor, mediaJuagdor);
         	}
         }catch(HibernateException e) { e.printStackTrace();
				if (null != session) { session.getTransaction().rollback(); }
         } finally { if (null != session) { session.close(); } }     
		 return carta;
	}
	
	//insertar en la bbdd la carta comprada
	public void insertarCarta(SessionFactory sessionFactory, Cartas carta, String id) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			CartasCompradas cartaComprada =new CartasCompradas();
			cartaComprada.setIdCartaComprada(id);
			cartaComprada.setEquipoCartaComprada(carta.getEquipo());
			cartaComprada.setLigaCartaComprada(carta.getLiga());
			cartaComprada.setMediaCartaComprada(carta.getMedia());
			cartaComprada.setNombreCartaComprada(carta.getNombre());
			cartaComprada.setPaisCartaComprada(carta.getPais());
			cartaComprada.setPosicionCartaComprada(carta.getPosicion());
			cartaComprada.setPrecioCartaComprada(carta.getPrecio());
			session.saveOrUpdate(cartaComprada);	
			session.getTransaction().commit();				
		}catch(HibernateException e2) { e2.printStackTrace();
			if (null != session) { session.getTransaction().rollback(); }
		} finally { if (null != session) { session.close(); } }
	}
	
	public void insertarPlantilla(SessionFactory sessionFactory, String nombre, int puntos) {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Plantilla plantilla =new Plantilla();
			plantilla.setNombrePlantilla(nombre);
			plantilla.setPuntosPlantilla(puntos);
			session.saveOrUpdate(plantilla);	
			session.getTransaction().commit();				
		}catch(HibernateException e2) { e2.printStackTrace();
			if (null != session) { session.getTransaction().rollback(); }
		} finally { if (null != session) { session.close(); } }
	}
	
	//listar el nombre y puntos de la plantilla para el ranking
		public ArrayList<Plantilla> listarUsuario(SessionFactory sessionFactory) {
			Session session = null;
			Plantilla plantilla=null;
			ArrayList<Plantilla>listaPlantilla=new ArrayList<>();			
			try {
		      session = sessionFactory.getCurrentSession();
		      session.beginTransaction();
		      Query query = session.createSQLQuery("SELECT * FROM PLANTILLA");	
		      List<Object[]> resultado = query.list();
		          for (Object[] fila : resultado) {		
		         	Integer id = (Integer) fila[0]; 
		         	String nombree = (String) fila[1]; 
		         	Integer media = (Integer) fila[2];  			
		         	System.out.println(id+"-"+nombree+"-"+media);
		         	plantilla=new Plantilla(id, nombree, media);
		         	listaPlantilla.add(plantilla);
		         }
		       }catch(HibernateException e) { e.printStackTrace();
					if (null != session) { session.getTransaction().rollback(); }
		       } finally { if (null != session) { session.close(); } }     
			 return listaPlantilla;
		}

	//borrar datos de la tabla 'cartas compradas' al cerrar la aplicación
	public void borrarDatosTabla() {
		SessionFactory sessionFactory = null;
		Session session=null;
		try {
			Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
            sessionFactory.getCurrentSession();
            
			session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			Query q1=session.createQuery("FROM CartasCompradas WHERE idCartaComprada>0");
			List<Object[]>lista=q1.list();
			for(Object list:lista) {
				session.delete(list);	
			}		
			session.getTransaction().commit();
		}catch(HibernateException e) {e.printStackTrace();
			if(session!=null) {session.getTransaction().rollback();}
		}finally {if(session!=null) {session.close();}}
	}
	
}