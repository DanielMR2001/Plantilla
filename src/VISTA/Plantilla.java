package VISTA;

import javax.swing.JFrame;
import javax.swing.JPanel;
import CONTROLADOR.Controlador2;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Plantilla extends JFrame {

	public JPanel contentPane;
	public JButton comprar;
	public JButton vender;
	public JButton ranking;
	public JComboBox posiciones;
	public JPanel panel;
	public JPanel panelranking;
	public JButton buscar1;
	public JButton buscar2;

	public static void main(String[] args) {
		Plantilla plantilla = new Plantilla();
		plantilla.setVisible(true);
		plantilla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		@SuppressWarnings("unused")
		Controlador2 controlador2=new Controlador2(plantilla);	
		
	}

	public Plantilla() {
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setTitle("   - - - FIFA 2022 - - - ");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1385, 740);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setVisible(false);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setBounds(989, 103, 367, 587);
		contentPane.add(panel);
		panel.setLayout(null);
		
		comprar = new JButton("COMPRAR");
		comprar.setForeground(Color.BLACK);
		comprar.setBackground(Color.WHITE);
		comprar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 22));
		comprar.setBounds(990, 15, 125, 30);
		contentPane.add(comprar);
		
		vender = new JButton("VENDER");
		vender.setForeground(Color.BLACK);
		vender.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 22));
		vender.setBackground(Color.WHITE);
		vender.setBounds(1125, 15, 105, 30);
		contentPane.add(vender);
		
		ranking = new JButton("RANKING");
		ranking.setForeground(Color.BLACK);
		ranking.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		ranking.setBackground(Color.WHITE);
		ranking.setBounds(1240, 15, 115, 30);
		contentPane.add(ranking);
		
		panelranking = new JPanel();
		panelranking.setVisible(false);
		panelranking.setBackground(Color.WHITE);
		panelranking.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panelranking.setBounds(989, 59, 367, 631);
		contentPane.add(panelranking);
		panelranking.setLayout(null);
		
		posiciones = new JComboBox();
		posiciones.setVisible(false);
		posiciones.setBounds(1045, 62, 159, 26);
		posiciones.setModel(new DefaultComboBoxModel(new String[] {"Elige Posicion", "Portero", "Central", "Lateral Izquierdo", "Lateral Derecho"}));
		posiciones.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		posiciones.setBackground(Color.WHITE);
		posiciones.setForeground(Color.BLACK);
		contentPane.add(posiciones);
		
		buscar1 = new JButton("BUSCAR");
		buscar1.setVisible(false);
		buscar1.setForeground(Color.BLACK);
		buscar1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		buscar1.setBounds(1210, 62, 94, 26);
		contentPane.add(buscar1);
		buscar1.setBackground(Color.WHITE);
		
		buscar2 = new JButton("BUSCAR");
		buscar2.setVisible(false);
		buscar2.setBackground(Color.WHITE);
		buscar2.setForeground(Color.BLACK);
		buscar2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		buscar2.setBounds(1210, 62, 94, 26);
		contentPane.add(buscar2);

	}

}