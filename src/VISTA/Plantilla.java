package VISTA;

import javax.swing.JFrame;
import javax.swing.JPanel;
import CONTROLADOR.Controlador2;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JFormattedTextField;

public class Plantilla extends JFrame {

	public JPanel contentPane;
	public JButton comprar;
	public JButton vender;
	public JButton ranking;
	public JComboBox comprarPosiciones;
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
	public JPanel panel_3;
	public JTextField rankingLista;
	public JTextPane nombre;
	public JTextPane pais;
	public JTextPane media;
	public JPanel panel_4;
	public JTextPane nombree;
	public JTextPane paiis;
	public JTextPane puntoos;
	public JButton botonBuscarPartido;
	public JTextPane equipoo;
	public JTextPane equipo;
	public JComboBox elegirPlantilla;
	public JButton aceptarPlantilla;
	public JButton portero;
	public JButton central1_1;
	public JButton central2_1;
	public JButton lateralizquierdo_1;
	public JButton lateralderecho_1;
	public JButton medio1_1;
	public JButton medio2_1;
	public JButton medio3_1;
	public JButton extremoizquierdo_1;
	public JButton delantero_1;
	public JButton extremoderecho_1;
	public JButton medio1_2;
	public JButton medio2_2;
	public JButton medio3_2;
	public JButton medio4_2;
	public JButton delantero1_2;
	public JButton delantero2_2;
	public JButton central1_3;
	public JButton central2_3;
	public JButton central3_3;
	public JComboBox venderPosiciones;
	public JComboBox elegirEscudo;
	public JLabel escudo ;
	public JPanel panelPartidos;
	public JTextField partidos;

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
		buscar1.setBounds(244, 46, 87, 23);
		panel_2.add(buscar1);
		buscar1.setBackground(Color.LIGHT_GRAY);
		
		buscar2 = new JButton("BUSCAR");
		buscar2.setVisible(false);
		buscar2.setBackground(Color.LIGHT_GRAY);
		buscar2.setForeground(Color.BLACK);
		buscar2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		buscar2.setBounds(244, 46, 87, 23);
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
		
		comprarPosiciones = new JComboBox();
		comprarPosiciones.setBounds(75, 44, 159, 25);
		panel_2.add(comprarPosiciones);
		comprarPosiciones.setVisible(false);
		comprarPosiciones.setModel(new DefaultComboBoxModel(new String[] {"Elige Posicion", "Portero", "Central", "Lateral Izquierdo", "Lateral Derecho"}));
		comprarPosiciones.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		comprarPosiciones.setBackground(Color.WHITE);
		comprarPosiciones.setForeground(Color.BLACK);
		
		panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(128, 74, 275, 602);
		panel_2.add(panel);
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
		ampliar.setBackground(Color.WHITE);
		ampliar.setBounds(2, 95, 132, 186);
		panel_2.add(ampliar);
		
		aceptar = new JButton("");
		aceptar.setHorizontalAlignment(SwingConstants.LEFT);
		aceptar.setBounds(5, 574, 120, 27);
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
		nombre.setBounds(10, 312, 122, 27);
		panel_2.add(nombre);
		
		pais = new JTextPane();
		pais.setBackground(Color.WHITE);
		pais.setForeground(Color.BLACK);
		pais.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		pais.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pais.setBounds(10, 382, 122, 27);
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
		nombree.setBounds(10, 294, 87, 23);
		panel_2.add(nombree);
		
		paiis = new JTextPane();
		paiis.setVisible(false);
		paiis.setText("PAIS:");
		paiis.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		paiis.setBounds(10, 363, 56, 23);
		panel_2.add(paiis);
		
		puntoos = new JTextPane();
		puntoos.setVisible(false);
		puntoos.setText("PUNTOS:");
		puntoos.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		puntoos.setBounds(10, 504, 70, 23);
		panel_2.add(puntoos);
		
		equipoo = new JTextPane();
		equipoo.setVisible(false);
		equipoo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		equipoo.setText("EQUIPO:");
		equipoo.setBounds(10, 433, 70, 23);
		panel_2.add(equipoo);
		
		equipo = new JTextPane();
		equipo.setForeground(Color.BLACK);
		equipo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		equipo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		equipo.setBackground(Color.WHITE);
		equipo.setBounds(10, 453, 122, 27);
		panel_2.add(equipo);
		
		venderPosiciones = new JComboBox();
		venderPosiciones.setForeground(Color.BLACK);
		venderPosiciones.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		venderPosiciones.setModel(new DefaultComboBoxModel(new String[] {"Elige Posicion", "Portero", "Central", "Lateral Izquierdo", "Lateral Derecho"}));
		venderPosiciones.setVisible(false);
		venderPosiciones.setBounds(75, 44, 159, 25);
		panel_2.add(venderPosiciones);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "MI PLANTILLA", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(365, 11, 572, 684);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		elegirPlantilla = new JComboBox();
		elegirPlantilla.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		elegirPlantilla.setModel(new DefaultComboBoxModel(new String[] {"Elige Formacion", " 4 - 3 - 3", " 4 - 4 - 2", " 3 - 4 - 3", " 4 - 2 - 4"}));
		elegirPlantilla.setForeground(Color.BLACK);
		elegirPlantilla.setBackground(Color.WHITE);
		elegirPlantilla.setBounds(10, 20, 150, 25);
		panel_3.add(elegirPlantilla);
		
