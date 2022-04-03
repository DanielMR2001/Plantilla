package VISTA;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import CONTROLADOR.Controlador1;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;

public class Login extends JFrame {

	public JPanel contentPane;
	public JTextField usuarioInicioSesion;
	public JPanel panel;
	public JPanel loguear;
	public JTextPane txtpnContrasea;
	public JTextPane txtpnUsuario;
	public JButton iniciarSesion;
	public JButton registrar;
	public JTextPane corregir;
	public JButton aceptar1;
	public JPanel registro;
	public JButton aceptar2;
	public JTextField nombreRegistro;
	public JTextField usuarioRegistro;
	public JTextField contrasenaRegistro;
	public JTextField emailRegistro;
	public JTextField contrasenaInicioSesion;
	public JTextPane corregir2;
	public JButton sonido;
	public JButton silencio;
	public JTextPane validar;

	public static void main(String[] args) {
		Login login = new Login();
		centreWindow1(login);
		login.setVisible(true);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		@SuppressWarnings("unused")
		Controlador1 controlador=new Controlador1(login);			
	}

	public Login() {
		setResizable(false);
		this.setTitle("   - - - FIFA 2022 - - - ");			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 439);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 576, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		
		loguear = new JPanel();
		loguear.setVisible(false);
		loguear.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		loguear.setBackground(Color.WHITE);
		loguear.setBounds(81, 52, 411, 110);
		panel.add(loguear);
		loguear.setLayout(null);
		
		txtpnContrasea = new JTextPane();
		txtpnContrasea.setForeground(Color.BLACK);
		txtpnContrasea.setEditable(false);
		txtpnContrasea.setBounds(83, 42, 96, 25);
		txtpnContrasea.setText("CONTRASE\u00D1A:");
		txtpnContrasea.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		loguear.add(txtpnContrasea);
		
		txtpnUsuario = new JTextPane();
		txtpnUsuario.setForeground(Color.BLACK);
		txtpnUsuario.setEditable(false);
		txtpnUsuario.setBounds(93, 11, 67, 25);
		loguear.add(txtpnUsuario);
		txtpnUsuario.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		txtpnUsuario.setText("USUARIO:");
		
		usuarioInicioSesion = new JTextField();
		usuarioInicioSesion.setForeground(Color.BLACK);
		usuarioInicioSesion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		usuarioInicioSesion.setBounds(189, 11, 201, 25);
		loguear.add(usuarioInicioSesion);
		usuarioInicioSesion.setColumns(10);
		
		corregir = new JTextPane();
		corregir.setForeground(Color.RED);
		corregir.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		corregir.setEditable(false);
		corregir.setBounds(68, 74, 255, 25);
		loguear.add(corregir);
		
		contrasenaInicioSesion = new JTextField();
		contrasenaInicioSesion.setForeground(Color.BLACK);
		contrasenaInicioSesion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		contrasenaInicioSesion.setColumns(10);
		contrasenaInicioSesion.setBounds(189, 42, 201, 25);
		loguear.add(contrasenaInicioSesion);
		
		iniciarSesion = new JButton("INICIAR SESI\u00D3N");
		iniciarSesion.setForeground(Color.BLACK);
		iniciarSesion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		iniciarSesion.setBackground(Color.WHITE);
		iniciarSesion.setBounds(205, 11, 162, 36);
		panel.add(iniciarSesion);
		
		registrar = new JButton("REGISTRARSE");
		registrar.setForeground(Color.BLACK);
		registrar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		registrar.setBackground(Color.WHITE);
		registrar.setBounds(205, 179, 162, 36);
		panel.add(registrar);
		
		registro = new JPanel();
		registro.setVisible(false);
		registro.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		registro.setBackground(Color.WHITE);
		registro.setBounds(81, 220, 411, 165);
		panel.add(registro);
		registro.setLayout(null);
		
		JTextPane nombre = new JTextPane();
		nombre.setEditable(false);
		nombre.setForeground(Color.BLACK);
		nombre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		nombre.setText("NOMBRE:");
		nombre.setBounds(20, 10, 63, 25);
		registro.add(nombre);
		
