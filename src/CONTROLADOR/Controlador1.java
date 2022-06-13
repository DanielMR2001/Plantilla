package CONTROLADOR;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	Usuario u=null;
	
	public Controlador1(VISTA.Login login) {
		centreWindow1(login);
		this.login=login;
		this.login.iniciarSesion.addActionListener(this);
		this.login.volver.addActionListener(this);
		this.login.aceptar1.addActionListener(this);
		this.login.aceptar2.addActionListener(this);
		this.login.registrar.addActionListener(this);
		this.login.sonido.addActionListener(this);
		this.login.silencio.addActionListener(this);
		this.login.help.addActionListener(this);
		asociarImagen("help.png", login.help);
		asociarImagen("volver.png", login.volver);
		asociarImagen2("pensar.png", login.pensar);
		asociarImagen2("pensar2.png", login.pensar2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//configuracion del hibernate
			Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        sessionFactory = configuration.buildSessionFactory();
	        sessionFactory.getCurrentSession();
	        
	        //musica de fondo con opcion de que empiece o pare
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
		
			//funcionalidad cuando se pulse el boton Aceptar para el iniciar sesion
			if(e.getSource()==login.aceptar1) {
				String usuario=(String) login.usuarioInicioSesion.getText();
				String contrasena=login.contrasenaInicioSesion.getText();
				Boolean contrasenaBoolean=contrasena.isEmpty();			

				//comprobar que se hace bien el inicio de sesion
				if((usuario.equals(""))||(contrasenaBoolean==true)) {
					login.corregir.setText("");
					login.usuarioInicioSesion.setText("");
					login.contrasenaInicioSesion.setText("");
					login.corregir.setText("       *Rellene Todos Los Campos*");	
				}else {
					//sacar los datos de los usuarios registrados para comprobar el inicio de sesion
					u=modelo.iniciarSesion(sessionFactory, usuario);					
					String usuariousuarioBBDD=u.getUsuario();
					String contrasenaUsuarioBBDD=u.getContrasena();
					if((u.getUsuario()==null)) {
						JOptionPane.showMessageDialog(null, "USUARIO Y/O CONTRASEÑA INCORRECTO","INICIAR SESION", JOptionPane.ERROR_MESSAGE);
					}else if(usuario.equals(usuariousuarioBBDD)&&contrasena.equals(contrasenaUsuarioBBDD)){	
						JOptionPane.showMessageDialog(null, "INICIO DE SESIÓN CONFIRMADO\nBIENVENIDO "+usuariousuarioBBDD,"INICIAR SESION", JOptionPane.INFORMATION_MESSAGE);
						login.setVisible(false); 
						plantilla.setVisible(true);
						plantilla.setTitle("   - - - FIFA INTERNATIONAL SOCCER 2022 ("+usuariousuarioBBDD+") - - - ");			
						Controlador2 c2=new Controlador2(plantilla);
					}else{	
						JOptionPane.showMessageDialog(null, "USUARIO Y/O CONTRASEÑA INCORRECTO","INICIAR SESION", JOptionPane.ERROR_MESSAGE);
						login.usuarioInicioSesion.setText("");			
						login.contrasenaInicioSesion.setText("");
					}					
				}
			}

			//funcionalidad cuando se pulse el boton de registrarse
			if(e.getSource()==login.registrar) {
				login.corregir.setText(""); login.usuarioInicioSesion.setText(""); login.contrasenaInicioSesion.setText("");
				login.loguear.setVisible(false); login.registro.setVisible(true); login.iniciarSesion.setVisible(true); login.aceptar1.setVisible(false); login.registrar.setVisible(false); login.aceptar2.setVisible(true);
			}
		
			//funcionalidad cuando se pulse el boton de Aceptar para registrarse
			if(e.getSource()==login.aceptar2) {
				String nombre=login.nombreRegistro.getText();
				String contrasena=login.contrasenaRegistro.getText();
				String usuario=login.usuarioRegistro.getText();
				String email=login.emailRegistro.getText();				
				Boolean usuarioBoolean=usuario.isEmpty();
				Boolean contrasenaBoolean=contrasena.isEmpty();
				Boolean nombreBoolean=nombre.isEmpty();
				Boolean emailBoolean=email.isEmpty();
				Boolean emailarro=email.contains("@gmail");
				//comprobar que se han rellenado bien los campos de registrarse
				if((usuarioBoolean==true)||(contrasenaBoolean==true)||(nombreBoolean==true)||(emailBoolean==true)) {
					login.corregir2.setText(""); login.nombreRegistro.setText(""); login.contrasenaRegistro.setText(""); login.usuarioRegistro.setText(""); login.emailRegistro.setText("");
					login.corregir2.setText("   *Rellene Todos Los Campos*");	
				}else{
					if(emailarro==false) {
						login.corregir2.setText(""); login.nombreRegistro.setText(""); login.contrasenaRegistro.setText(""); login.usuarioRegistro.setText(""); login.emailRegistro.setText("");
						login.corregir2.setText(" *Email incorrecto (..@gmail..)*");	
					}else {
						login.corregir2.setText("");
						//insertar los nuevos usuarios en la BBDD
						modelo.insertarDatos(sessionFactory, nombre, usuario, contrasena, email);
						//mandar un mensaje de confirmacion al email del registro
						modelo.mandarMensaje(email, nombre, usuario);
						login.nombreRegistro.setText(""); login.usuarioRegistro.setText(""); login.contrasenaRegistro.setText(""); login.emailRegistro.setText(""); login.corregir2.setText("");
						JOptionPane.showMessageDialog(null, "REGISTRO CONFIRMADO\nNombre: "+nombre+"\nUsuario: "+usuario+"\nEmail: "+email,"REGISTRO", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}			
			
			//funcionalidad cuando se pulse el boton de Instrucciones
			if(e.getSource()==login.help) {
				login.setTitle("   - - - FIFA INTERNATIONAL SOCCER 2022 (INSTRUCCIONES) - - - ");
				login.help.setVisible(false); login.aceptar1.setVisible(false); login.aceptar2.setVisible(false); login.loguear.setVisible(false); login.registro.setVisible(false); login.registrar.setVisible(false); login.iniciarSesion.setVisible(false); login.volver.setVisible(true); login.normas.setVisible(true); login.pensar.setVisible(true); login.pensar2.setVisible(true);
				login.norma1.setText("1º Regístrate e inicia sesión para acceder a la App");
				login.norma2.setText("2º Al entrar a la siguiente ventana, regístrate en el ranking");
				login.norma3.setText("3º Compra/Vende jugadores en la tienda");
				login.norma4.setText("4º Elege la mejor plantilla para los jugadores comprados");
				login.norma5.setText("5º Para jugar partidos, debes registrarte antes en el Ranking");
				login.norma6.setText("6º +5000$ por victoria/-3000$ por derrota");
				login.norma7.setText("7º Puedes escoger el escudo de tu equipo para los partidos");
				login.norma8.setText("8º No podrás jugar partidos si tienes menos de 3000$");
				login.norma9.setText("9º Al vender un jugador, obtendrás el 60% de su precio de venta");
			}
			
			if(e.getSource()==login.volver) {
				login.help.setVisible(true); login.registrar.setVisible(true); login.iniciarSesion.setVisible(true); login.volver.setVisible(false); login.normas.setVisible(false); login.pensar.setVisible(false); login.pensar2.setVisible(false);			
				login.setTitle("   - - - FIFA INTERNATIONAL SOCCER 2022 (¿ ?) - - - ");
			}
			
		} catch (Exception e3) { e3.printStackTrace(); 
		} finally { if(sessionFactory != null) { sessionFactory.close(); } }
		
	}
	
	 public static void centreWindow1(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y - 18);
	}
	 
	//cambiar el fondo a un boton
	private void asociarImagen(String nombre, JButton button) {
		ImageIcon icon = new ImageIcon(nombre);
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH));
		button.setIcon(img);
	}
	
	//cambiar el fondo a un jlabel
	private void asociarImagen2(String nombre, JLabel label) {
		ImageIcon icon = new ImageIcon(nombre);
		ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
		label.setIcon(img);
	}
}