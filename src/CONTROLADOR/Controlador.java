package CONTROLADOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import MODELO.Usuario;
import VISTA.Login;
import VISTA.Plantilla;

public class Controlador implements ActionListener{
	
	Plantilla plantilla=new Plantilla();
	Login login=new Login();
	SessionFactory sessionFactory = null;
	Clip sonido=null;

	//CONSTRUCTOR PARA LA INTERFAZ DEL LOGIN
	public Controlador(VISTA.Plantilla plantilla) {
		this.plantilla=plantilla;		
	}
	
	//CONSTRUCTOR PARA LA INTERFAZ DE DISEÑO DE PLANTILLA
	public Controlador(VISTA.Login login) {
		this.login=login;
		this.login.iniciarSesion.addActionListener(this);
		this.login.aceptar1.addActionListener(this);
		this.login.aceptar2.addActionListener(this);
		this.login.registrar.addActionListener(this);
		this.login.sonido.addActionListener(this);
		this.login.silencio.addActionListener(this);

		//musica de fondo desde que se ejecuta la aplicacion hasta que se cierra
		
		
		//CONFIGURACION DEL HIBERNATE
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		sessionFactory.getCurrentSession();
		}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {

			if((e.getSource()==login.sonido)) {
				sonido = AudioSystem.getClip();	            
				sonido.open(AudioSystem.getAudioInputStream(new File("musica.wav")));	            
				sonido.start();
				sonido.loop(Clip.LOOP_CONTINUOUSLY);
				login.sonido.setVisible(false);
				login.silencio.setVisible(true);
			}else if(e.getSource()==login.silencio) {
				sonido.close();
				login.sonido.setVisible(true);
				login.silencio.setVisible(false);
			}
			
			//FUNCIONALIDAD SI SE PULSA EL BOTÓN DE INICIAR SESIÓN
			if(e.getSource()==login.iniciarSesion) {
				login.nombreRegistro.setText(""); login.usuarioRegistro.setText(""); login.contrasenaRegistro.setText(""); login.emailRegistro.setText(""); login.corregir2.setText("");
				login.loguear.setVisible(true);	login.registro.setVisible(false); login.iniciarSesion.setVisible(false); login.registrar.setVisible(true); login.aceptar1.setVisible(true); login.aceptar2.setVisible(false);
			}		
		
			//FUNCIONALIDAD SI SE PULSA EL BOTÓN DE ACEPTAR PARA INICIAR SESIÓN
			if(e.getSource()==login.aceptar1) {
				String usuario=login.usuarioInicioSesion.getText();
				String contrasena=login.contrasenaInicioSesion.getText();
				Boolean usuarioBoolean=usuario.isEmpty();
				Boolean contrasenaBoolean=contrasena.isEmpty();
			
				String usuariousuarioBBDD="";
				String contrasenaUsuarioBBDD="";
				String emailUsuarioBBDD="";
				Integer idUsuarioBBDD=0;
				String nombreUsuarioBBDD="";
			
				//sacar los datos de los usuarios registrados para comprobar el inicio de sesion
				Session session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				Query query = session.createSQLQuery("SELECT * FROM USUARIO WHERE USUARIO=:usuario");	
				query.setParameter("usuario", usuario);  
				List<Object[]> resultado = query.list();
				for (Object[] fila : resultado) {		
					idUsuarioBBDD = (Integer) fila[0]; 
					nombreUsuarioBBDD = (String) fila[1]; 
					usuariousuarioBBDD = (String) fila[2]; 
					contrasenaUsuarioBBDD = (String) fila[3]; 
					emailUsuarioBBDD = (String) fila[4];     			
				}
			
				//comprobar que se han rellenado los campos de inicio sesión
				if((usuarioBoolean==true)||(contrasenaBoolean==true)) {
					login.corregir.setText("");
					login.corregir.setText("       *Rellene Todos Los Campos*");	
				}else if(usuario.equalsIgnoreCase(usuariousuarioBBDD)&&(contrasena.equalsIgnoreCase(contrasenaUsuarioBBDD))){										
					//mandar un mensaje de confirmacion al email que se introdujo en el registro
					/*try {
		            	Properties properties = new Properties();
		            	properties.put("mail.smtp.host", "smtp.gmail.com");
		            	properties.put("mail.smtp.starttls.enable", "true");
		            	properties.put("mail.smtp.port", "25");
		            	properties.put("mail.smtp.auth", "true");
		                javax.mail.Session ses = javax.mail.Session.getInstance(properties);
		                String remitente="danielmarchantero2001@gmail.com";
		                String password="ciudadreal12";
		                String receptor=emailUsuarioBBDD;
		                String asunto="- - FIFA 22 - - ";
		                String mensaje="SESIÓN INICIADA COMO -"+usuariousuarioBBDD+"-";
		                MimeMessage message=new MimeMessage(ses);
		                message.setFrom(new InternetAddress(remitente));
		                message.setRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
		                message.setSubject(asunto);
		                message.setText(mensaje);
		                Transport t=ses.getTransport("smtp");
	        			t.connect("smtp.gmail.com", remitente, password);
		                t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		                t.close();    
		            } catch (MessagingException e1) { e1.printStackTrace(); } */
					JOptionPane.showMessageDialog(null, "INICIO DE SESIÓN CONFIRMADO\n            USUARIO: "+usuariousuarioBBDD,"INICIAR SESION", JOptionPane.INFORMATION_MESSAGE);
					Plantilla p=new Plantilla();
					p.setVisible(true);
					login.setVisible(false); 
				}else{
					JOptionPane.showMessageDialog(null, "CONTRASEÑA Y/O USUARIO INCORRECTO","INICIAR SESION", JOptionPane.ERROR_MESSAGE);
					login.usuarioInicioSesion.setText("");
					login.contrasenaInicioSesion.setText("");
				}
			}
		
			//FUNCIONALIDAD SI SE PULSA EL BOTÓN DE REGISTRARSE
			if(e.getSource()==login.registrar) {
				login.corregir.setText(""); login.usuarioInicioSesion.setText(""); login.contrasenaInicioSesion.setText("");
				login.loguear.setVisible(false); login.registro.setVisible(true); login.iniciarSesion.setVisible(true); login.aceptar1.setVisible(false); login.registrar.setVisible(false); login.aceptar2.setVisible(true);
			}
		
			//FUNCIONALIDAD SI SE PULSA EL BOTÓN DE ACEPTAR PARA REGISTRARSE
			if(e.getSource()==login.aceptar2) {
				String nombre=login.nombreRegistro.getText();
				String contrasena=login.contrasenaRegistro.getText();
				String usuario=login.usuarioRegistro.getText();
				String email=login.emailRegistro.getText();
			
				Boolean usuarioBoolean=usuario.isEmpty();
				Boolean contrasenaBoolean=contrasena.isEmpty();
				Boolean nombreBoolean=nombre.isEmpty();
				Boolean emailBoolean=email.contains("@");

				//comprobar que se han rellenado los campos de registrarse
				if((usuarioBoolean==true)||(contrasenaBoolean==true)||(nombreBoolean==true)||(emailBoolean==false)) {
					login.corregir2.setText("");
					login.corregir2.setText("       *Rellene Todos Los Campos*");	
				}else{
					JOptionPane.showMessageDialog(null, "USUARIO REGISTRADO\n            USUARIO: "+usuario,"REGISTRO", JOptionPane.INFORMATION_MESSAGE);
					String nombreUsuario=login.nombreRegistro.getText();
					String usuarioUsuario=login.usuarioRegistro.getText();
					String contraseñaUsuario=login.contrasenaRegistro.getText();
					String emailUsuario=login.emailRegistro.getText();
				
					//insertar los nuevos usuarios en la BBDD
					Session session = null;
					try {
						session = sessionFactory.getCurrentSession();
						session.beginTransaction();
						Usuario usuario1 =new Usuario();
						usuario1.setNombre(nombreUsuario);
						usuario1.setUsuario(usuarioUsuario);
						usuario1.setContrasena(contraseñaUsuario);
						usuario1.setEmail(emailUsuario);
						session.saveOrUpdate(usuario1);	           
						session.getTransaction().commit();				
					}catch(HibernateException e2) { e2.printStackTrace();
						if (null != session) { session.getTransaction().rollback(); }
					} finally { if (null != session) { session.close(); } }
				
					login.nombreRegistro.setText(""); login.usuarioRegistro.setText(""); login.contrasenaRegistro.setText(""); login.emailRegistro.setText(""); login.corregir2.setText("");
					}
				}	
			} catch (Exception e3) { e3.printStackTrace();
			} finally { if(sessionFactory != null) { sessionFactory.close(); } }
		}
	
}