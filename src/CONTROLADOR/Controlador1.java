package CONTROLADOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import MODELO.Modelo;
import MODELO.Usuario;
import VISTA.Login;
import VISTA.Plantilla;

public class Controlador1 implements ActionListener{
	
	Login login=new Login();
	Modelo modelo=new Modelo();
	Plantilla plantilla=new Plantilla();
	SessionFactory sessionFactory = null;
	Clip sonido=null;
	
	public Controlador1(VISTA.Login login) {
		this.login=login;
		this.login.iniciarSesion.addActionListener(this);
		this.login.aceptar1.addActionListener(this);
		this.login.aceptar2.addActionListener(this);
		this.login.registrar.addActionListener(this);
		this.login.sonido.addActionListener(this);
		this.login.silencio.addActionListener(this);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * PANTALLA LOGIN
		 */
		try {
			//configuracion del hibernate
			Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        sessionFactory = configuration.buildSessionFactory();
	        sessionFactory.getCurrentSession();
			
	        //musica de fondo con opcion de que empiece o que pare
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
			
			//funcionalidad cuando se pulse el boton de iniciar sesion
			if(e.getSource()==login.iniciarSesion) {
				login.nombreRegistro.setText(""); login.usuarioRegistro.setText(""); login.contrasenaRegistro.setText(""); login.emailRegistro.setText(""); login.corregir2.setText("");
				login.loguear.setVisible(true);	login.registro.setVisible(false); login.iniciarSesion.setVisible(false); login.registrar.setVisible(true); login.aceptar1.setVisible(true); login.aceptar2.setVisible(false);
			}		
		
			//funcionalidad cuando se pulse el boton para iniciar sesion
			if(e.getSource()==login.aceptar1) {
				String usuario=login.usuarioInicioSesion.getText();
				String contrasena=login.contrasenaInicioSesion.getText();
				Boolean usuarioBoolean=usuario.isEmpty();
				Boolean contrasenaBoolean=contrasena.isEmpty();			

				//sacar los datos de los usuarios registrados para comprobar el inicio de sesion
				Usuario u=modelo.iniciarSesion(sessionFactory, usuario);
				
				String usuariousuarioBBDD=u.getUsuario();
				String contrasenaUsuarioBBDD=u.getContrasena();
				
				//comprobar que se hace bien el inicio de sesion
				if((usuarioBoolean==true)||(contrasenaBoolean==true)) {
					login.corregir.setText("");
					login.corregir.setText("       *Rellene Todos Los Campos*");	
				}if(usuario.equalsIgnoreCase(usuariousuarioBBDD)&&(contrasena.equalsIgnoreCase(contrasenaUsuarioBBDD))){										
					JOptionPane.showMessageDialog(null, "INICIO DE SESIÓN CONFIRMADO\nBIENVENIDO "+usuariousuarioBBDD,"INICIAR SESION", JOptionPane.INFORMATION_MESSAGE);
					login.setVisible(false); 
					plantilla.setVisible(true);
					Controlador2 c2=new Controlador2(plantilla);
				}else{										
					JOptionPane.showMessageDialog(null, "USUARIO Y/O CONTRASEÑA INCORRECTO","INICIAR SESION", JOptionPane.ERROR_MESSAGE);
					login.usuarioInicioSesion.setText("");
					login.contrasenaInicioSesion.setText("");
				}
			}
		
			//funcionalidad cuando se pulse el boton de registrarse
			if(e.getSource()==login.registrar) {
				login.corregir.setText(""); login.usuarioInicioSesion.setText(""); login.contrasenaInicioSesion.setText("");
				login.loguear.setVisible(false); login.registro.setVisible(true); login.iniciarSesion.setVisible(true); login.aceptar1.setVisible(false); login.registrar.setVisible(false); login.aceptar2.setVisible(true);
			}
		
			//funcionalidad cuando se pulse el boton de aceptar para registrarse
			if(e.getSource()==login.aceptar2) {
				String nombre=login.nombreRegistro.getText();
				String contrasena=login.contrasenaRegistro.getText();
				String usuario=login.usuarioRegistro.getText();
				String email=login.emailRegistro.getText();
				
				Boolean usuarioBoolean=usuario.isEmpty();
				Boolean contrasenaBoolean=contrasena.isEmpty();
				Boolean nombreBoolean=nombre.isEmpty();
				Boolean emailBoolean=email.contains("@");

				//comprobar que se han rellenado bien los campos de registrarse
				if((usuarioBoolean==true)||(contrasenaBoolean==true)||(nombreBoolean==true)||(emailBoolean==false)) {
					login.corregir2.setText("");
					login.corregir2.setText("   *Rellene Todos Los Campos*");	
				}else{	
					login.corregir2.setText("");
					//insertar los nuevos usuarios en la BBDD
					modelo.insertarDatos(sessionFactory, nombre, usuario, contrasena, email);
							
					//mandar un mensaje de confirmacion al email del registro
					modelo.mandarMensaje(email, nombre, usuario);
						
					login.nombreRegistro.setText(""); login.usuarioRegistro.setText(""); login.contrasenaRegistro.setText(""); login.emailRegistro.setText(""); login.corregir2.setText("");
					JOptionPane.showMessageDialog(null, "REFGISTRO CONFIRMADO\nUsuario: "+usuario+"\nMensaje pa: "+email,"REGISTRO", JOptionPane.INFORMATION_MESSAGE);
				}
			}			

		} catch (Exception e3) { e3.printStackTrace(); 
		} finally { if(sessionFactory != null) { sessionFactory.close(); } }
		
	}

}