		aceptarPlantilla = new JButton("ACEPTAR");
		aceptarPlantilla.setBackground(Color.LIGHT_GRAY);
		aceptarPlantilla.setForeground(Color.BLACK);
		aceptarPlantilla.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		aceptarPlantilla.setBounds(170, 21, 95, 23);
		panel_3.add(aceptarPlantilla);
		
		portero = new JButton(" ");
		portero.setVisible(false);
		portero.setBorder(null);
		portero.setBackground(Color.LIGHT_GRAY);
		portero.setBounds(238, 530, 110, 130);
		panel_3.add(portero);
		
		central1_1 = new JButton(" ");
		central1_1.setVisible(false);
		central1_1.setBorder(null);
		central1_1.setBackground(Color.LIGHT_GRAY);
		central1_1.setBounds(165, 380, 110, 130);
		panel_3.add(central1_1);
		
		central2_1 = new JButton(" ");
		central2_1.setVisible(false);
		central2_1.setBorder(null);
		central2_1.setBackground(Color.LIGHT_GRAY);
		central2_1.setBounds(305, 380, 110, 130);
		panel_3.add(central2_1);
		
		lateralizquierdo_1 = new JButton(" ");
		lateralizquierdo_1.setVisible(false);
		lateralizquierdo_1.setBorder(null);
		lateralizquierdo_1.setBackground(Color.LIGHT_GRAY);
		lateralizquierdo_1.setBounds(15, 380, 110, 130);
		panel_3.add(lateralizquierdo_1);
		
		lateralderecho_1 = new JButton(" ");
		lateralderecho_1.setVisible(false);
		lateralderecho_1.setBorder(null);
		lateralderecho_1.setBackground(Color.LIGHT_GRAY);
		lateralderecho_1.setBounds(450, 380, 110, 130);
		panel_3.add(lateralderecho_1);
		
		medio1_1 = new JButton(" ");
		medio1_1.setVisible(false);
		medio1_1.setBorder(null);
		medio1_1.setBackground(Color.LIGHT_GRAY);
		medio1_1.setBounds(75, 225, 110, 130);
		panel_3.add(medio1_1);
		
		medio2_1 = new JButton(" ");
		medio2_1.setVisible(false);
		medio2_1.setBorder(null);
		medio2_1.setBackground(Color.LIGHT_GRAY);
		medio2_1.setBounds(234, 230, 110, 130);
		panel_3.add(medio2_1);
		
		medio3_1 = new JButton(" ");
		medio3_1.setVisible(false);
		medio3_1.setBorder(null);
		medio3_1.setBackground(Color.LIGHT_GRAY);
		medio3_1.setBounds(390, 225, 110, 130);
		panel_3.add(medio3_1);
		
		extremoizquierdo_1 = new JButton(" ");
		extremoizquierdo_1.setVisible(false);
		extremoizquierdo_1.setBorder(null);
		extremoizquierdo_1.setBackground(Color.LIGHT_GRAY);
		extremoizquierdo_1.setBounds(15, 75, 110, 130);
		panel_3.add(extremoizquierdo_1);
		
		delantero_1 = new JButton(" ");
		delantero_1.setVisible(false);
		delantero_1.setBorder(null);
		delantero_1.setBackground(Color.LIGHT_GRAY);
		delantero_1.setBounds(234, 65, 110, 130);
		panel_3.add(delantero_1);
		
		extremoderecho_1 = new JButton(" ");
		extremoderecho_1.setVisible(false);
		extremoderecho_1.setBorder(null);
		extremoderecho_1.setBackground(Color.LIGHT_GRAY);
		extremoderecho_1.setBounds(450, 75, 110, 130);
		panel_3.add(extremoderecho_1);
		
		medio1_2 = new JButton(" ");
		medio1_2.setVisible(false);
		medio1_2.setBorder(null);
		medio1_2.setBackground(Color.LIGHT_GRAY);
		medio1_2.setBounds(15, 225, 110, 130);
		panel_3.add(medio1_2);
		
		medio2_2 = new JButton(" ");
		medio2_2.setVisible(false);
		medio2_2.setBorder(null);
		medio2_2.setBackground(Color.LIGHT_GRAY);
		medio2_2.setBounds(155, 225, 110, 130);
		panel_3.add(medio2_2);
		
		medio3_2 = new JButton(" ");
		medio3_2.setVisible(false);
		medio3_2.setBorder(null);
		medio3_2.setBackground(Color.LIGHT_GRAY);
		medio3_2.setBounds(315, 225, 110, 130);
		panel_3.add(medio3_2);
		
