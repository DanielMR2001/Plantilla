package VISTA;

import javax.swing.JFrame;
import javax.swing.JPanel;
import CONTROLADOR.Controlador2;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;

public class Plantilla extends JFrame {

	public JPanel contentPane;
	public JButton comprar;
	public JButton vender;
	public JComboBox comprarPosiciones;
	public JPanel panel;
	public JPanel panelranking;
	public JButton buscar1;
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
	public JTextPane nombre;
	public JTextPane pais;
	public JTextPane posicion;
	public JPanel panel_4;
	public JTextPane nombree;
	public JTextPane paiis;
	public JTextPane posicioon;
	public JTextPane equipoo;
	public JTextPane equipo;
	public JComboBox elegirPlantilla;
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
	public JButton central3_3;
	public JComboBox elegirEscudo;
	public JLabel escudo ;
	public JPanel panelPartidos;
	public JComboBox porterosComboBox;
	public JComboBox centralesDComboBox;
	public JTextField puntos;
	public JButton recarga;
	public JButton vs;
	public JComboBox centralesIComboBox;
	public JComboBox lateralDComboBox;
	public JComboBox lateralIComboBox;
	public JTextPane puntoos;
	public JTextPane media;
	public JScrollPane scrollPane;
	public JButton recargaPuntos;
	public JComboBox venderJugadores;
	public JLabel ampliarvender;
	public JButton cancelarvender;
	public JButton aceptarvender;

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
		comprarPosiciones.setModel(new DefaultComboBoxModel(new String[] {"Elige Posicion", "Porteros", "Defensas", "Laterales I.", "Laterales D."}));
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
		aceptar.setBounds(10, 642, 110, 27);
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
		
		posicion = new JTextPane();
		posicion.setBackground(Color.WHITE);
		posicion.setForeground(Color.BLACK);
		posicion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		posicion.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		posicion.setBounds(10, 523, 122, 27);
		panel_2.add(posicion);
		
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
		
		posicioon = new JTextPane();
		posicioon.setVisible(false);
		posicioon.setText("POSICION:");
		posicioon.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		posicioon.setBounds(10, 504, 75, 23);
		panel_2.add(posicioon);
		
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
		
		puntoos = new JTextPane();
		puntoos.setVisible(false);
		puntoos.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		puntoos.setText("PUNTOS:");
		puntoos.setBounds(10, 574, 75, 23);
		panel_2.add(puntoos);
		
		media = new JTextPane();
		media.setForeground(Color.BLACK);
		media.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		media.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		media.setBackground(Color.WHITE);
		media.setBounds(10, 593, 122, 27);
		panel_2.add(media);
		
		venderJugadores = new JComboBox();
		venderJugadores.setBackground(Color.WHITE);
		venderJugadores.setVisible(false);
		venderJugadores.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		venderJugadores.setForeground(Color.BLACK);
		venderJugadores.setModel(new DefaultComboBoxModel(new String[] {"Elige Jugador para Vender"}));
		venderJugadores.setBounds(75, 60, 254, 27);
		panel_2.add(venderJugadores);
		
		ampliarvender = new JLabel("");
		ampliarvender.setVisible(false);
		ampliarvender.setBackground(Color.WHITE);
		ampliarvender.setBounds(135, 180, 170, 220);
		panel_2.add(ampliarvender);
		
