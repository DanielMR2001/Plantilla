package VISTA;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import CONTROLADOR.Controlador;
import java.awt.Color;
import javax.swing.JLabel;

public class Plantilla extends JFrame {

	public JPanel contentPane;

	public static void main(String[] args) {
		Plantilla frame = new Plantilla();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		@SuppressWarnings("unused")
		Controlador controlador=new Controlador(frame);	
		frame.setExtendedState(MAXIMIZED_BOTH);
	}

	public Plantilla() {
		setBackground(Color.WHITE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setTitle("   - - - FIFA 2022 - - - ");			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 745);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
	}
}
