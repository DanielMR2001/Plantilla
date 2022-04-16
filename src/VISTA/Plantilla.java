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
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;

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
	public JButton carta1;
	public JButton carta4;
	public JButton carta7;
	public JButton carta10;
	public JButton carta13;
	public JButton carta2;
	public JButton carta3;
	public JButton carta5;
	public JButton carta6;
	public JButton carta8;
	public JButton carta9;
	public JButton carta12;
	public JButton carta11;
	public JButton carta14;
	public JButton carta15;
	public JButton aceptar;
	public JTextPane textPane_1;
	public JTextPane dinero;
	public JLabel ampliar;
	public JPanel jugadores;
	public JComboBox posicionJugadores;
	public JButton buscarJugadores;
	public JButton jugador1;
	public JButton jugador2;
	public JButton jugador3;
	public JButton jugador4;
	public JButton jugador5;
	public JPanel panel_3;
	public JTextField txtA;
	public JTextPane nombre;
	public JTextPane posicion;
	public JTextPane pais;
	public JTextPane media;
	public JPanel panel_4;
	public JTextPane nombree;
	public JTextPane posicioon;
	public JTextPane paiis;
	public JTextPane puntoos;
	public JTextPane usuario;

	public static void main(String[] args) {
		Plantilla plantilla = new Plantilla();
		plantilla.setVisible(true);
		plantilla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		@SuppressWarnings("unused")
		Controlador2 controlador2=new Controlador2(plantilla);			
	}

	public Plantilla() {
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setTitle("   - - - FIFA INTERNATIONAL SOCCER 2022 - - - ");			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1385, 740);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "TIENDA", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(945, 11, 413, 684);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		buscar1 = new JButton("BUSCAR");
		buscar1.setVisible(false);
		buscar1.setForeground(Color.BLACK);
		buscar1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		buscar1.setBounds(240, 46, 87, 23);
		panel_2.add(buscar1);
		buscar1.setBackground(Color.LIGHT_GRAY);
		
		buscar2 = new JButton("BUSCAR");
		buscar2.setVisible(false);
		buscar2.setBackground(Color.WHITE);
		buscar2.setForeground(Color.BLACK);
		buscar2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		buscar2.setBounds(240, 46, 87, 23);
		panel_2.add(buscar2);
		
		comprar = new JButton("COMPRAR");
		comprar.setBounds(10, 14, 141, 26);
		panel_2.add(comprar);
		comprar.setForeground(Color.BLACK);
		comprar.setBackground(Color.LIGHT_GRAY);
		comprar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		
		vender = new JButton("VENDER");
		vender.setBounds(262, 14, 141, 26);
		panel_2.add(vender);
		vender.setForeground(Color.BLACK);
		vender.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		vender.setBackground(Color.LIGHT_GRAY);
		
		posiciones = new JComboBox();
		posiciones.setBounds(71, 45, 159, 25);
		panel_2.add(posiciones);
		posiciones.setVisible(false);
		posiciones.setModel(new DefaultComboBoxModel(new String[] {"Elige Posicion", "Portero", "Central", "Lateral Izquierdo", "Lateral Derecho"}));
		posiciones.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		posiciones.setBackground(Color.WHITE);
		posiciones.setForeground(Color.BLACK);
		
		panel = new JPanel();
		panel.setBounds(128, 74, 275, 602);
		panel_2.add(panel);
		panel.setVisible(false);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(null);
		
		carta1 = new JButton("");
		carta1.setBounds(9, 15, 83, 110);
		panel.add(carta1);
		carta1.setBorder(null);
		carta1.setBackground(Color.WHITE);
		
		carta4 = new JButton("");
		carta4.setBorder(null);
		carta4.setBackground(Color.WHITE);
		carta4.setBounds(9, 132, 83, 110);
		panel.add(carta4);
		
		carta7 = new JButton("");
		carta7.setBorder(null);
		carta7.setBackground(Color.WHITE);
		carta7.setBounds(9, 249, 83, 110);
		panel.add(carta7);
		
		carta10 = new JButton("");
		carta10.setBorder(null);
		carta10.setBackground(Color.WHITE);
		carta10.setBounds(9, 368, 83, 110);
		panel.add(carta10);
		
		carta13 = new JButton("");
		carta13.setBorder(null);
		carta13.setBackground(Color.WHITE);
		carta13.setBounds(9, 486, 83, 110);
		panel.add(carta13);
		
		carta2 = new JButton("");
		carta2.setBorder(null);
		carta2.setBackground(Color.WHITE);
		carta2.setBounds(96, 15, 83, 110);
		panel.add(carta2);
		
		carta3 = new JButton("");
		carta3.setBorder(null);
		carta3.setBackground(Color.WHITE);
		carta3.setBounds(183, 15, 82, 110);
		panel.add(carta3);
		
		carta5 = new JButton("");
		carta5.setBorder(null);
		carta5.setBackground(Color.WHITE);
		carta5.setBounds(96, 132, 83, 110);
		panel.add(carta5);
		
		carta6 = new JButton("");
		carta6.setBorder(null);
		carta6.setBackground(Color.WHITE);
		carta6.setBounds(183, 132, 83, 110);
		panel.add(carta6);
		
		carta8 = new JButton("");
		carta8.setBorder(null);
		carta8.setBackground(Color.WHITE);
		carta8.setBounds(96, 249, 83, 110);
		panel.add(carta8);
		
		carta9 = new JButton("");
		carta9.setBorder(null);
		carta9.setBackground(Color.WHITE);
		carta9.setBounds(183, 249, 83, 110);
		panel.add(carta9);
		
		carta12 = new JButton("");
		carta12.setBorder(null);
		carta12.setBackground(Color.WHITE);
		carta12.setBounds(183, 368, 83, 110);
		panel.add(carta12);
		
		carta11 = new JButton("");
		carta11.setBorder(null);
		carta11.setBackground(Color.WHITE);
		carta11.setBounds(96, 368, 83, 110);
		panel.add(carta11);
		
		carta14 = new JButton("");
		carta14.setBorder(null);
		carta14.setBackground(Color.WHITE);
		carta14.setBounds(96, 486, 83, 110);
		panel.add(carta14);
		
		carta15 = new JButton("");
		carta15.setBorder(null);
		carta15.setBackground(Color.WHITE);
		carta15.setBounds(183, 486, 83, 110);
		panel.add(carta15);
		
		ampliar = new JLabel("");
		ampliar.setBounds(2, 104, 132, 186);
		panel_2.add(ampliar);
		
		aceptar = new JButton("");
		aceptar.setHorizontalAlignment(SwingConstants.LEFT);
		aceptar.setBounds(10, 568, 110, 27);
		panel_2.add(aceptar);
		aceptar.setVisible(false);
		aceptar.setForeground(Color.BLACK);
		aceptar.setBackground(Color.LIGHT_GRAY);
		aceptar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 19));
		
		nombre = new JTextPane();
		nombre.setBackground(Color.WHITE);
		nombre.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		nombre.setForeground(Color.BLACK);
		nombre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		nombre.setBounds(10, 320, 122, 27);
		panel_2.add(nombre);
		
		posicion = new JTextPane();
		posicion.setBackground(Color.WHITE);
		posicion.setForeground(Color.BLACK);
		posicion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		posicion.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		posicion.setBounds(10, 386, 122, 27);
		panel_2.add(posicion);
		
		pais = new JTextPane();
		pais.setBackground(Color.WHITE);
		pais.setForeground(Color.BLACK);
		pais.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		pais.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pais.setBounds(10, 456, 122, 27);
		panel_2.add(pais);
		
		media = new JTextPane();
		media.setBackground(Color.WHITE);
		media.setForeground(Color.BLACK);
		media.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		media.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		media.setBounds(10, 523, 122, 27);
		panel_2.add(media);
		
		nombree = new JTextPane();
		nombree.setVisible(false);
		nombree.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		nombree.setText("NOMBRE:");
		nombree.setBounds(10, 294, 87, 26);
		panel_2.add(nombree);
		
		posicioon = new JTextPane();
		posicioon.setVisible(false);
		posicioon.setText("POSICION:");
		posicioon.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		posicioon.setBounds(10, 360, 87, 26);
		panel_2.add(posicioon);
		
		paiis = new JTextPane();
		paiis.setVisible(false);
		paiis.setText("PAIS:");
		paiis.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		paiis.setBounds(10, 430, 56, 26);
		panel_2.add(paiis);
		
		puntoos = new JTextPane();
		puntoos.setVisible(false);
		puntoos.setText("PUNTOS:");
		puntoos.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		puntoos.setBounds(10, 496, 70, 26);
		panel_2.add(puntoos);
		
		jugadores = new JPanel();
		jugadores.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "JUGADORES", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jugadores.setBackground(Color.WHITE);
		jugadores.setBounds(365, 515, 572, 180);
		contentPane.add(jugadores);
		jugadores.setLayout(null);
		
		jugador1 = new JButton("");
		jugador1.setBorder(null);
		jugador1.setBackground(Color.WHITE);
		jugador1.setBounds(10, 50, 101, 122);
		jugadores.add(jugador1);
		
		jugador2 = new JButton("");
		jugador2.setBorder(null);
		jugador2.setBackground(Color.WHITE);
		jugador2.setBounds(127, 50, 101, 122);
		jugadores.add(jugador2);
		
		jugador3 = new JButton("");
		jugador3.setBorder(null);
		jugador3.setBackground(Color.WHITE);
		jugador3.setBounds(239, 50, 101, 122);
		jugadores.add(jugador3);
		
		jugador4 = new JButton("");
		jugador4.setBorder(null);
		jugador4.setBackground(Color.WHITE);
		jugador4.setBounds(350, 50, 101, 122);
		jugadores.add(jugador4);
		
		jugador5 = new JButton("");
		jugador5.setBorder(null);
		jugador5.setBackground(Color.WHITE);
		jugador5.setBounds(461, 50, 101, 122);
		jugadores.add(jugador5);
		
		posicionJugadores = new JComboBox();
		posicionJugadores.setBounds(175, 17, 159, 25);
		jugadores.add(posicionJugadores);
		posicionJugadores.setBackground(Color.WHITE);
		posicionJugadores.setForeground(Color.BLACK);
		posicionJugadores.setModel(new DefaultComboBoxModel(new String[] {"Elige Posicion", "Portero", "Central", "Lateral Izquierdo", "Lateral Derecho"}));
		posicionJugadores.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		
		buscarJugadores = new JButton("BUSCAR");
		buscarJugadores.setBounds(342, 19, 92, 23);
		jugadores.add(buscarJugadores);
		buscarJugadores.setForeground(Color.BLACK);
		buscarJugadores.setBackground(Color.LIGHT_GRAY);
		buscarJugadores.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 16));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "MI PLANTILLA", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(365, 11, 572, 497);
		contentPane.add(panel_3);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " PERFIL", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(8, 11, 348, 684);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		ranking = new JButton("RANKING");
		ranking.setBounds(25, 443, 110, 26);
		panel_4.add(ranking);
		ranking.setForeground(Color.BLACK);
		ranking.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		ranking.setBackground(Color.LIGHT_GRAY);
		
		panelranking = new JPanel();
		panelranking.setBounds(10, 475, 328, 200);
		panel_4.add(panelranking);
		panelranking.setVisible(false);
		panelranking.setBackground(Color.WHITE);
		panelranking.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "RANKING", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelranking.setLayout(null);
		
		txtA = new JTextField();
		txtA.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		txtA.setBackground(Color.WHITE);
		txtA.setEditable(false);
		txtA.setBounds(10, 15, 308, 174);
		panelranking.add(txtA);
		txtA.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 15, 115, 34);
		panel_4.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel_1.setLayout(null);
		
		dinero = new JTextPane();
		dinero.setEditable(false);
		dinero.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 22));
		dinero.setText("500000");
		dinero.setForeground(Color.BLACK);
		dinero.setBounds(5, 3, 85, 26);
		panel_1.add(dinero);
		
		textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBounds(86, 2, 25, 25);
		panel_1.add(textPane_1);
		textPane_1.setBackground(Color.WHITE);
		textPane_1.setForeground(Color.BLACK);
		textPane_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 23));
		textPane_1.setText("\u20AC");
		
		JButton btnNewButton = new JButton("BUSCAR PARTIDO");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		btnNewButton.setBounds(145, 443, 172, 26);
		panel_4.add(btnNewButton);
		
		usuario = new JTextPane();
		usuario.setBackground(Color.WHITE);
		usuario.setForeground(Color.BLACK);
		usuario.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		usuario.setBounds(162, 15, 165, 34);
		panel_4.add(usuario);
		
		

	}
}