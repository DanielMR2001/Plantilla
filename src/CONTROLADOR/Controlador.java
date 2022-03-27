package CONTROLADOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import MODELO.Usuario;
import VISTA.Login;
import VISTA.Plantilla;

public class Controlador implements ActionListener{
	
	Plantilla plantilla=new Plantilla();
	Login login=new Login();
	
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SessionFactory sessionFactory = null;
		
		try {
	         Configuration configuration = new Configuration();
	         configuration.configure("hibernate.cfg.xml");
	         sessionFactory = configuration.buildSessionFactory();
	         sessionFactory.getCurrentSession();
				
		//FUNCIONALIDAD SI SE PULSA EL BOTÓN DE INICIAR SESIÓN
		if(e.getSource()==login.iniciarSesion) {
			login.nombree.setText("");
			login.usuarioo.setText("");
			login.contraseñaa.setText("");
			login.emaill.setText("");
			login.corregir2.setText("");
			login.loguear.setVisible(true);	
			login.registro.setVisible(false);
			login.iniciarSesion.setVisible(false);
			login.registrar.setVisible(true);
			login.aceptar1.setVisible(true);
			login.aceptar2.setVisible(false);
		}		
		
		//FUNCIONALIDAD SI SE PULSA EL BOTÓN DE ACEPTAR PARA INICIAR SESIÓN
		if(e.getSource()==login.aceptar1) {
			String usuario=login.usuario.getText();
			String contrasena=login.contrasena.getText();
			Boolean usuarioBoolean=usuario.isEmpty();
			Boolean contrasenaBoolean=contrasena.isEmpty();
			
			//comprobar que se han rellenado los campos de inicio sesión
			if((usuarioBoolean==true)||(contrasenaBoolean==true)) {
				login.corregir.setText("");
				login.corregir.setText("       *Rellene Todos Los Campos*");	
			}else{			
				
			}
		}
		
		//FUNCIONALIDAD SI SE PULSA EL BOTÓN DE REGISTRARSE
		if(e.getSource()==login.registrar) {
			login.corregir.setText("");
			login.usuario.setText("");
			login.contrasena.setText("");
			login.loguear.setVisible(false);	
			login.registro.setVisible(true);
			login.iniciarSesion.setVisible(true);
			login.aceptar1.setVisible(false);
			login.registrar.setVisible(false);
			login.aceptar2.setVisible(true);
		}
		
		//FUNCIONALIDAD SI SE PULSA EL BOTÓN DE ACEPTAR PARA REGISTRARSE
		if(e.getSource()==login.aceptar2) {
			String nombre=login.nombree.getText();
			String contrasena=login.contraseñaa.getText();
			String usuario=login.usuarioo.getText();
			String email=login.emaill.getText();
			
			Boolean usuarioBoolean=usuario.isEmpty();
			Boolean contrasenaBoolean=contrasena.isEmpty();
			Boolean nombreBoolean=nombre.isEmpty();
			Boolean emailBoolean=email.contains("@");

			//comprobar que se han rellenado los campos de registrarse
			if((usuarioBoolean==true)||(contrasenaBoolean==true)||(nombreBoolean==true)||(emailBoolean==false)) {
				login.corregir2.setText("");
				login.corregir2.setText("       *Rellene Todos Los Campos*");	
			}else{
				
				String nombreUsuario=login.nombree.getText();
				String usuarioUsuario=login.usuarioo.getText();
				String contraseñaUsuario=login.contraseñaa.getText();
				String emailUsuario=login.emaill.getText();
				
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
				
				login.nombree.setText("");
				login.usuarioo.setText("");
				login.contraseñaa.setText("");
				login.emaill.setText("");
				login.corregir2.setText("");
			}

		}	
	} catch (Exception e3) { e3.printStackTrace(); throw e3;
	} finally { if(sessionFactory != null) { sessionFactory.close(); } }
}
}