		cancelarvender = new JButton("CANCELAR");
		cancelarvender.setVisible(false);
		cancelarvender.setForeground(Color.BLACK);
		cancelarvender.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 19));
		cancelarvender.setBackground(Color.LIGHT_GRAY);
		cancelarvender.setBounds(245, 440, 120, 26);
		panel_2.add(cancelarvender);
		
		aceptarvender = new JButton("");
		aceptarvender.setVisible(false);
		aceptarvender.setForeground(new Color(0, 128, 0));
		aceptarvender.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		aceptarvender.setBackground(Color.LIGHT_GRAY);
		aceptarvender.setBounds(60, 440, 130, 26);
		panel_2.add(aceptarvender);
		
		panel_3 = new JPanel();
		panel_3.setForeground(Color.BLACK);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "MI PLANTILLA", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(365, 11, 572, 684);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		elegirPlantilla = new JComboBox();
		elegirPlantilla.setMaximumRowCount(5);
		elegirPlantilla.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		elegirPlantilla.setModel(new DefaultComboBoxModel(new String[] {"Elige Formacion", " 4 - 3 - 3", " 4 - 4 - 2", " 2 - 4 - 4", " 4 - 2 - 4"}));
		elegirPlantilla.setForeground(Color.BLACK);
		elegirPlantilla.setBackground(Color.WHITE);
		elegirPlantilla.setBounds(10, 20, 150, 25);
		panel_3.add(elegirPlantilla);
		
		portero = new JButton("PORTERO");
		portero.setForeground(Color.BLACK);
		portero.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		portero.setVisible(false);
		portero.setBorder(null);
		portero.setBackground(Color.WHITE);
		portero.setBounds(238, 530, 110, 130);
		panel_3.add(portero);
		
		central1_1 = new JButton("DEFENSA I.");
		central1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		central1_1.setForeground(Color.BLACK);
		central1_1.setVisible(false);
		central1_1.setBorder(null);
		central1_1.setBackground(Color.WHITE);
		central1_1.setBounds(165, 380, 110, 130);
		panel_3.add(central1_1);
		
		central2_1 = new JButton("DEFENSA D.");
		central2_1.setForeground(Color.BLACK);
		central2_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		central2_1.setVisible(false);
		central2_1.setBorder(null);
		central2_1.setBackground(Color.WHITE);
		central2_1.setBounds(305, 380, 110, 130);
		panel_3.add(central2_1);
		
		lateralizquierdo_1 = new JButton("LATERAL I.");
		lateralizquierdo_1.setForeground(Color.BLACK);
		lateralizquierdo_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		lateralizquierdo_1.setVisible(false);
		lateralizquierdo_1.setBorder(null);
		lateralizquierdo_1.setBackground(Color.WHITE);
		lateralizquierdo_1.setBounds(15, 380, 110, 130);
		panel_3.add(lateralizquierdo_1);
		
		lateralderecho_1 = new JButton("LATERAL D.");
		lateralderecho_1.setForeground(Color.BLACK);
		lateralderecho_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		lateralderecho_1.setVisible(false);
		lateralderecho_1.setBorder(null);
		lateralderecho_1.setBackground(Color.WHITE);
		lateralderecho_1.setBounds(450, 380, 110, 130);
		panel_3.add(lateralderecho_1);
		
		medio1_1 = new JButton("MEDIO I.");
		medio1_1.setForeground(Color.BLACK);
		medio1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		medio1_1.setVisible(false);
		medio1_1.setBorder(null);
		medio1_1.setBackground(Color.WHITE);
		medio1_1.setBounds(75, 225, 110, 130);
		panel_3.add(medio1_1);
		
		medio2_1 = new JButton("MEDIO");
		medio2_1.setForeground(Color.BLACK);
		medio2_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		medio2_1.setVisible(false);
		medio2_1.setBorder(null);
		medio2_1.setBackground(Color.WHITE);
		medio2_1.setBounds(234, 230, 110, 130);
		panel_3.add(medio2_1);
		
		medio3_1 = new JButton("MEDIO D.");
		medio3_1.setForeground(Color.BLACK);
		medio3_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		medio3_1.setVisible(false);
		medio3_1.setBorder(null);
		medio3_1.setBackground(Color.WHITE);
		medio3_1.setBounds(390, 225, 110, 130);
		panel_3.add(medio3_1);
		
		extremoizquierdo_1 = new JButton("EXTREMO I.");
		extremoizquierdo_1.setForeground(Color.BLACK);
		extremoizquierdo_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		extremoizquierdo_1.setVisible(false);
		extremoizquierdo_1.setBorder(null);
		extremoizquierdo_1.setBackground(Color.WHITE);
		extremoizquierdo_1.setBounds(15, 75, 110, 130);
		panel_3.add(extremoizquierdo_1);
		
		delantero_1 = new JButton("DELANTERO");
		delantero_1.setForeground(Color.BLACK);
		delantero_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		delantero_1.setVisible(false);
		delantero_1.setBorder(null);
		delantero_1.setBackground(Color.WHITE);
		delantero_1.setBounds(234, 70, 110, 130);
		panel_3.add(delantero_1);
		
		extremoderecho_1 = new JButton("EXTREMO D.");
		extremoderecho_1.setForeground(Color.BLACK);
		extremoderecho_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		extremoderecho_1.setVisible(false);
		extremoderecho_1.setBorder(null);
		extremoderecho_1.setBackground(Color.WHITE);
		extremoderecho_1.setBounds(450, 75, 110, 130);
		panel_3.add(extremoderecho_1);
		
		medio1_2 = new JButton("CARRILERO I.");
		medio1_2.setForeground(Color.BLACK);
		medio1_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		medio1_2.setVisible(false);
		medio1_2.setBorder(null);
		medio1_2.setBackground(Color.WHITE);
		medio1_2.setBounds(15, 225, 110, 130);
		panel_3.add(medio1_2);
		
		medio2_2 = new JButton("MEDIO I.");
		medio2_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		medio2_2.setForeground(Color.BLACK);
		medio2_2.setVisible(false);
		medio2_2.setBorder(null);
		medio2_2.setBackground(Color.WHITE);
		medio2_2.setBounds(165, 225, 110, 130);
		panel_3.add(medio2_2);
		
		medio3_2 = new JButton("MEDIO D.");
		medio3_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		medio3_2.setForeground(Color.BLACK);
		medio3_2.setVisible(false);
		medio3_2.setBorder(null);
		medio3_2.setBackground(Color.WHITE);
		medio3_2.setBounds(305, 225, 110, 130);
		panel_3.add(medio3_2);
		
		medio4_2 = new JButton("CARRILERO D.");
		medio4_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		medio4_2.setForeground(Color.BLACK);
		medio4_2.setVisible(false);
		medio4_2.setBorder(null);
		medio4_2.setBackground(Color.WHITE);
		medio4_2.setBounds(450, 225, 110, 130);
		panel_3.add(medio4_2);
		
		delantero1_2 = new JButton("DELANTERO I.");
		delantero1_2.setForeground(Color.BLACK);
		delantero1_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		delantero1_2.setVisible(false);
		delantero1_2.setBorder(null);
		delantero1_2.setBackground(Color.WHITE);
		delantero1_2.setBounds(149, 70, 110, 130);
		panel_3.add(delantero1_2);
		
		delantero2_2 = new JButton("DELANTERO D.");
		delantero2_2.setForeground(Color.BLACK);
		delantero2_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		delantero2_2.setVisible(false);
		delantero2_2.setBorder(null);
		delantero2_2.setBackground(Color.WHITE);
		delantero2_2.setBounds(317, 70, 110, 130);
		panel_3.add(delantero2_2);
		
		central1_3 = new JButton("DEFENSA I.");
		central1_3.setForeground(Color.BLACK);
		central1_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		central1_3.setVisible(false);
		central1_3.setBorder(null);
		central1_3.setBackground(Color.WHITE);
		central1_3.setBounds(75, 370, 110, 130);
		panel_3.add(central1_3);
		
		central3_3 = new JButton("DEFENSA D.");
		central3_3.setForeground(Color.BLACK);
		central3_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 21));
		central3_3.setVisible(false);
		central3_3.setBorder(null);
		central3_3.setBackground(Color.WHITE);
		central3_3.setBounds(398, 370, 110, 130);
		panel_3.add(central3_3);
		
		porterosComboBox = new JComboBox();
		porterosComboBox.setMaximumRowCount(16);
		porterosComboBox.setVisible(false);
		porterosComboBox.setModel(new DefaultComboBoxModel(new String[] {"Elige Portero"}));
		porterosComboBox.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		porterosComboBox.setForeground(Color.BLACK);
		porterosComboBox.setBackground(Color.WHITE);
		porterosComboBox.setBounds(398, 20, 162, 27);
		panel_3.add(porterosComboBox);
		
		centralesDComboBox = new JComboBox();
		centralesDComboBox.setVisible(false);
		centralesDComboBox.setMaximumRowCount(16);
		centralesDComboBox.setModel(new DefaultComboBoxModel(new String[] {"Elige Defensa D."}));
		centralesDComboBox.setForeground(Color.BLACK);
		centralesDComboBox.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		centralesDComboBox.setBackground(Color.WHITE);
		centralesDComboBox.setBounds(398, 20, 162, 27);
		panel_3.add(centralesDComboBox);
		
		puntos = new JTextField();
		puntos.setVisible(false);
		puntos.setBounds(265, 20, 40, 40);
		panel_3.add(puntos);
		puntos.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		puntos.setText("0");
		puntos.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		puntos.setHorizontalAlignment(SwingConstants.CENTER);
		puntos.setBackground(Color.WHITE);
		puntos.setColumns(10);
		
		centralesIComboBox = new JComboBox();
		centralesIComboBox.setMaximumRowCount(16);
		centralesIComboBox.setModel(new DefaultComboBoxModel(new String[] {"Elige Defensa I."}));
		centralesIComboBox.setVisible(false);
		centralesIComboBox.setForeground(Color.BLACK);
		centralesIComboBox.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		centralesIComboBox.setBackground(Color.WHITE);
		centralesIComboBox.setBounds(397, 20, 162, 27);
		panel_3.add(centralesIComboBox);
		
		lateralDComboBox = new JComboBox();
		lateralDComboBox.setBackground(Color.WHITE);
		lateralDComboBox.setMaximumRowCount(16);
		lateralDComboBox.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lateralDComboBox.setModel(new DefaultComboBoxModel(new String[] {"Elige Lateral D."}));
		lateralDComboBox.setForeground(Color.BLACK);
		lateralDComboBox.setVisible(false);
		lateralDComboBox.setBounds(397, 20, 162, 27);
		panel_3.add(lateralDComboBox);
		
		lateralIComboBox = new JComboBox();
		lateralIComboBox.setBackground(Color.WHITE);
		lateralIComboBox.setModel(new DefaultComboBoxModel(new String[] {"Elige Lateral I."}));
		lateralIComboBox.setMaximumRowCount(16);
		lateralIComboBox.setForeground(Color.BLACK);
		lateralIComboBox.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lateralIComboBox.setVisible(false);
		lateralIComboBox.setBounds(397, 20, 162, 27);
		panel_3.add(lateralIComboBox);
		
		recargaPuntos = new JButton("");
		recargaPuntos.setVisible(false);
		recargaPuntos.setBorder(null);
		recargaPuntos.setBackground(Color.WHITE);
		recargaPuntos.setBounds(306, 16, 25, 25);
		panel_3.add(recargaPuntos);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " PERFIL", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(7, 11, 348, 684);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 240, 328, 211);
		panel_4.add(scrollPane);
		
		panelranking = new JPanel();
		scrollPane.setViewportView(panelranking);
		panelranking.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "RANKING", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelranking.setBackground(Color.WHITE);
		panelranking.setLayout(null);
		
		recarga = new JButton("");
		recarga.setBackground(Color.WHITE);
		recarga.setBorder(null);
		recarga.setBounds(283, 11, 35, 35);
		panelranking.add(recarga);
		
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
		dinero.setBounds(8, 3, 82, 26);
		panel_1.add(dinero);
		
		textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBounds(86, 4, 25, 25);
		panel_1.add(textPane_1);
		textPane_1.setBackground(Color.WHITE);
		textPane_1.setForeground(Color.BLACK);
		textPane_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		textPane_1.setText("$");
		
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
		panelPartidos.setForeground(Color.BLACK);
		panelPartidos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PARTIDOS ONLINE", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panelPartidos.setBackground(Color.WHITE);
		panelPartidos.setBounds(10, 462, 328, 213);
		panel_4.add(panelPartidos);
		panelPartidos.setLayout(null);
		
		vs = new JButton("");
		vs.setBorder(null);
		vs.setBackground(Color.WHITE);
		vs.setBounds(280, 11, 40, 40);
		panelPartidos.add(vs);
			
	}
}