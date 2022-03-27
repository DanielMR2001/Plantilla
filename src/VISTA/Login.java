package VISTA;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import CONTROLADOR.Controlador;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	public JPanel contentPane;
	public JTextField usuario;
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
	public JTextField nombree;
	public JTextField contraseñaa;
	public JTextField usuarioo;
	public JTextField emaill;
	public JTextField contrasena;
	public JTextPane corregir2;

	public static void main(String[] args) {
		Login login = new Login();
		centreWindow(login);
		login.setVisible(true);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		@SuppressWarnings("unused")
		Controlador controlador=new Controlador(login);			
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
		panel.setBackground(Color.LIGHT_GRAY);
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
		
		usuario = new JTextField();
		usuario.setForeground(Color.BLACK);
		usuario.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		usuario.setBounds(189, 11, 201, 25);
		loguear.add(usuario);
		usuario.setColumns(10);
		
		corregir = new JTextPane();
		corregir.setForeground(Color.RED);
		corregir.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		corregir.setEditable(false);
		corregir.setBounds(68, 74, 255, 25);
		loguear.add(corregir);
		
		contrasena = new JTextField();
		contrasena.setForeground(Color.BLACK);
		contrasena.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		contrasena.setColumns(10);
		contrasena.setBounds(189, 42, 201, 25);
		loguear.add(contrasena);
		
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
		
		nombree = new JTextField();
		nombree.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		nombree.setForeground(Color.BLACK);
		nombree.setBounds(107, 10, 294, 25);
		registro.add(nombree);
		nombree.setColumns(10);
		
		contraseñaa = new JTextField();
		contraseñaa.setForeground(Color.BLACK);
		contraseñaa.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		contraseñaa.setColumns(10);
		contraseñaa.setBounds(107, 40, 294, 25);
		registro.add(contraseñaa);
		
		usuarioo = new JTextField();
		usuarioo.setForeground(Color.BLACK);
		usuarioo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		usuarioo.setColumns(10);
		usuarioo.setBounds(107, 70, 294, 25);
		registro.add(usuarioo);
		
		emaill = new JTextField();
		emaill.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		emaill.setForeground(Color.BLACK);
		emaill.setColumns(10);
		emaill.setBounds(107, 100, 294, 25);
		registro.add(emaill);
		
		corregir2 = new JTextPane();
		corregir2.setForeground(Color.RED);
		corregir2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		corregir2.setEditable(false);
		corregir2.setBounds(57, 129, 253, 25);
		registro.add(corregir2);
		
		aceptar1 = new JButton("ACEPTAR");
		aceptar1.setVisible(false);
		aceptar1.setBounds(231, 11, 112, 36);
		panel.add(aceptar1);
		aceptar1.setBackground(Color.WHITE);
		aceptar1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		aceptar1.setForeground(Color.BLACK);
		
		aceptar2 = new JButton("ACEPTAR");
		aceptar2.setBackground(Color.WHITE);
		aceptar2.setForeground(Color.BLACK);
		aceptar2.setVisible(false);
		aceptar2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		aceptar2.setBounds(231, 181, 112, 34);
		panel.add(aceptar2);
	}
	
	 public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y - 18);
	}
}