		JTextPane UsuariO = new JTextPane();
		UsuariO.setEditable(false);
		UsuariO.setForeground(Color.BLACK);
		UsuariO.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		UsuariO.setText("USUARIO:");
		UsuariO.setBounds(20, 40, 63, 22);
		registro.add(UsuariO);
		
		JTextPane email = new JTextPane();
		email.setEditable(false);
		email.setForeground(Color.BLACK);
		email.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		email.setText("EMAIL (...@...):");
		email.setBounds(3, 100, 103, 25);
		registro.add(email);
		
		JTextPane Contraseniaa = new JTextPane();
		Contraseniaa.setEditable(false);
		Contraseniaa.setForeground(Color.BLACK);
		Contraseniaa.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		Contraseniaa.setText("CONTRASE\u00D1A:");
		Contraseniaa.setBounds(10, 73, 87, 22);
		registro.add(Contraseniaa);
		
		nombreRegistro = new JTextField();
		nombreRegistro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		nombreRegistro.setForeground(Color.BLACK);
		nombreRegistro.setBounds(107, 10, 294, 25);
		registro.add(nombreRegistro);
		nombreRegistro.setColumns(10);
		
		usuarioRegistro = new JTextField();
		usuarioRegistro.setForeground(Color.BLACK);
		usuarioRegistro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		usuarioRegistro.setColumns(10);
		usuarioRegistro.setBounds(107, 40, 294, 25);
		registro.add(usuarioRegistro);
		
		contrasenaRegistro = new JTextField();
		contrasenaRegistro.setForeground(Color.BLACK);
		contrasenaRegistro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		contrasenaRegistro.setColumns(10);
		contrasenaRegistro.setBounds(107, 70, 294, 25);
		registro.add(contrasenaRegistro);
		
		emailRegistro = new JTextField();
		emailRegistro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		emailRegistro.setForeground(Color.BLACK);
		emailRegistro.setColumns(10);
		emailRegistro.setBounds(107, 100, 294, 25);
		registro.add(emailRegistro);
		
		corregir2 = new JTextPane();
		corregir2.setForeground(Color.RED);
		corregir2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		corregir2.setEditable(false);
		corregir2.setBounds(157, 136, 244, 25);
		registro.add(corregir2);
		
		validar = new JTextPane();
		validar.setText("  *Espere al ACEPTAR*");
		validar.setForeground(Color.BLACK);
		validar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		validar.setEditable(false);
		validar.setBounds(3, 136, 144, 25);
		registro.add(validar);
		
		aceptar1 = new JButton("ACEPTAR");
		aceptar1.setVisible(false);
		aceptar1.setBounds(231, 11, 112, 36);
		panel.add(aceptar1);
		aceptar1.setBackground(Color.WHITE);
		aceptar1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		aceptar1.setForeground(Color.BLACK);
		
		aceptar2 = new JButton("ACEPTAR");
		aceptar2.setVisible(false);
		aceptar2.setBackground(Color.WHITE);
		aceptar2.setForeground(Color.BLACK);
		aceptar2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		aceptar2.setBounds(231, 181, 112, 34);
		panel.add(aceptar2);
		
		sonido = new JButton("");
		sonido.setForeground(SystemColor.textHighlight);
		sonido.setVisible(true);
		sonido.setBackground(SystemColor.textHighlight);
		sonido.setBounds(509, 12, 57, 41);
		sonido.setIcon(new ImageIcon("sonido.png"));
		panel.add(sonido);
		
		silencio = new JButton("");
		silencio.setForeground(SystemColor.textHighlight);
		silencio.setVisible(false);
		silencio.setBackground(SystemColor.textHighlight);
		silencio.setBounds(509, 12, 57, 41);
		silencio.setIcon(new ImageIcon("silencio.png"));
		panel.add(silencio);
	}
	
	 public static void centreWindow1(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y - 18);
	}
}