		medio4_2 = new JButton(" ");
		medio4_2.setVisible(false);
		medio4_2.setBorder(null);
		medio4_2.setBackground(Color.LIGHT_GRAY);
		medio4_2.setBounds(450, 225, 110, 130);
		panel_3.add(medio4_2);
		
		delantero1_2 = new JButton(" ");
		delantero1_2.setVisible(false);
		delantero1_2.setBorder(null);
		delantero1_2.setBackground(Color.LIGHT_GRAY);
		delantero1_2.setBounds(149, 65, 110, 130);
		panel_3.add(delantero1_2);
		
		delantero2_2 = new JButton(" ");
		delantero2_2.setVisible(false);
		delantero2_2.setBorder(null);
		delantero2_2.setBackground(Color.LIGHT_GRAY);
		delantero2_2.setBounds(317, 65, 110, 130);
		panel_3.add(delantero2_2);
		
		central1_3 = new JButton("");
		central1_3.setVisible(false);
		central1_3.setBorder(null);
		central1_3.setBackground(Color.LIGHT_GRAY);
		central1_3.setBounds(75, 370, 110, 130);
		panel_3.add(central1_3);
		
		central2_3 = new JButton("");
		central2_3.setVisible(false);
		central2_3.setBorder(null);
		central2_3.setBackground(Color.LIGHT_GRAY);
		central2_3.setBounds(239, 380, 110, 130);
		panel_3.add(central2_3);
		
		central3_3 = new JButton("");
		central3_3.setVisible(false);
		central3_3.setBorder(null);
		central3_3.setBackground(Color.LIGHT_GRAY);
		central3_3.setBounds(398, 370, 110, 130);
		panel_3.add(central3_3);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " PERFIL", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(7, 11, 348, 684);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		ranking = new JButton("RANKING");
		ranking.setBounds(115, 210, 110, 26);
		panel_4.add(ranking);
		ranking.setForeground(Color.BLACK);
		ranking.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		ranking.setBackground(Color.LIGHT_GRAY);
		
		panelranking = new JPanel();
		panelranking.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "RANKING", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelranking.setBounds(10, 240, 328, 196);
		panel_4.add(panelranking);
		panelranking.setVisible(false);
		panelranking.setBackground(Color.WHITE);
		panelranking.setLayout(null);
		
		rankingLista = new JTextField();
		rankingLista.setBorder(null);
		rankingLista.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		rankingLista.setBackground(Color.LIGHT_GRAY);
		rankingLista.setEditable(false);
		rankingLista.setBounds(10, 15, 308, 170);
		panelranking.add(rankingLista);
		rankingLista.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 22, 115, 34);
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
		
		botonBuscarPartido = new JButton("BUSCAR PARTIDO");
		botonBuscarPartido.setForeground(Color.BLACK);
		botonBuscarPartido.setBackground(Color.LIGHT_GRAY);
		botonBuscarPartido.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		botonBuscarPartido.setBounds(88, 446, 172, 26);
		panel_4.add(botonBuscarPartido);
		
		escudo = new JLabel("");
		escudo.setBackground(Color.LIGHT_GRAY);
		escudo.setBounds(180, 60, 121, 129);
		panel_4.add(escudo);
		
		elegirEscudo = new JComboBox();
		elegirEscudo.setMaximumRowCount(25);
		elegirEscudo.setForeground(Color.BLACK);
		elegirEscudo.setBackground(Color.WHITE);
		elegirEscudo.setModel(new DefaultComboBoxModel(new String[] {"Elige Escudo", "Albacete (ESP)", "Napoles (ITA)", "Everton (ING)", "Barcelona (ESP)", "Leipzig (ALE)", "Juventus (ITA)", "PSG (FRA)", "M. City (ING)", "Ajax (HOL)", "B. de Munich (ALE)", "Inter de Milan (ITA)", "Spt. de Lisboa (POR)", "M. United (ING)", "Sevilla (ESP)", "M\u00F3naco (FRA)", "B. Dortmund (ALE)", "Benfica (POR)", "Arsenal (ING)", "PSV (HOL)", "Milan (ITA)", "Borussia M. (ALE)", "Atl. de Madrid (ESP)", "Tottenham (ING)", "Porto (POR)"}));
		elegirEscudo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		elegirEscudo.setBounds(152, 25, 177, 28);
		panel_4.add(elegirEscudo);
		
		panelPartidos = new JPanel();
		panelPartidos.setVisible(false);
		panelPartidos.setBorder(new TitledBorder(null, "PARTIDOS ONLINE", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelPartidos.setBackground(Color.WHITE);
		panelPartidos.setBounds(10, 475, 328, 196);
		panel_4.add(panelPartidos);
		panelPartidos.setLayout(null);
		
		partidos = new JTextField();
		partidos.setBorder(null);
		partidos.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		partidos.setEditable(false);
		partidos.setColumns(10);
		partidos.setBackground(Color.LIGHT_GRAY);
		partidos.setBounds(10, 15, 308, 170);
		panelPartidos.add(partidos);
			
	}
}