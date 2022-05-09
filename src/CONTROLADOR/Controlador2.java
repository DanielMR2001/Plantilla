package CONTROLADOR;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import MODELO.Cartas;
import MODELO.CartasCompradas;
import MODELO.Modelo;
import MODELO.Ranking;
import VISTA.Login;
import VISTA.Plantilla;

public class Controlador2 implements ActionListener{
	
	Login login=new Login();
	Modelo modelo=new Modelo();
	Plantilla plantilla=new Plantilla();
	SessionFactory sessionFactory = null;
	ArrayList<String>jugadoresComprados=new ArrayList<>();
	ArrayList<String>escudos=new ArrayList<>();
	ArrayList<Ranking>listar=new ArrayList<>();

	public Controlador2(VISTA.Plantilla plantilla) {
		this.plantilla=plantilla;
		this.plantilla.comprar.addActionListener(this);
		this.plantilla.vender.addActionListener(this);
		this.plantilla.comprarPosiciones.addActionListener(this);
		this.plantilla.buscar1.addActionListener(this);
		this.plantilla.carta1.addActionListener(this);
		this.plantilla.carta2.addActionListener(this);
		this.plantilla.carta3.addActionListener(this);
		this.plantilla.carta4.addActionListener(this);
		this.plantilla.carta5.addActionListener(this);
		this.plantilla.carta6.addActionListener(this);
		this.plantilla.carta7.addActionListener(this);
		this.plantilla.carta8.addActionListener(this);
		this.plantilla.carta9.addActionListener(this);
		this.plantilla.carta10.addActionListener(this);
		this.plantilla.carta11.addActionListener(this);
		this.plantilla.carta12.addActionListener(this);
		this.plantilla.carta13.addActionListener(this);
		this.plantilla.carta14.addActionListener(this);
		this.plantilla.carta15.addActionListener(this);
		this.plantilla.aceptar.addActionListener(this);
		this.plantilla.elegirPlantilla.addActionListener(this);
		this.plantilla.portero.addActionListener(this);
		this.plantilla.central1_1.addActionListener(this);
		this.plantilla.central1_3.addActionListener(this);
		this.plantilla.central2_1.addActionListener(this);
		this.plantilla.central3_3.addActionListener(this);
		this.plantilla.lateralderecho_1.addActionListener(this);
		this.plantilla.lateralizquierdo_1.addActionListener(this);
		this.plantilla.elegirEscudo.addActionListener(this);
		this.plantilla.porterosComboBox.addActionListener(this);
		this.plantilla.centralesDComboBox.addActionListener(this);
		this.plantilla.centralesIComboBox.addActionListener(this);
		this.plantilla.lateralIComboBox.addActionListener(this);
		this.plantilla.lateralDComboBox.addActionListener(this);
		this.plantilla.recarga.addActionListener(this);
		this.plantilla.vs.addActionListener(this);
		this.plantilla.venderJugadores.addActionListener(this);
		this.plantilla.aceptarvender.addActionListener(this);
		this.plantilla.cancelarvender.addActionListener(this);
		this.plantilla.aceptarSiglas.addActionListener(this);
		modelo.cerrar(plantilla);
        asociarImagen("recarga.png", plantilla.recarga);
        asociarImagen("vs.png", plantilla.vs);
        asociarImagen2("versus.png", plantilla.versus);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//configuracion del hibernate
			Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        sessionFactory = configuration.buildSessionFactory();
	        sessionFactory.getCurrentSession();
			
	        String posicion=(String) plantilla.comprarPosiciones.getSelectedItem();
	        String elegirPortero=(String) plantilla.porterosComboBox.getSelectedItem();
	        String elegirCentralD=(String) plantilla.centralesDComboBox.getSelectedItem();
	        String elegirlateralD=(String) plantilla.lateralDComboBox.getSelectedItem();
	        String elegirLateralI=(String) plantilla.lateralIComboBox.getSelectedItem();
	        String elegirCentralI=(String) plantilla.centralesIComboBox.getSelectedItem();
	        String decidirFormacion=(String) plantilla.elegirPlantilla.getSelectedItem();
	        String decidirVender=(String) plantilla.venderJugadores.getSelectedItem();
	        String escudo=(String) plantilla.elegirEscudo.getSelectedItem();

	        if(escudo.equals("Elige Escudo")) {
	        	asociarImagen2("", plantilla.escudo);
	        	asociarImagen2("usuario.jpg", plantilla.yo);
	        }else if(escudo.equals("Barcelona (ESP)")) {
	        	asociarImagen2("escudos/barsa.png", plantilla.escudo);
	        	asociarImagen2("escudos/barsa.png", plantilla.yo);
	        }else if(escudo.equals("Sevilla (ESP)")) {
	        	asociarImagen2("escudos/sevilla.png", plantilla.escudo);
	        	asociarImagen2("escudos/sevilla.png", plantilla.yo);
	        }else if(escudo.equals("Atl. de Madrid (ESP)")) {
	        	asociarImagen2("escudos/atletico.png", plantilla.escudo);
	        	asociarImagen2("escudos/atletico.png", plantilla.yo);
	        }else if(escudo.equals("Spt. de Lisboa (POR)")) {
	        	asociarImagen2("escudos/lisboa.png", plantilla.escudo);
	        	asociarImagen2("escudos/lisboa.png", plantilla.yo);
	        }else if(escudo.equals("Benfica (POR)")) {
	        	asociarImagen2("escudos/benfica.png", plantilla.escudo);
	        	asociarImagen2("escudos/benfica.png", plantilla.yo);
	        }else if(escudo.equals("Porto (POR)")) {
	        	asociarImagen2("escudos/porto.png", plantilla.escudo);
	        	asociarImagen2("escudos/porto.png", plantilla.yo);
	        }else if(escudo.equals("PSG (FRA)")) {
	        	asociarImagen2("escudos/psg.png", plantilla.escudo);
	        	asociarImagen2("escudos/psg.png", plantilla.yo);
	        }else if(escudo.equals("Mónaco (FRA)")) {
	        	asociarImagen2("escudos/monaco.png", plantilla.escudo);
	        	asociarImagen2("escudos/monaco.png", plantilla.yo);
	        }else if(escudo.equals("M. City (ING)")) {
	        	asociarImagen2("escudos/city.png", plantilla.escudo);
	        	asociarImagen2("escudos/city.png", plantilla.yo);
	        }else if(escudo.equals("M. United (ING)")) {
	        	asociarImagen2("escudos/united.png", plantilla.escudo);
	        	asociarImagen2("escudos/united.png", plantilla.yo);
	        }else if(escudo.equals("Arsenal (ING)")) {
	        	asociarImagen2("escudos/arsenal.png", plantilla.escudo);
	        	asociarImagen2("escudos/arsenal.png", plantilla.yo);
	        }else if(escudo.equals("Tottenham (ING)")) {
	        	asociarImagen2("escudos/tottenham.png", plantilla.escudo);
	        	asociarImagen2("escudos/tottenham.png", plantilla.yo);
	        }else if(escudo.equals("Ajax (HOL)")) {
	        	asociarImagen2("escudos/ajax.png", plantilla.escudo);
	        	asociarImagen2("escudos/ajax.png", plantilla.yo);
	        }else if(escudo.equals("PSV (HOL)")) {
	        	asociarImagen2("escudos/psv.png", plantilla.escudo);
	        	asociarImagen2("escudos/psv.png", plantilla.yo);
	        }else if(escudo.equals("B. de Munich (ALE)")) {
	        	asociarImagen2("escudos/bayern.png", plantilla.escudo);
	        	asociarImagen2("escudos/bayern.png", plantilla.yo);
	        }else if(escudo.equals("B. Dortmund (ALE)")) {
	        	asociarImagen2("escudos/dortmund.png", plantilla.escudo); 
	        	asociarImagen2("escudos/dortmund.png", plantilla.yo); 
	        }else if(escudo.equals("Borussia M. (ALE)")) {
	        	asociarImagen2("escudos/borussia.jpg", plantilla.escudo);
	        	asociarImagen2("escudos/borussia.jpg", plantilla.yo);
	        }else if(escudo.equals("Leipzig (ALE)")) {
	        	asociarImagen2("escudos/leipzig.png", plantilla.escudo);
	        	asociarImagen2("escudos/leipzig.png", plantilla.yo);
	        }else if(escudo.equals("Juventus (ITA)")) {
	        	asociarImagen2("escudos/juventus.png", plantilla.escudo);
	        	asociarImagen2("escudos/juventus.png", plantilla.yo);
	        }else if(escudo.equals("Inter de Milan (ITA)")) {
	        	asociarImagen2("escudos/intermilan.png", plantilla.escudo);
	        	asociarImagen2("escudos/intermilan.png", plantilla.yo);
	        }else if(escudo.equals("Milan (ITA)")) {
	        	asociarImagen2("escudos/milan.png", plantilla.escudo);
	        	asociarImagen2("escudos/milan.png", plantilla.yo);
	        }else if(escudo.equals("Napoles (ITA)")) {
	        	asociarImagen2("escudos/napoles.png", plantilla.escudo);
	        	asociarImagen2("escudos/napoles.png", plantilla.yo);
	        }else if(escudo.equals("Albacete (ESP)")) {
	        	asociarImagen2("escudos/albacete.png", plantilla.escudo);
	        	asociarImagen2("escudos/albacete.png", plantilla.yo);
	        }else if(escudo.equals("Everton (ING)")) {
	        	asociarImagen2("escudos/everton.png", plantilla.escudo);
	        	asociarImagen2("escudos/everton.png", plantilla.yo);
	        }
	                    	                 
	        escudos.add("usuario.jpg");
	        escudos.add("escudos/barsa.png");
	        escudos.add("escudos/sevilla.png");
	        escudos.add("escudos/atletico.png");
	        escudos.add("escudos/lisboa.png");
	        escudos.add("escudos/benfica.png");
	        escudos.add("escudos/porto.png");
	        escudos.add("escudos/psg.png");
	        escudos.add("escudos/monaco.png");
	        escudos.add("escudos/city.png");
	        escudos.add("escudos/united.png");
	        escudos.add("escudos/arsenal.png");
	        escudos.add("escudos/tottenham.png");
	        escudos.add("escudos/ajax.png");
	        escudos.add("escudos/psv.png");
	        escudos.add("escudos/bayern.png");
	        escudos.add("escudos/dortmund.png");
	        escudos.add("escudos/borussia.jpg");
	        escudos.add("escudos/leipzig.png");
	        escudos.add("escudos/juventus.png");
	        escudos.add("escudos/intermilan.png");
	        escudos.add("escudos/milan.png");
	        escudos.add("escudos/napoles.png");
	        escudos.add("escudos/albacete.png");
	        escudos.add("escudos/everton.png");

			//funcionalidad cuando se pulse el boton de Comprar
			if(e.getSource()==plantilla.comprar) {				
				ocultar1(true, false, true, false, true, true, false, false, false);
				plantilla.venderJugadores.setSelectedIndex(0);
				ocultarVender(false);
				plantilla.comprado.setVisible(false);
			}
				
			//funcionalidad cuando se pulse el boton de buscar1 y al selecciona alguna opcion del ComboBox para Comprar
			if(posicion.equals("Elige Posicion")) {
				plantilla.comprado.setVisible(false);
				ocultar2();
			}else if(posicion.equals("Porteros")) {
				plantilla.comprado.setVisible(false);

				ocultar2();
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					for(int i=0; i<=15; i++) {
						modelo.sacarJugadores(sessionFactory, i);
					}
					comprarJugadores("cartas/oblak.png", "cartas/ter stegen.png", "cartas/alisson.png", "cartas/courtois.png", "cartas/neuer.png", "cartas/ederson.png", "cartas/handanovic.png", "cartas/navas.png", "cartas/szczesny.png", "cartas/lloris.png", "cartas/de gea.png",  "cartas/donnaruma.png", "cartas/leno.png", "cartas/gulasci.png", "cartas/sommer.png");	
				}
			}else if(posicion.equals("Defensas")) {
				ocultar2();
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					for(int i=16; i<=30; i++) {
						modelo.sacarJugadores(sessionFactory, i);
					}
					comprarJugadores("cartas/hummels.png", "cartas/de ligt.png", "cartas/laporte.png", "cartas/pique.png", "cartas/de vrij.png", "cartas/lenglet.png", "cartas/manolas.png", "cartas/coates.png",  "cartas/kounde.png", "cartas/skriniar.png", "cartas/nacho.png",  "cartas/upamecano.png", "cartas/koulibaly.png", "cartas/van dijk.png", "cartas/sergio ramos.png");
				}
			}else if(posicion.equals("Laterales I.")) {
				ocultar2();
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					for(int i=31; i<=45; i++) {
						modelo.sacarJugadores(sessionFactory, i);
					}
					comprarJugadores("cartas/davies.png", "cartas/acuña.png", "cartas/juan bernat.png", "cartas/grimaldo.png", "cartas/jordi alba.png", "cartas/robertson.png", "cartas/digne.png", "cartas/spinazzola.png",  "cartas/telles.png", "cartas/sandro.png", "cartas/tagliafico.png", "cartas/marcelo.png", "cartas/guerreiro.png", "cartas/mendy.png", "cartas/gelson.png");
				}
			}else if(posicion.equals("Laterales D.")) {
				ocultar2();
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					for(int i=46; i<=60; i++) {
						modelo.sacarJugadores(sessionFactory, i);
					}
					comprarJugadores("cartas/azpilicueta.png", "cartas/trippier.png", "cartas/jesus navas.png", "cartas/carvajal.png", "cartas/arnold.png", "cartas/cancelo.png", "cartas/wan-bissaka.png", "cartas/walker.png",  "cartas/cuadrado.png", "cartas/pereira.png", "cartas/dest.png",  "cartas/kamara.png", "cartas/kimmich.png", "cartas/corona.png", "cartas/hakimi.png");
				}
			}
			
			//funcionalidad cuando se pulse alguna de las cartas
			if(posicion.equals("Porteros")){
				ocultarCarta();
				sacarCarta(e, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, plantilla.aceptar, "cartas/oblak.png", "cartas/ter stegen.png", "cartas/alisson.png", "cartas/courtois.png", "cartas/neuer.png", "cartas/ederson.png", "cartas/handanovic.png", "cartas/navas.png", "cartas/szczesny.png", "cartas/lloris.png", "cartas/de gea.png",  "cartas/donnaruma.png", "cartas/leno.png", "cartas/gulasci.png", "cartas/sommer.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPRAR PORTEROS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
			}else if(posicion.equals("Defensas")){
				ocultarCarta();
				sacarCarta(e, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, plantilla.aceptar,"cartas/hummels.png", "cartas/de ligt.png", "cartas/laporte.png", "cartas/pique.png", "cartas/de vrij.png", "cartas/lenglet.png", "cartas/manolas.png", "cartas/coates.png",  "cartas/kounde.png", "cartas/skriniar.png", "cartas/nacho.png",  "cartas/upamecano.png", "cartas/koulibaly.png", "cartas/van dijk.png", "cartas/sergio ramos.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPRAR CENTRALES", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
			}else if(posicion.equals("Laterales I.")){
				ocultarCarta();
				sacarCarta(e, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, plantilla.aceptar,"cartas/davies.png", "cartas/acuña.png", "cartas/juan bernat.png", "cartas/grimaldo.png", "cartas/jordi alba.png", "cartas/robertson.png", "cartas/digne.png", "cartas/spinazzola.png",  "cartas/telles.png", "cartas/sandro.png", "cartas/tagliafico.png", "cartas/marcelo.png", "cartas/guerreiro.png", "cartas/mendy.png", "cartas/gelson.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPRAR LATERALES IZQUIERDOS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
			}else if(posicion.equals("Laterales D.")){
				ocultarCarta();
				sacarCarta(e, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, plantilla.aceptar, "cartas/azpilicueta.png", "cartas/trippier.png", "cartas/jesus navas.png", "cartas/carvajal.png", "cartas/arnold.png", "cartas/cancelo.png", "cartas/wan-bissaka.png", "cartas/walker.png",  "cartas/cuadrado.png", "cartas/pereira.png", "cartas/dest.png",  "cartas/kamara.png", "cartas/kimmich.png", "cartas/corona.png", "cartas/hakimi.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPRAR LATERALES DERECHOS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
			}			
			
			//funcionalidad si se compra alguna carta
			if(e.getSource()==plantilla.aceptar) {
				plantilla.comprado.setVisible(false);
				plantilla.panel.setVisible(true);
				String nombre=plantilla.nombre.getText();
				String pais=plantilla.pais.getText();
				String equipo=plantilla.equipo.getText();
				String mediaa=plantilla.media.getText();
				int media=Integer.parseInt(mediaa);
				Cartas carta=modelo.comprarJugadores(sessionFactory, nombre, pais, media, equipo);
				int id=carta.getIdCarta();
				String idd=String.valueOf(id);
				int precio=carta.getPrecio();
				String dineroo=plantilla.dinero.getText();
				String posicionCartaComprada=carta.getPosicion();
				int dinero=Integer.parseInt(dineroo);
				if(precio>dinero) {
					JOptionPane.showMessageDialog(null, "NO TIENES SUFICIENTE DINERO","COMPRAR CARTA", JOptionPane.ERROR_MESSAGE);
				}else {
					plantilla.aceptar.setVisible(false);
					int resta=dinero-precio;
					String restaa=String.valueOf(resta);
					plantilla.dinero.setText(restaa);
					modelo.insertarCarta(sessionFactory, carta, idd);
					plantilla.venderJugadores.addItem(nombre); 
					JOptionPane.showMessageDialog(null, "HAS COMPRADO A "+nombre,"COMPRAR CARTA", JOptionPane.INFORMATION_MESSAGE);
					String registro=plantilla.registro.getText();
					plantilla.registro.setText(registro+"Has Comprado a "+carta.getNombre()+"\n");
					jugadoresComprados.add(nombre);
					System.out.println(jugadoresComprados.toString());
					if(posicionCartaComprada.equals("POR")) {
						plantilla.porterosComboBox.addItem(nombre); 
					}else if(posicionCartaComprada.equals("DEF I")) {
						plantilla.centralesIComboBox.addItem(nombre); 
					}else if(posicionCartaComprada.equals("DEF D")) {
						plantilla.centralesDComboBox.addItem(nombre); 
					}else if(posicionCartaComprada.equals("LI")) {
						plantilla.lateralIComboBox.addItem(nombre); 
					}else if(posicionCartaComprada.equals("LD")) {
						plantilla.lateralDComboBox.addItem(nombre); 
					}					
				}				
			}
			int mediaPortero=ponerCartaIndividualIndividual(elegirPortero, plantilla.portero, "OBLAK", "TER STEGEN", "ALISSON", "COURTOIS", "NEUER", "EDERSON", "HANDANOVIC", "NAVAS", "SZCZESNY", "LLORIS", "DE GEA", "DONNARUMA", "LENO", "GULASCI", "SOMMER", "cartas/oblak.png", "cartas/ter stegen.png", "cartas/alisson.png", "cartas/courtois.png", "cartas/neuer.png", "cartas/ederson.png", "cartas/handanovic.png", "cartas/navas.png", "cartas/szczesny.png", "cartas/lloris.png", "cartas/de gea.png",  "cartas/donnaruma.png", "cartas/leno.png", "cartas/gulasci.png", "cartas/sommer.png", 91, 90, 90, 89, 89, 88, 88, 87, 87, 87, 86, 85, 85, 85, 86);
			quitarJugadorVendidoFormacion(plantilla.porterosComboBox, "PORTERO", plantilla.portero);
			int mediaLateralDerecho=ponerCartaIndividualIndividual(elegirlateralD, plantilla.lateralderecho_1, "AZPILICUETA", "TRIPPIER", "JESUS NAVAS", "CARVAJAL", "ARNOLD", "CANCELO", "WAN-BISSAKA", "WALKER", "CUADRADO", "PEREIRA", "DEST", "KAMARA", "KIMMICH", "CORONA", "HAKIMI", "cartas/azpilicueta.png", "cartas/trippier.png", "cartas/jesus navas.png", "cartas/carvajal.png", "cartas/arnold.png", "cartas/cancelo.png", "cartas/wan-bissaka.png", "cartas/walker.png", "cartas/cuadrado.png", "cartas/pereira.png", "cartas/dest.png",  "cartas/kamara.png", "cartas/kimmich.png", "cartas/corona.png", "cartas/hakimi.png", 83, 83, 84, 86 , 87, 83, 83, 85, 81, 85, 75, 77, 88, 81, 83);
			quitarJugadorVendidoFormacion(plantilla.lateralDComboBox, "LATERAL D.", plantilla.lateralderecho_1);
			int mediaLateralIzquierdo=ponerCartaIndividualIndividual(elegirLateralI, plantilla.lateralizquierdo_1, "DAVIES", "ACUÑA", "JUAN BERNAT", "GRIMALDO", "JORDI ALBA", "ROBERTSON", "DIGNE", "SPINAZZOLA", "ALEX TELLES", "SANDRO", "TAGLIAFICO", "MARCELO", "GUERREIRO", "MENDY", "GELSON", "cartas/davies.png", "cartas/acuña.png", "cartas/juan bernat.png", "cartas/grimaldo.png", "cartas/jordi alba.png", "cartas/robertson.png", "cartas/digne.png", "cartas/spinazzola.png", "cartas/telles.png", "cartas/sandro.png", "cartas/tagliafico.png", "cartas/marcelo.png", "cartas/guerreiro.png", "cartas/mendy.png", "cartas/gelson.png", 81, 83, 83, 84, 86, 87, 84, 82, 84, 85, 84, 83, 84, 83, 82);
			quitarJugadorVendidoFormacion(plantilla.lateralIComboBox, "LATERAL I.", plantilla.lateralizquierdo_1);
			int mediaCentral1_1=ponerCartaIndividualIndividual(elegirCentralI, plantilla.central1_1,"DE LIGT", "PIQUE", "LENGLET", "COATES", "SKRINIAR", "UPAMECANO", "VAN DIJK","","","","","","","","", "cartas/de ligt.png", "cartas/pique.png",  "cartas/lenglet.png", "cartas/coates.png", "cartas/skriniar.png", "cartas/upamecano.png", "cartas/van dijk.png","","","","","","","","", 85, 86, 85, 81, 85, 79, 90, 0,0,0,0,0,0,0,0);
			quitarJugadorVendidoFormacion(plantilla.centralesIComboBox, "CENTRAL I.", plantilla.central1_1);
			int mediaCentral2_1=ponerCartaIndividualIndividual(elegirCentralD, plantilla.central2_1, "HUMMELS", "LAPORTE", "DE VRIJ", "MANOLAS", "KOUNDE", "NACHO", "KOULIBALY", "SERGIO RAMOS","","","","","","","", "cartas/hummels.png", "cartas/laporte.png", "cartas/de vrij.png", "cartas/manolas.png", "cartas/kounde.png", "cartas/nacho.png", "cartas/koulibaly.png", "cartas/sergio ramos.png", "","","","","","","", 86, 87, 84, 83, 79, 80, 88, 89, 0,0,0,0,0,0,0);
			quitarJugadorVendidoFormacion(plantilla.centralesDComboBox, "CENTRAL D.", plantilla.central2_1);
			int mediaCentral1_3=ponerCartaIndividualIndividual(elegirCentralI, plantilla.central1_3,"DE LIGT", "PIQUE", "LENGLET", "COATES", "SKRINIAR", "UPAMECANO", "VAN DIJK","","","","","","","","", "cartas/de ligt.png", "cartas/pique.png",  "cartas/lenglet.png", "cartas/coates.png", "cartas/skriniar.png", "cartas/upamecano.png", "cartas/van dijk.png","","","","","","","","", 85, 86, 85, 81, 85, 79, 90, 0,0,0,0,0,0,0,0);
			quitarJugadorVendidoFormacion(plantilla.centralesIComboBox, "CENTRAL I.", plantilla.central1_3);
			int mediaCentral3_3=ponerCartaIndividualIndividual(elegirCentralD, plantilla.central3_3, "HUMMELS", "LAPORTE", "DE VRIJ", "MANOLAS", "KOUNDE", "NACHO", "KOULIBALY", "SERGIO RAMOS","","","","","","","", "cartas/hummels.png", "cartas/laporte.png", "cartas/de vrij.png", "cartas/manolas.png", "cartas/kounde.png", "cartas/nacho.png", "cartas/koulibaly.png", "cartas/sergio ramos.png", "","","","","","","", 86, 87, 84, 83, 79, 80, 88, 89, 0,0,0,0,0,0,0);			
			quitarJugadorVendidoFormacion(plantilla.centralesDComboBox, "CENTRAL D.", plantilla.central3_3);
			
			//funcionalidad cuando se pulse el boton de Vender 
			if(e.getSource()==plantilla.vender) {
				plantilla.comprado.setVisible(false);
				ocultar1(true, false, false, true, true, false, false, false, true);
				plantilla.venderJugadores.setSelectedIndex(0);
				ocultarVender(false);
				plantilla.comprado.setVisible(false);
			}
			
			if(plantilla.venderJugadores.getSelectedIndex()>0) {
				ocultarVender(true);
				asociarImagen2("cartas/"+decidirVender.toUpperCase()+".png", plantilla.ampliarvender);
				CartasCompradas carta=modelo.sacarPrecio(sessionFactory, decidirVender);
				String pos=carta.getPosicionCartaComprada();
				int precioFinal=(carta.getPrecioCartaComprada()*60)/100;
				String precioo=String.valueOf(precioFinal);
				plantilla.aceptarvender.setText("+ "+precioo+" $");
				if(e.getSource()==plantilla.cancelarvender) {
					plantilla.venderJugadores.setSelectedIndex(0);
					ocultarVender(false);
				}else if(e.getSource()==plantilla.aceptarvender) {
					plantilla.venderJugadores.removeItem(decidirVender);
					plantilla.venderJugadores.setSelectedIndex(0);
					mediaPortero=vender(carta, pos, precioFinal, decidirVender, mediaPortero, "POR", plantilla.porterosComboBox);
					mediaLateralDerecho=vender(carta, pos, precioFinal, decidirVender, mediaLateralDerecho, "LD", plantilla.lateralDComboBox);
					mediaLateralIzquierdo=vender(carta, pos, precioFinal, decidirVender, mediaLateralIzquierdo, "LI", plantilla.lateralIComboBox);
					mediaCentral1_1=vender(carta, pos, precioFinal, decidirVender, mediaCentral1_1, "DEF D", plantilla.centralesDComboBox);
					mediaCentral1_3=vender(carta, pos, precioFinal, decidirVender, mediaCentral1_3, "DEF D", plantilla.centralesDComboBox);
					mediaCentral2_1=vender(carta, pos, precioFinal, decidirVender, mediaCentral2_1, "DEF I", plantilla.centralesIComboBox);
					mediaCentral3_3=vender(carta, pos, precioFinal, decidirVender, mediaCentral3_3, "DEF I", plantilla.centralesIComboBox);
					JOptionPane.showMessageDialog(null, "HAS VENDIDO A "+carta.getNombreCartaComprada(),"VENDER CARTA", JOptionPane.INFORMATION_MESSAGE);
					plantilla.registro.setText(plantilla.registro.getText()+"Has Vendido a "+carta.getNombreCartaComprada()+"\n");
				}
			}
								
			//funcionalidad cuando se coloca el jugador elegido del ComboBox en la formacion
			if(decidirFormacion.equals(" 4 - 3 - 3")) {
				plantilla.portero.setVisible(true); plantilla.central1_1.setVisible(true); plantilla.central2_1.setVisible(true); plantilla.medio1_1.setVisible(true); plantilla.medio2_1.setVisible(true); plantilla.medio3_1.setVisible(true); plantilla.extremoderecho_1.setVisible(true); plantilla.extremoizquierdo_1.setVisible(true); plantilla.delantero_1.setVisible(true); plantilla.lateralderecho_1.setVisible(true); plantilla.lateralizquierdo_1.setVisible(true); plantilla.puntos.setVisible(true);
				plantilla.medio1_2.setVisible(false); plantilla.medio2_2.setVisible(false); plantilla.medio3_2.setVisible(false); plantilla.medio4_2.setVisible(false); plantilla.delantero1_2.setVisible(false); plantilla.delantero2_2.setVisible(false); plantilla.central1_3.setVisible(false); plantilla.central3_3.setVisible(false); 						
					int media=(mediaPortero+mediaLateralDerecho+mediaLateralIzquierdo+mediaCentral1_1+mediaCentral2_1)/11;
					String mediaa=String.valueOf(media);
					plantilla.puntos.setText(mediaa);				
			}else if(decidirFormacion.equals(" 4 - 4 - 2")) {
				plantilla.portero.setVisible(true); plantilla.central1_1.setVisible(true); plantilla.central2_1.setVisible(true);plantilla.lateralderecho_1.setVisible(true); plantilla.lateralizquierdo_1.setVisible(true);plantilla.medio1_2.setVisible(true); plantilla.medio2_2.setVisible(true); plantilla.medio3_2.setVisible(true); plantilla.medio4_2.setVisible(true); plantilla.delantero1_2.setVisible(true); plantilla.delantero2_2.setVisible(true); plantilla.puntos.setVisible(true);
				plantilla.medio1_1.setVisible(false); plantilla.medio2_1.setVisible(false); plantilla.medio3_1.setVisible(false); plantilla.extremoderecho_1.setVisible(false); plantilla.extremoizquierdo_1.setVisible(false); plantilla.delantero_1.setVisible(false); plantilla.central1_3.setVisible(false); plantilla.central3_3.setVisible(false); 
					int media=(mediaPortero+mediaLateralDerecho+mediaLateralIzquierdo+mediaCentral1_1+mediaCentral2_1)/11;
					String mediaa=String.valueOf(media);
					plantilla.puntos.setText(mediaa);
			}else if(decidirFormacion.equals(" 2 - 4 - 4")) {
				plantilla.portero.setVisible(true); plantilla.central1_3.setVisible(true); plantilla.central3_3.setVisible(true); plantilla.medio1_2.setVisible(true); plantilla.medio2_2.setVisible(true); plantilla.medio3_2.setVisible(true); plantilla.medio4_2.setVisible(true); plantilla.extremoderecho_1.setVisible(true); plantilla.extremoizquierdo_1.setVisible(true); plantilla.delantero1_2.setVisible(true); plantilla.delantero2_2.setVisible(true); plantilla.puntos.setVisible(true);
				plantilla.medio1_1.setVisible(false); plantilla.medio2_1.setVisible(false); plantilla.medio3_1.setVisible(false); plantilla.delantero_1.setVisible(false); plantilla.central1_1.setVisible(false); plantilla.central2_1.setVisible(false); plantilla.lateralderecho_1.setVisible(false); plantilla.lateralizquierdo_1.setVisible(false);  
					int media=(mediaPortero+mediaCentral1_3+mediaCentral3_3)/11;
				 	String mediaa=String.valueOf(media);
				plantilla.puntos.setText(mediaa);
			}else if(decidirFormacion.equals(" 4 - 2 - 4")) {
				plantilla.portero.setVisible(true); plantilla.central1_1.setVisible(true); plantilla.central2_1.setVisible(true);  plantilla.extremoderecho_1.setVisible(true); plantilla.extremoizquierdo_1.setVisible(true); plantilla.delantero1_2.setVisible(true); plantilla.delantero2_2.setVisible(true); plantilla.lateralderecho_1.setVisible(true); plantilla.lateralizquierdo_1.setVisible(true); plantilla.medio2_2.setVisible(true); plantilla.medio3_2.setVisible(true); plantilla.puntos.setVisible(true);
				plantilla.medio2_1.setVisible(false); plantilla.delantero_1.setVisible(false); plantilla.central3_3.setVisible(false); plantilla.medio1_2.setVisible(false); plantilla.medio1_1.setVisible(false); plantilla.medio3_1.setVisible(false); plantilla.medio4_2.setVisible(false); plantilla.central1_3.setVisible(false); 
					int media=(mediaPortero+mediaLateralDerecho+mediaLateralIzquierdo+mediaCentral1_1+mediaCentral2_1)/11;
					String mediaa=String.valueOf(media);
					plantilla.puntos.setText(mediaa);
			}
			
			//mostrar el comboBox necesario al pulsar la posicion para elegir la carta
			if(e.getSource()==plantilla.portero) {
				ocultarComboBox(true, false, false, false, false);
			}else if((e.getSource()==plantilla.central1_1)||(e.getSource()==plantilla.central1_3)) {
				ocultarComboBox(false, false, false, false, true);
			}else if((e.getSource()==plantilla.central2_1)||(e.getSource()==plantilla.central3_3)) {
				ocultarComboBox(false, true, false, false, false);
			}else if(e.getSource()==plantilla.lateralizquierdo_1) {
				ocultarComboBox(false, false, false, true, false);
			}else if(e.getSource()==plantilla.lateralderecho_1) {
				ocultarComboBox(false, false, true, false, false);
			}
			
			//funcionalidad cuando se introduzca correctamente el nombre en el ranking
			if(e.getSource()==plantilla.aceptarSiglas) {
				String siglas=plantilla.siglas.getText();
				if(siglas.length()!=3) {
					plantilla.error.setVisible(true);
					plantilla.siglas.setText("");
				}else {
					plantilla.siglaas.setVisible(false);
					plantilla.siglas.setVisible(false);
					plantilla.error.setVisible(false);
					plantilla.aceptarSiglas.setVisible(false);
					plantilla.ej.setVisible(false);
					plantilla.recarga.setVisible(true);
					plantilla.vs.setVisible(true);
					plantilla.listar.setVisible(true);
					plantilla.scrollPane.setVisible(true);
					plantilla.miPosicion.setVisible(true);
					plantilla.panelranking.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "RANKING - ("+siglas+")", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));					
					listarRanking();
				}
			}

			//funcionalidad si se pulsa el boton de recarga
			if(e.getSource()==plantilla.recarga) {
				listar.removeAll(listar);
				plantilla.listar.setText("");
				listarRanking();
			}
			
			if(e.getSource()==plantilla.vs) {
				int dinero=Integer.parseInt(plantilla.dinero.getText());
				String nombreSiglas=plantilla.siglas.getText()+"*";
				char[] myChars = nombreSiglas.toCharArray();
				char chhar1=0, chhar2=0, chhar3=0, chhar4=0, chhar5=0;
				for (int i=0; i<myChars.length; i++){
					chhar1=myChars[0];
					chhar2=myChars[1];
					chhar3=myChars[2];
					chhar4=myChars[3];
				}
				if(dinero<3000) {
					JOptionPane.showMessageDialog(null, "DEBES DE TENER MÁS DE 3000 $","DINERO INSUFICIENTE", JOptionPane.ERROR_MESSAGE);
				}else {
					int siglasOtro=(int)(Math.random()*listar.size());
					String nombreSiglas2=plantilla.siglas.getText();
					char[] myChars2 = nombreSiglas.toCharArray();
					char chhar11=0, chhar22=0, chhar33=0, chhar44=0, chhar55=0;
					for (int i=0; i<myChars.length; i++){
						chhar1=myChars[0];
						chhar2=myChars[1];
						chhar3=myChars[2];
					}
					do {
						plantilla.yo.setVisible(true); 
						plantilla.versus.setVisible(true);
						plantilla.otro.setVisible(true);
						plantilla.miSigla.setVisible(true);
						int entero=Integer.parseInt(plantilla.puntos.getText());
						plantilla.miSigla.setText(plantilla.siglas.getText()+"("+entero+")");
						int otro=(int)(Math.random()*escudos.size());
						asociarImagen2(escudos.get(otro), plantilla.otro);
						plantilla.siglasotro.setText(listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+"("+listar.get(siglasOtro).getNumero()+")");
						if(listar.get(siglasOtro).getNumero()>entero) {
							JOptionPane.showMessageDialog(null, "HAS PERDIDO CONTRA "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" (-3000 $)\n           "+plantilla.siglas.getText()+" ("+entero+")     VS     "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" ("+listar.get(siglasOtro).getNumero()+")","PARTIDO PERDIDO", JOptionPane.ERROR_MESSAGE);
							int resta=dinero-3000;
							String dineroFinal=String.valueOf(resta);
							plantilla.dinero.setText(dineroFinal);
							plantilla.registro.setText(plantilla.registro.getText()+"Has Perdido contra "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" -3000$\n");
						}else if(listar.get(siglasOtro).getNumero()<entero){
							JOptionPane.showMessageDialog(null, "HAS GANADO CONTRA "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" (+5000 $)\n           "+plantilla.siglas.getText()+" ("+entero+")     VS     "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" ("+listar.get(siglasOtro).getNumero()+")","PARTIDO GANADO", JOptionPane.INFORMATION_MESSAGE);
							int resta=dinero+5000;
							String dineroFinal=String.valueOf(resta);
							plantilla.dinero.setText(dineroFinal);
							plantilla.registro.setText(plantilla.registro.getText()+"Has Ganado contra "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" +5000$\n");
						}else {
							int prorroga=(int)(Math.random()*1);
							if(prorroga==0) {
								JOptionPane.showMessageDialog(null, "HAS PERDIDO CONTRA "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" (-3000 $)\n           "+plantilla.siglas.getText()+" ("+entero+")     VS     "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" ("+listar.get(siglasOtro).getNumero()+")","PARTIDO PERDIDO", JOptionPane.ERROR_MESSAGE);
								int resta=dinero-3000;
								String dineroFinal=String.valueOf(resta);
								plantilla.dinero.setText(dineroFinal);
								plantilla.registro.setText(plantilla.registro.getText()+"Has Perdido contra "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" -3000$\n");
							}else if(prorroga==1) {
								JOptionPane.showMessageDialog(null, "HAS GANADO CONTRA "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" (+5000 $)\n           "+plantilla.siglas.getText()+" ("+entero+")     VS     "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" ("+listar.get(siglasOtro).getNumero()+")","PARTIDO GANADO", JOptionPane.INFORMATION_MESSAGE);
								int resta=dinero+5000;
								String dineroFinal=String.valueOf(resta);
								plantilla.dinero.setText(dineroFinal);
								plantilla.registro.setText(plantilla.registro.getText()+"Has Ganado contra "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" +5000$\n");
							}
						}
					}while((listar.get(siglasOtro).getSigla1()==chhar1)&&(listar.get(siglasOtro).getSigla2()==chhar2)&&(listar.get(siglasOtro).getSigla3()==chhar3));				
				}
			}
					
		} catch (Exception e3) { e3.printStackTrace(); 
		} finally { if(sessionFactory != null) { sessionFactory.close(); } }	
	}

	private void listarRanking() {
		//crear nombres aleatorios de los demás jugadores
		Ranking r=null;
		String setOfCharacters = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz";
		Random random = new Random();
		for(int i=0; i<49; i++) {
			int randomInt1 = random.nextInt(setOfCharacters.length());
			char randomChar1 = setOfCharacters.charAt(randomInt1);
			int randomInt2 = random.nextInt(setOfCharacters.length());
			char randomChar2 = setOfCharacters.charAt(randomInt2);
			int randomInt3 = random.nextInt(setOfCharacters.length());
			int aleatorio=(int) (Math.random()*((101-1))+1);
			char randomChar3 = setOfCharacters.charAt(randomInt3);
			r=new Ranking(randomChar1, randomChar2, randomChar3, aleatorio);
			listar.add(r);
		}		
		//incluirme en el ranking con el primer valor igual a 0, para iniciar el ranking
		Ranking r2=null;
		String nombreSiglas=plantilla.siglas.getText()+"*";
		char[] myChars = nombreSiglas.toCharArray();
		char chhar1=0, chhar2=0, chhar3=0, chhar4=0, chhar5=0;
		for (int i=0; i<myChars.length; i++){
			chhar1=myChars[0];
			chhar2=myChars[1];
			chhar3=myChars[2];
			chhar4=myChars[3];
		}
		int entero=Integer.parseInt(plantilla.puntos.getText());
		r2=new Ranking(chhar1, chhar2, chhar3, chhar4, entero);
		listar.add(r2);
		//ordenar el array
		int i1=0;
		for(int i=0; i<listar.size(); i++) {
			i1=i1+1;
			Collections.sort(listar, new Comparator<Ranking>() {
				@Override
				public int compare(Ranking r1, Ranking r2) {
					return new Integer(r2.getNumero()).compareTo(new Integer(r1.getNumero()));
				}
			});
			
			if(i1!=50) {
				plantilla.listar.setText(plantilla.listar.getText()+(i+1)+"º-"+listar.get(i).toString()+"\n");
			}else {
				plantilla.listar.setText(plantilla.listar.getText()+50+"º-"+listar.get(i).toString());
			}		
			
			if((listar.get(i).getSigla1()==chhar1)&&(listar.get(i).getSigla2()==chhar2)&&(listar.get(i).getSigla3()==chhar3)) {
				String mp=String.valueOf(i1);
				plantilla.miPosicion.setText(mp+"º");
			}
		}
	}
	
	//vender carta seleccionada y borrar de la BBDD
	private int vender(CartasCompradas carta, String pos, int precioFinal, String decidirVender, int media1, String posicion, JComboBox cb1) {
		if(pos.equals(posicion)){
			int dinero=Integer.parseInt(plantilla.dinero.getText())+precioFinal;
			String din=String.valueOf(dinero);
			plantilla.dinero.setText(din);
			cb1.removeItem(decidirVender);
			cb1.setSelectedIndex(0);
			media1=0;
			ocultarVender(false);
			jugadoresComprados.remove(carta.getNombreCartaComprada());
			modelo.borrarDatosCartaVendida(carta.getNombreCartaComprada());
		}
		return media1;
	}

	//resetear el boton de la posicion de la carta vendida pero sin la opcion de la carta vendida
	private void quitarJugadorVendidoFormacion(JComboBox cb, String pos, JButton boton) {
		if(cb.getSelectedIndex()==0) {
			boton.setIcon(new ImageIcon(""));
			boton.setText(pos);
		}
	}

	//ocultar comboBox dependiendo del boton que se pulse en la formacion
	private void ocultarComboBox(Boolean uno, Boolean dos, Boolean tres, Boolean cuatro, Boolean cinco) {
		plantilla.porterosComboBox.setVisible(uno);
		plantilla.centralesDComboBox.setVisible(dos);	
		plantilla.lateralDComboBox.setVisible(tres);
		plantilla.lateralIComboBox.setVisible(cuatro);	
		plantilla.centralesIComboBox.setVisible(cinco);
	}

	//poner la imagen de la opcion seleccionada del comboBox
	private int ponerCartaIndividualIndividual(String elegir, JButton boton, String jugador1, String jugador2, String jugador3, String jugador4, String jugador5, String jugador6, String jugador7, String jugador8, String jugador9, String jugador10, String jugador11, String jugador12, String jugador13, String jugador14, String jugador15, String imagen1, String imagen2, String imagen3, String imagen4, String imagen5, String imagen6, String imagen7, String imagen8, String imagen9, String imagen10, String imagen11, String imagen12, String imagen13, String imagen14, String imagen15, int media1, int media2, int media3, int media4, int media5, int media6, int media7, int media8, int media9, int media10, int media11, int media12, int media13, int media14, int media15) {
		int media=0;
		if(elegir.equals(jugador1)) {
			media=media1;
			boton.setText("");
			asociarImagen(imagen1, boton);
		}else if(elegir.equals(jugador2)) {
			media=media2;
			boton.setText("");
			asociarImagen(imagen2, boton);
		}else if(elegir.equals(jugador3)) {
			media=media3;
			boton.setText("");
			asociarImagen(imagen3, boton);
		}else if(elegir.equals(jugador4)) {
			media=media4;
			boton.setText("");
			asociarImagen(imagen4, boton);
		}else if(elegir.equals(jugador5)) {
			media=media5;
			boton.setText("");
			asociarImagen(imagen5, boton);
		}else if(elegir.equals(jugador6)) {
			media=media6;
			boton.setText("");
			asociarImagen(imagen6, boton);
		}else if(elegir.equals(jugador7)) {
			media=media7;
			boton.setText("");
			asociarImagen(imagen7, boton);
		}else if(elegir.equals(jugador8)) {
			media=media8;
			boton.setText("");
			asociarImagen(imagen8, boton);
		}else if(elegir.equals(jugador9)) {
			media=media9;
			boton.setText("");
			asociarImagen(imagen9, boton);
		}else if(elegir.equals(jugador10)) {
			media=media10;
			boton.setText("");
			asociarImagen(imagen10, boton);
		}else if(elegir.equals(jugador11)) {
			media=media11;
			boton.setText("");
			asociarImagen(imagen11, boton);
		}else if(elegir.equals(jugador12)) {
			media=media12;
			boton.setText("");
			asociarImagen(imagen12, boton);
		}else if(elegir.equals(jugador13)) {
			media=media13;
			boton.setText("");
			asociarImagen(imagen13, boton);
		}else if(elegir.equals(jugador14)) {
			media=media14;
			boton.setText("");
			asociarImagen(imagen14, boton);
		}else if(elegir.equals(jugador15)) {
			media=media15;
			boton.setText("");
			asociarImagen(imagen15, boton);
		}	
		return media;
	}
	
	//ocultar informacion de la carta que se haya pulsado
	private void ocultarCarta() {
		plantilla.nombre.setVisible(false); plantilla.pais.setVisible(false); plantilla.media.setVisible(false); plantilla.equipo.setVisible(false); plantilla.posicion.setVisible(false);
		plantilla.nombree.setVisible(false); plantilla.paiis.setVisible(false); plantilla.puntoos.setVisible(false); plantilla.equipoo.setVisible(false); plantilla.posicioon.setVisible(false);
	}

	//poner visible o invisible los componentes, dependiendo de lo que se quiera hacer cuando se llame al metodo
	private void ocultar1(boolean uno, boolean dos, boolean tres, boolean cuatro, boolean cinco, boolean seis, boolean siete, boolean ocho, boolean nueve) {
		plantilla.ampliar.setVisible(uno);
		plantilla.buscar1.setVisible(tres);
		plantilla.panel.setVisible(cinco);
		plantilla.comprarPosiciones.setSelectedIndex(0);
		plantilla.comprarPosiciones.setVisible(seis);
		plantilla.aceptar.setVisible(siete);
		plantilla.porterosComboBox.setVisible(false); plantilla.centralesDComboBox.setVisible(false);
		plantilla.venderJugadores.setVisible(nueve); ;
		ocultarCarta();
	}

	private void ocultarVender(boolean uno) {
		plantilla.ampliarvender.setVisible(uno); 
		plantilla.aceptarvender.setVisible(uno); 
		plantilla.cancelarvender.setVisible(uno); 
	}
	
	//ocultar el panel, jlabel y el jbutton que se le pase por parámetro
	private void ocultar2() {
		plantilla.panel.setVisible(false);
		plantilla.ampliar.setVisible(false);
		plantilla.aceptar.setVisible(false);
		plantilla.comprado.setVisible(false);
		plantilla.centralesDComboBox.setVisible(false);
		plantilla.centralesIComboBox.setVisible(false);
		plantilla.porterosComboBox.setVisible(false);
		plantilla.lateralDComboBox.setVisible(false);
		plantilla.lateralIComboBox.setVisible(false);
	}

	//poner las cartas correspondientes en su lugar para comprarlas
	private void comprarJugadores(String url1, String url2, String url3, String url4, String url5, String url6, String url7, String url8, String url9, String url10, String url11, String url12, String url13, String url14, String url15) {
		asociarImagen(url1, plantilla.carta1);
		asociarImagen(url2, plantilla.carta2);
		asociarImagen(url3, plantilla.carta3);
		asociarImagen(url4, plantilla.carta4);
		asociarImagen(url5, plantilla.carta5);
		asociarImagen(url6, plantilla.carta6);
		asociarImagen(url7, plantilla.carta7);
		asociarImagen(url8, plantilla.carta8);
		asociarImagen(url9, plantilla.carta9);
		asociarImagen(url10, plantilla.carta10);
		asociarImagen(url11, plantilla.carta11);
		asociarImagen(url12, plantilla.carta12);
		asociarImagen(url13, plantilla.carta13);
		asociarImagen(url14, plantilla.carta14);
		asociarImagen(url15, plantilla.carta15);
	}
	
	//sacar información de las cartas que se eligan
	private void sacarCarta(ActionEvent e, int uno, int dos, int tres, int cuatro, int cinco, int seis, int siete, int ocho, int nueve, int diez, int once, int doce, int trece, int catorce, int quince, JButton label1, String url1, String url2, String url3, String url4, String url5, String url6, String url7, String url8, String url9, String url10, String url11, String url12, String url13, String url14, String url15) {
		if((e.getSource()==plantilla.carta1)) {	
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, uno);
			asociarImagen2(url1, plantilla.ampliar);
		}else if(e.getSource()==plantilla.carta2){
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, dos);	
			asociarImagen2(url2, plantilla.ampliar);
		}else if(e.getSource()==plantilla.carta3) {
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, tres);	
			asociarImagen2(url3, plantilla.ampliar);
		}else if(e.getSource()==plantilla.carta4) {
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, cuatro);
			asociarImagen2(url4, plantilla.ampliar);
		}else if(e.getSource()==plantilla.carta5) {
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, cinco);	
			asociarImagen2(url5,plantilla.ampliar);
		}else if(e.getSource()==plantilla.carta6) {
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, seis);	
			asociarImagen2(url6, plantilla.ampliar);
		}else if(e.getSource()==plantilla.carta7) {
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, siete);
			asociarImagen2(url7, plantilla.ampliar);
		}else if(e.getSource()==plantilla.carta8) {
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, ocho);	
			asociarImagen2(url8, plantilla.ampliar);
		}else if(e.getSource()==plantilla.carta9) {
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, nueve);	
			asociarImagen2(url9, plantilla.ampliar);
		}else if(e.getSource()==plantilla.carta10) {
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, diez);	
			asociarImagen2(url10, plantilla.ampliar);
		}else if(e.getSource()==plantilla.carta11) {
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, once);	
			asociarImagen2(url11, plantilla.ampliar);
		}else if(e.getSource()==plantilla.carta12) {
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, doce);	
			asociarImagen2(url12, plantilla.ampliar);
		}else if(e.getSource()==plantilla.carta13) {
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, trece);
			asociarImagen2(url13, plantilla.ampliar);
		}else if(e.getSource()==plantilla.carta14) {
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, catorce);
			asociarImagen2(url14, plantilla.ampliar);
		}else if(e.getSource()==plantilla.carta15) {
			plantilla.ampliar.setVisible(true); plantilla.panel.setVisible(true); label1.setVisible(true);
			sacarPrecio(e, quince);
			asociarImagen2(url15, plantilla.ampliar);
		}
	}
	
	//modificar los datos de la carta dependiendo de la carta que sea y ocultar boton de comprar si la carta ya se ha comprado
	private void sacarPrecio(ActionEvent e, int numero) {
		plantilla.nombree.setVisible(true); plantilla.paiis.setVisible(true); plantilla.puntoos.setVisible(true); plantilla.equipoo.setVisible(true); plantilla.posicioon.setVisible(true); 
		plantilla.nombre.setVisible(true); plantilla.pais.setVisible(true); plantilla.media.setVisible(true); plantilla.equipo.setVisible(true); plantilla.posicion.setVisible(true);
		Cartas carta1=modelo.sacarJugadores(sessionFactory, numero);
		String precio=String.valueOf(carta1.getPrecio());
		String nombre=String.valueOf(carta1.getNombre());
		String pais=String.valueOf(carta1.getPais());
		String media=String.valueOf(carta1.getMedia());
		String equipo=String.valueOf(carta1.getEquipo());		
		String pos=String.valueOf(carta1.getPosicion());
		plantilla.aceptar.setVisible(true);
		plantilla.aceptar.setText("- "+precio+" $");
		plantilla.aceptar.setForeground(Color.RED);
		plantilla.nombre.setText(nombre);
		plantilla.pais.setText(pais);
		plantilla.media.setText(media);
		plantilla.equipo.setText(equipo);
		if(pos.equals("POR")) {pos="PORTERO"; }
		if(pos.equals("DEF D")) {pos="CENTRAL D."; }
		if(pos.equals("DEF I")) {pos="CENTRAL I."; } 
		if(pos.equals("LI")) {pos="LATERAL I."; }
		if(pos.equals("LD")) {pos="LATERAL D."; }
		plantilla.posicion.setText(pos);
		if(jugadoresComprados.contains(nombre)) {
			plantilla.aceptar.setVisible(false);
			plantilla.comprado.setVisible(true);
		}
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