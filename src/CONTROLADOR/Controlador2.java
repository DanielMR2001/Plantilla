package CONTROLADOR;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import MODELO.Cartas;
import MODELO.CartasCompradas;
import MODELO.Modelo;
import MODELO.Ranking;
import VISTA.Plantilla;

public class Controlador2 implements ActionListener{
	
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
		this.plantilla.medio1_1.addActionListener(this);
		this.plantilla.medio1_2.addActionListener(this);
		this.plantilla.medio2_1.addActionListener(this);
		this.plantilla.medio2_2.addActionListener(this);
		this.plantilla.medio3_1.addActionListener(this);
		this.plantilla.medio3_2.addActionListener(this);
		this.plantilla.medio4_2.addActionListener(this);
		this.plantilla.lateralderecho_1.addActionListener(this);
		this.plantilla.lateralizquierdo_1.addActionListener(this);
		this.plantilla.extremoderecho_1.addActionListener(this);
		this.plantilla.extremoizquierdo_1.addActionListener(this);
		this.plantilla.delantero1_2.addActionListener(this);
		this.plantilla.delantero2_2.addActionListener(this);
		this.plantilla.delantero_1.addActionListener(this);
		this.plantilla.elegirEscudo.addActionListener(this);
		this.plantilla.porterosComboBox.addActionListener(this);
		this.plantilla.centralesDComboBox.addActionListener(this);
		this.plantilla.centralesIComboBox.addActionListener(this);
		this.plantilla.lateralIComboBox.addActionListener(this);
		this.plantilla.mediosComboBox.addActionListener(this);
		this.plantilla.mediosDComboBox.addActionListener(this);
		this.plantilla.mediosIComboBox.addActionListener(this);
		this.plantilla.lateralDComboBox.addActionListener(this);
		this.plantilla.carrileroDComboBox.addActionListener(this);
		this.plantilla.carrileroIComboBox.addActionListener(this);
		this.plantilla.lateralDComboBox.addActionListener(this);
		this.plantilla.extremosDCcomboBox.addActionListener(this);
		this.plantilla.extremosICcomboBox.addActionListener(this);
		this.plantilla.delanteroCcomboBox.addActionListener(this);
		this.plantilla.delanteroDCcomboBox.addActionListener(this);
		this.plantilla.delanteroICcomboBox.addActionListener(this);
		this.plantilla.recarga.addActionListener(this);
		this.plantilla.vs.addActionListener(this);
		this.plantilla.venderJugadores.addActionListener(this);
		this.plantilla.aceptarvender.addActionListener(this);
		this.plantilla.cancelarvender.addActionListener(this);
		this.plantilla.aceptarSiglas.addActionListener(this);
		this.plantilla.extremoizquierdo_1.addActionListener(this);
		this.plantilla.extremoderecho_1.addActionListener(this);
        asociarImagen("recarga.png", plantilla.recarga);
        asociarImagen("batalla.jpg", plantilla.vs);
        asociarImagen2("versus.png", plantilla.versus); 
		//al cerrar la app, guardar puntos y nombre de la plantilla para incluirlo en el ranking en la siguiente ejecucion
		cerrar(plantilla);
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
	        String elegirmedioI=(String) plantilla.mediosIComboBox.getSelectedItem();
	        String elegirmedioD=(String) plantilla.mediosDComboBox.getSelectedItem();
	        String elegirmedio=(String) plantilla.mediosComboBox.getSelectedItem();
	        String elegircarrileroD=(String) plantilla.carrileroDComboBox.getSelectedItem();
	        String elegircarrileroI=(String) plantilla.carrileroIComboBox.getSelectedItem();
	        String elegirextremoI=(String) plantilla.extremosICcomboBox.getSelectedItem();
	        String elegirextremoD=(String) plantilla.extremosDCcomboBox.getSelectedItem();
	        String elegirdelantero=(String) plantilla.delanteroCcomboBox.getSelectedItem();
	        String elegirdelanteroI=(String) plantilla.delanteroICcomboBox.getSelectedItem();
	        String elegirdelanteroD=(String) plantilla.delanteroDCcomboBox.getSelectedItem();
	        String decidirFormacion=(String) plantilla.elegirPlantilla.getSelectedItem();
	        String decidirVender=(String) plantilla.venderJugadores.getSelectedItem();
	        String escudo=(String) plantilla.elegirEscudo.getSelectedItem();
			int comparar=Integer.parseInt(plantilla.puntos.getText());

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
	        }else if(escudo.equals("M??naco (FRA)")) {
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
	                    	                 
	        escudos();

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
					comprarJugadores("cartas/oblak.png", "cartas/ter stegen.png", "cartas/alisson.png", "cartas/courtois.png", "cartas/neuer.png", "cartas/ederson.png", "cartas/handanovic.png", "cartas/navas.png", "cartas/szczesny.png", "cartas/lloris.png", "cartas/de gea.png",  "cartas/donnaruma.png", "cartas/leno.png", "cartas/gulasci.png", "cartas/sommer.png");	
				}
			}else if(posicion.equals("Centrales")) {
				ocultar2();
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					comprarJugadores("cartas/hummels.png", "cartas/de ligt.png", "cartas/laporte.png", "cartas/pique.png", "cartas/de vrij.png", "cartas/lenglet.png", "cartas/manolas.png", "cartas/coates.png",  "cartas/kounde.png", "cartas/skriniar.png", "cartas/nacho.png",  "cartas/upamecano.png", "cartas/koulibaly.png", "cartas/van dijk.png", "cartas/sergio ramos.png");
				}
			}else if(posicion.equals("Laterales I.")) {
				ocultar2();
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					comprarJugadores("cartas/davies.png", "cartas/acu??a.png", "cartas/juan bernat.png", "cartas/grimaldo.png", "cartas/jordi alba.png", "cartas/robertson.png", "cartas/digne.png", "cartas/spinazzola.png",  "cartas/telles.png", "cartas/sandro.png", "cartas/tagliafico.png", "cartas/marcelo.png", "cartas/guerreiro.png", "cartas/mendy.png", "cartas/gelson.png");
				}
			}else if(posicion.equals("Laterales D.")) {
				ocultar2();
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					comprarJugadores("cartas/azpilicueta.png", "cartas/trippier.png", "cartas/jesus navas.png", "cartas/carvajal.png", "cartas/arnold.png", "cartas/cancelo.png", "cartas/wan-bissaka.png", "cartas/walker.png",  "cartas/cuadrado.png", "cartas/ricardo.png", "cartas/dest.png",  "cartas/kamara.png", "cartas/kimmich.png", "cartas/corona.png", "cartas/hakimi.png");
				}
			}else if(posicion.equals("Mediocentros")) {
				ocultar2();
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					comprarJugadores("cartas/de jong.png", "cartas/de bruyne.png", "cartas/thiago.png", "cartas/coutinho.png", "cartas/fabinho.png", "cartas/busquets.png", "cartas/muller.png", "cartas/ozil.png",  "cartas/gomez.png", "cartas/david silva.png", "cartas/reus.png",  "cartas/kante.png", "cartas/bruno.png", "cartas/luis alberto.png", "cartas/verratti.png");
				}
			}else if(posicion.equals("Carrileros I.")) {
				ocultar2();
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					comprarJugadores("cartas/ziyech.png", "cartas/dybala.png", "cartas/pjanic.png", "cartas/vidal.png", "cartas/mertens.png", "cartas/eriksen.png", "cartas/witsel.png", "cartas/odegaard.png",  "cartas/partey.png", "cartas/nani.png", "cartas/isco.png",  "cartas/aranguiz.png", "cartas/parejo.png", "cartas/insigne.png", "cartas/sancho.png");
				}
			}else if(posicion.equals("Carrileros D.")) {
				ocultar2();
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					comprarJugadores("cartas/sane.png", "cartas/brandt.png", "cartas/zakaria.png", "cartas/koke.png", "cartas/celso.png", "cartas/bernardo.png", "cartas/alli.png", "cartas/pereira.png",  "cartas/goretzka.png", "cartas/casemiro.png", "cartas/valverde.png",  "cartas/havertz.png", "cartas/immobile.png", "cartas/pogba.png", "cartas/moutinho.png");
				}
			}else if(posicion.equals("Extremos I.")) {
				ocultar2();
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					comprarJugadores("cartas/depay.png", "cartas/neymar.png", "cartas/hazard.png", "cartas/sterling.png", "cartas/oyarzabal.png", "cartas/coman.png", "cartas/callejon.png", "cartas/dembele.png",  "cartas/promes.png", "cartas/williams.png", "cartas/hernani.png",  "cartas/rafa.png", "cartas/james.png", "cartas/mane.png", "cartas/son.png");
				}
			}else if(posicion.equals("Extremos D.")) {
				ocultar2();
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					comprarJugadores("cartas/messi.png", "cartas/di maria.png", "cartas/mahrez.png", "cartas/adama.png", "cartas/joao felix.png", "cartas/gnabry.png", "cartas/rashford.png", "cartas/pizzi.png",  "cartas/rodrygo.png", "cartas/vardy.png", "cartas/werner.png",  "cartas/salah.png", "cartas/icardi.png", "cartas/ilicic.png", "cartas/griezmann.png");
				}
			}else if(posicion.equals("Delanteros")) {
				ocultar2();
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);				
					comprarJugadores("cartas/ibrahimovic.png", "cartas/haaland.png", "cartas/lewandowski.png", "cartas/mbappe.png", "cartas/peres.png", "cartas/aguero.png", "cartas/benzema.png", "cartas/suarez.png",  "cartas/ronaldo.png", "cartas/firmino.png", "cartas/lukaku.png",  "cartas/iago aspas.png", "cartas/martinez.png", "cartas/aubameyang.png", "cartas/kane.png");
				}
			}
			
			//funcionalidad cuando se pulse alguna de las cartas
			if(posicion.equals("Porteros")){
				ocultarCarta();
				sacarCarta(e, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, plantilla.aceptar, "cartas/oblak.png", "cartas/ter stegen.png", "cartas/alisson.png", "cartas/courtois.png", "cartas/neuer.png", "cartas/ederson.png", "cartas/handanovic.png", "cartas/navas.png", "cartas/szczesny.png", "cartas/lloris.png", "cartas/de gea.png",  "cartas/donnaruma.png", "cartas/leno.png", "cartas/gulasci.png", "cartas/sommer.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPRAR PORTEROS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
			}else if(posicion.equals("Centrales")){
				ocultarCarta();
				sacarCarta(e, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, plantilla.aceptar,"cartas/hummels.png", "cartas/de ligt.png", "cartas/laporte.png", "cartas/pique.png", "cartas/de vrij.png", "cartas/lenglet.png", "cartas/manolas.png", "cartas/coates.png",  "cartas/kounde.png", "cartas/skriniar.png", "cartas/nacho.png",  "cartas/upamecano.png", "cartas/koulibaly.png", "cartas/van dijk.png", "cartas/sergio ramos.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPRAR CENTRALES", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
			}else if(posicion.equals("Laterales I.")){
				ocultarCarta();
				sacarCarta(e, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, plantilla.aceptar,"cartas/davies.png", "cartas/acu??a.png", "cartas/juan bernat.png", "cartas/grimaldo.png", "cartas/jordi alba.png", "cartas/robertson.png", "cartas/digne.png", "cartas/spinazzola.png",  "cartas/telles.png", "cartas/sandro.png", "cartas/tagliafico.png", "cartas/marcelo.png", "cartas/guerreiro.png", "cartas/mendy.png", "cartas/gelson.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPRAR LATERALES IZQUIERDOS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
			}else if(posicion.equals("Laterales D.")){
				ocultarCarta();
				sacarCarta(e, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, plantilla.aceptar, "cartas/azpilicueta.png", "cartas/trippier.png", "cartas/jesus navas.png", "cartas/carvajal.png", "cartas/arnold.png", "cartas/cancelo.png", "cartas/wan-bissaka.png", "cartas/walker.png",  "cartas/cuadrado.png", "cartas/ricardo.png", "cartas/dest.png",  "cartas/kamara.png", "cartas/kimmich.png", "cartas/corona.png", "cartas/hakimi.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPRAR LATERALES DERECHOS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
			}else if(posicion.equals("Mediocentros")){
				ocultarCarta();
				sacarCarta(e, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, plantilla.aceptar, "cartas/de jong.png", "cartas/de bruyne.png", "cartas/thiago.png", "cartas/coutinho.png", "cartas/fabinho.png", "cartas/busquets.png", "cartas/muller.png", "cartas/ozil.png",  "cartas/gomez.png", "cartas/david silva.png", "cartas/reus.png",  "cartas/kante.png", "cartas/bruno.png", "cartas/luis alberto.png", "cartas/verratti.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPRAR MEDIOCENTROS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
			}else if(posicion.equals("Carrileros I.")){
				ocultarCarta();
				sacarCarta(e, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, plantilla.aceptar, "cartas/ziyech.png", "cartas/dybala.png", "cartas/pjanic.png", "cartas/vidal.png", "cartas/mertens.png", "cartas/eriksen.png", "cartas/witsel.png", "cartas/odegaard.png",  "cartas/partey.png", "cartas/nani.png", "cartas/isco.png",  "cartas/aranguiz.png", "cartas/parejo.png", "cartas/insigne.png", "cartas/sancho.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPRAR CARRILEROS IZQUIERDOS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));		
			}else if(posicion.equals("Carrileros D.")){
				ocultarCarta();
				sacarCarta(e, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, plantilla.aceptar, "cartas/sane.png", "cartas/brandt.png", "cartas/zakaria.png", "cartas/koke.png", "cartas/celso.png", "cartas/bernardo.png", "cartas/alli.png", "cartas/pereira.png",  "cartas/goretzka.png", "cartas/casemiro.png", "cartas/valverde.png",  "cartas/havertz.png", "cartas/immobile.png", "cartas/pogba.png", "cartas/moutinho.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPRAR CARRILEROS DERECHOS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));		
			}else if(posicion.equals("Extremos I.")){
				ocultarCarta();
				sacarCarta(e, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, plantilla.aceptar, "cartas/depay.png", "cartas/neymar.png", "cartas/hazard.png", "cartas/sterling.png", "cartas/oyarzabal.png", "cartas/coman.png", "cartas/callejon.png", "cartas/dembele.png",  "cartas/promes.png", "cartas/williams.png", "cartas/hernani.png",  "cartas/rafa.png", "cartas/james.png", "cartas/mane.png", "cartas/son.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPRAR EXTREMOS IZQUIERDOS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));		
			}else if(posicion.equals("Extremos D.")){
				ocultarCarta();
				sacarCarta(e, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, plantilla.aceptar, "cartas/messi.png", "cartas/di maria.png", "cartas/mahrez.png", "cartas/adama.png", "cartas/joao felix.png", "cartas/gnabry.png", "cartas/rashford.png", "cartas/pizzi.png",  "cartas/rodrygo.png", "cartas/vardy.png", "cartas/werner.png",  "cartas/salah.png", "cartas/icardi.png", "cartas/ilicic.png", "cartas/griezmann.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPRAR EXTREMOS DERECHOS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));		
			}else if(posicion.equals("Delanteros")){
				ocultarCarta();
				sacarCarta(e, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, plantilla.aceptar, "cartas/ibrahimovic.png", "cartas/haaland.png", "cartas/lewandowski.png", "cartas/mbappe.png", "cartas/peres.png", "cartas/aguero.png", "cartas/benzema.png", "cartas/suarez.png",  "cartas/ronaldo.png", "cartas/firmino.png", "cartas/lukaku.png",  "cartas/iago aspas.png", "cartas/martinez.png", "cartas/aubameyang.png", "cartas/kane.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "COMPRAR DELANTEROS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));		
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
					if(posicionCartaComprada.equals("POR")) { plantilla.porterosComboBox.addItem(nombre); }
					if(posicionCartaComprada.equals("DEF I")) { plantilla.centralesIComboBox.addItem(nombre); }
					if(posicionCartaComprada.equals("DEF D")) { plantilla.centralesDComboBox.addItem(nombre); }
					if(posicionCartaComprada.equals("LI")) { plantilla.lateralIComboBox.addItem(nombre); }
					if(posicionCartaComprada.equals("LD")) { plantilla.lateralDComboBox.addItem(nombre); }
					if(posicionCartaComprada.equals("MED")) { plantilla.mediosComboBox.addItem(nombre); }
					if(posicionCartaComprada.equals("MED D")) { plantilla.mediosDComboBox.addItem(nombre); }
					if(posicionCartaComprada.equals("MED I")) { plantilla.mediosIComboBox.addItem(nombre); }
					if(posicionCartaComprada.equals("CAR D")) { plantilla.carrileroDComboBox.addItem(nombre); }
					if(posicionCartaComprada.equals("CAR I")) { plantilla.carrileroIComboBox.addItem(nombre); }
					if(posicionCartaComprada.equals("EXT D")) { plantilla.extremosDCcomboBox.addItem(nombre); }
					if(posicionCartaComprada.equals("EXT I")) { plantilla.extremosICcomboBox.addItem(nombre); }
					if(posicionCartaComprada.equals("DEL I")) { plantilla.delanteroICcomboBox.addItem(nombre); }
					if(posicionCartaComprada.equals("DEL D")) { plantilla.delanteroDCcomboBox.addItem(nombre); }
					if(posicionCartaComprada.equals("DEL")) { plantilla.delanteroCcomboBox.addItem(nombre); }					
				}				
			}
			
			//poner jugador seleccionado en la plantilla y quitarlo en caso de venderlo (actualizacion de valoraci??n de plantilla autom??tica)
			int mediaPortero=ponerCartaIndividualIndividual(elegirPortero, plantilla.portero, "OBLAK", "TER STEGEN", "ALISSON", "COURTOIS", "NEUER", "EDERSON", "HANDANOVIC", "NAVAS", "SZCZESNY", "LLORIS", "DE GEA", "DONNARUMA", "LENO", "GULASCI", "SOMMER", "cartas/oblak.png", "cartas/ter stegen.png", "cartas/alisson.png", "cartas/courtois.png", "cartas/neuer.png", "cartas/ederson.png", "cartas/handanovic.png", "cartas/navas.png", "cartas/szczesny.png", "cartas/lloris.png", "cartas/de gea.png",  "cartas/donnaruma.png", "cartas/leno.png", "cartas/gulasci.png", "cartas/sommer.png", 91, 90, 90, 89, 89, 88, 88, 87, 87, 87, 86, 85, 85, 85, 86);
			quitarJugadorVendidoFormacion(plantilla.porterosComboBox, "PORTERO", plantilla.portero);
			int mediaLateralDerecho=ponerCartaIndividualIndividual(elegirlateralD, plantilla.lateralderecho_1, "AZPILICUETA", "TRIPPIER", "JESUS NAVAS", "CARVAJAL", "ARNOLD", "CANCELO", "WAN-BISSAKA", "WALKER", "CUADRADO", "RICARDO", "DEST", "KAMARA", "KIMMICH", "CORONA", "HAKIMI", "cartas/azpilicueta.png", "cartas/trippier.png", "cartas/jesus navas.png", "cartas/carvajal.png", "cartas/arnold.png", "cartas/cancelo.png", "cartas/wan-bissaka.png", "cartas/walker.png", "cartas/cuadrado.png", "cartas/ricardo.png", "cartas/dest.png",  "cartas/kamara.png", "cartas/kimmich.png", "cartas/corona.png", "cartas/hakimi.png", 83, 83, 84, 86 , 87, 83, 83, 85, 81, 85, 75, 77, 88, 81, 83);
			quitarJugadorVendidoFormacion(plantilla.lateralDComboBox, "LATERAL D.", plantilla.lateralderecho_1);
			int mediaLateralIzquierdo=ponerCartaIndividualIndividual(elegirLateralI, plantilla.lateralizquierdo_1, "DAVIES", "ACU??A", "JUAN BERNAT", "GRIMALDO", "JORDI ALBA", "ROBERTSON", "DIGNE", "SPINAZZOLA", "ALEX TELLES", "SANDRO", "TAGLIAFICO", "MARCELO", "GUERREIRO", "MENDY", "GELSON", "cartas/davies.png", "cartas/acu??a.png", "cartas/juan bernat.png", "cartas/grimaldo.png", "cartas/jordi alba.png", "cartas/robertson.png", "cartas/digne.png", "cartas/spinazzola.png", "cartas/telles.png", "cartas/sandro.png", "cartas/tagliafico.png", "cartas/marcelo.png", "cartas/guerreiro.png", "cartas/mendy.png", "cartas/gelson.png", 81, 83, 83, 84, 86, 87, 84, 82, 84, 85, 84, 83, 84, 83, 82);
			quitarJugadorVendidoFormacion(plantilla.lateralIComboBox, "LATERAL I.", plantilla.lateralizquierdo_1);
			int mediaCentral1_1=ponerCartaIndividualIndividual(elegirCentralI, plantilla.central1_1,"DE LIGT", "PIQUE", "LENGLET", "COATES", "SKRINIAR", "UPAMECANO", "VAN DIJK","","","","","","","","", "cartas/de ligt.png", "cartas/pique.png",  "cartas/lenglet.png", "cartas/coates.png", "cartas/skriniar.png", "cartas/upamecano.png", "cartas/van dijk.png","","","","","","","","", 85, 86, 85, 81, 85, 79, 90, 0,0,0,0,0,0,0,0);
			quitarJugadorVendidoFormacion(plantilla.centralesIComboBox, "CENTRAL I.", plantilla.central1_1);
			int mediaCentral2_1=ponerCartaIndividualIndividual(elegirCentralD, plantilla.central2_1, "HUMMELS", "LAPORTE", "DE VRIJ", "MANOLAS", "KOUNDE", "NACHO", "KOULIBALY", "SERGIO RAMOS","","","","","","","", "cartas/hummels.png", "cartas/laporte.png", "cartas/de vrij.png", "cartas/manolas.png", "cartas/kounde.png", "cartas/nacho.png", "cartas/koulibaly.png", "cartas/sergio ramos.png", "","","","","","","", 86, 87, 84, 83, 79, 80, 88, 89, 0,0,0,0,0,0,0);
			quitarJugadorVendidoFormacion(plantilla.centralesDComboBox, "CENTRAL D.", plantilla.central2_1);
			int mediaCentral1_3=ponerCartaIndividualIndividual(elegirCentralI, plantilla.central1_3,"DE LIGT", "PIQUE", "LENGLET", "COATES", "SKRINIAR", "UPAMECANO", "VAN DIJK","","","","","","","","", "cartas/de ligt.png", "cartas/pique.png",  "cartas/lenglet.png", "cartas/coates.png", "cartas/skriniar.png", "cartas/upamecano.png", "cartas/van dijk.png","","","","","","","","", 85, 86, 85, 81, 85, 79, 90, 0,0,0,0,0,0,0,0);
			quitarJugadorVendidoFormacion(plantilla.centralesIComboBox, "CENTRAL I.", plantilla.central1_3);
			int mediaCentral3_3=ponerCartaIndividualIndividual(elegirCentralD, plantilla.central3_3, "HUMMELS", "LAPORTE", "DE VRIJ", "MANOLAS", "KOUNDE", "NACHO", "KOULIBALY", "SERGIO RAMOS","","","","","","","", "cartas/hummels.png", "cartas/laporte.png", "cartas/de vrij.png", "cartas/manolas.png", "cartas/kounde.png", "cartas/nacho.png", "cartas/koulibaly.png", "cartas/sergio ramos.png", "","","","","","","", 86, 87, 84, 83, 79, 80, 88, 89, 0,0,0,0,0,0,0);			
			quitarJugadorVendidoFormacion(plantilla.centralesDComboBox, "CENTRAL D.", plantilla.central3_3);
			int media1_1=ponerCartaIndividualIndividual(elegirmedioI, plantilla.medio1_1, "THIAGO", "COUTINHO", "FABINHO", "REUS", "VERRATI", "", "", "","","","","","","","", "cartas/thiago.png", "cartas/coutinho.png", "cartas/fabinho.png", "cartas/reus.png", "cartas/verrati.png", "", "", "", "","","","","","","", 85, 83, 87, 85, 86, 0, 0, 0, 0,0,0,0,0,0,0);			
			quitarJugadorVendidoFormacion(plantilla.mediosIComboBox, "MEDIO I.", plantilla.medio1_1);
			int media2_2=ponerCartaIndividualIndividual(elegirmedioI, plantilla.medio2_2, "THIAGO", "COUTINHO", "FABINHO", "REUS", "VERRATI", "", "", "","","","","","","","", "cartas/thiago.png", "cartas/coutinho.png", "cartas/fabinho.png", "cartas/reus.png", "cartas/verrati.png", "", "", "", "","","","","","","", 85, 83, 87, 85, 86, 0, 0, 0, 0,0,0,0,0,0,0);			
			quitarJugadorVendidoFormacion(plantilla.mediosIComboBox, "MEDIO I.", plantilla.medio2_2);
			int media3_2=ponerCartaIndividualIndividual(elegirmedioD, plantilla.medio3_2, "DE JONG", "BUSQUETS", "OZIL", "GOMEZ", "BRUNO", "", "", "","","","","","","","", "cartas/de jong.png", "cartas/busquets.png", "cartas/ozil.png", "cartas/gomez.png", "cartas/bruno.png", "", "", "", "","","","","","","", 85, 87, 82, 86, 87, 0, 0, 0, 0,0,0,0,0,0,0);			
			quitarJugadorVendidoFormacion(plantilla.mediosDComboBox, "MEDIO D.", plantilla.medio3_2);
			int media3_1=ponerCartaIndividualIndividual(elegirmedioD, plantilla.medio3_1, "DE JONG", "BUSQUETS", "OZIL", "GOMEZ", "BRUNO", "", "", "","","","","","","","", "cartas/de jong.png", "cartas/busquets.png", "cartas/ozil.png", "cartas/gomez.png", "cartas/bruno.png", "", "", "", "","","","","","","", 85, 87, 82, 86, 87, 0, 0, 0, 0,0,0,0,0,0,0);			
			quitarJugadorVendidoFormacion(plantilla.mediosDComboBox, "MEDIO D.", plantilla.medio3_1);
			int media2_1=ponerCartaIndividualIndividual(elegirmedio, plantilla.medio2_1, "DE BRUYNE", "MULLER", "DAVID SILVA", "KANTE", "LUIS ALBERTO", "", "", "","","","","","","","", "cartas/de bruyne.png", "cartas/muller.png", "cartas/david silva.png", "cartas/kante.png", "cartas/luis alberto.png", "", "", "", "","","","","","","", 91, 86, 86, 88, 85, 0, 0, 0, 0,0,0,0,0,0,0);			
			quitarJugadorVendidoFormacion(plantilla.mediosComboBox, "MEDIO", plantilla.medio2_1);
			int media1_2=ponerCartaIndividualIndividual(elegircarrileroI, plantilla.medio1_2, "ZIYECH", "DYBALA", "PJANIC", "VIDAL", "MERTENS", "ERIKSEN", "WITSEL", "ODEGAARD","PARTEY","NANI","ISCO","ARANGUIZ","PAREJO","INSIGNE","SANCHO", "cartas/ziyech.png", "cartas/dybala.png", "cartas/pjanic.png", "cartas/vidal.png", "cartas/mertens.png", "cartas/eriksen.png", "cartas/witsel.png", "cartas/odegaard.png",  "cartas/partey.png", "cartas/nani.png", "cartas/isco.png",  "cartas/aranguiz.png", "cartas/parejo.png", "cartas/insigne.png", "cartas/sancho.png", 85, 88, 85, 84, 85, 85, 84, 83, 82, 80, 84, 83, 85, 85, 87);			
			quitarJugadorVendidoFormacion(plantilla.carrileroIComboBox, "CARRILERO I.", plantilla.medio1_2);
			int media4_2=ponerCartaIndividualIndividual(elegircarrileroD, plantilla.medio4_2, "SANE", "BRANDT", "ZAKARIA", "KOKE", "CELSO", "BERNARDO", "ALLI", "PEREIRA", "GORETZKA", "CASEMIRO", "VALVERDE", "HAVERTZ", "IMMOBILE", "POGBA", "MOUTINHO", "cartas/sane.png", "cartas/brandt.png", "cartas/zakaria.png", "cartas/koke.png", "cartas/celso.png", "cartas/bernardo.png", "cartas/alli.png", "cartas/pereira.png",  "cartas/goretzka.png", "cartas/casemiro.png", "cartas/valverde.png",  "cartas/havertz.png", "cartas/immobile.png", "cartas/pogba.png", "cartas/moutinho.png", 85, 88, 85, 84, 82, 85, 84, 83, 82, 80, 84, 83, 85, 85, 87);	
			quitarJugadorVendidoFormacion(plantilla.carrileroDComboBox, "CARRILERO D.", plantilla.medio4_2);
			int extremoizquierdo_1=ponerCartaIndividualIndividual(elegirextremoI, plantilla.extremoizquierdo_1, "DEPAY", "NEYMAR", "HAZARD", "STERLING", "OYARZABAL", "COMAN", "CALLEJON", "DEMBELE", "PROMES", "WILLIAMS" ,"HERNANI", "RAFA", "JAMES", "MANE", "SON", "cartas/depay.png", "cartas/neymar.png", "cartas/hazard.png", "cartas/sterling.png", "cartas/oyarzabal.png", "cartas/coman.png", "cartas/callejon.png", "cartas/dembele.png",  "cartas/promes.png", "cartas/williams.png", "cartas/hernani.png",  "cartas/rafa.png", "cartas/james.png", "cartas/mane.png", "cartas/son.png", 85, 91, 88, 88, 84, 84, 84, 83, 82, 81, 76, 83, 77, 90, 87);			
			quitarJugadorVendidoFormacion(plantilla.extremosICcomboBox, "EXTREMO I.", plantilla.extremoizquierdo_1);
			int extremoderecho_1=ponerCartaIndividualIndividual(elegirextremoD, plantilla.extremoderecho_1, "MESSI", "DI MARIA", "MAHREZ", "ADAMA", "JOAO FELIX", "GNABRY", "RASHFORD", "PIZZI", "RODRYGO", "VARDY" ,"WERNER", "SALAH", "ICARDI", "ILICIC", "GRIEZMANN", "cartas/messi.png", "cartas/di maria.png", "cartas/mahrez.png", "cartas/adama.png", "cartas/joao felix.png", "cartas/gnabry.png", "cartas/rashford.png", "cartas/pizzi.png",  "cartas/rodrygo.png", "cartas/vardy.png", "cartas/werner.png",  "cartas/salah.png", "cartas/icardi.png", "cartas/ilicic.png", "cartas/griezmann.png", 93, 87, 85, 79, 81, 85, 85, 84, 79, 86, 85, 90, 85, 84, 87);			
			quitarJugadorVendidoFormacion(plantilla.extremosDCcomboBox, "EXTREMO D.", plantilla.extremoderecho_1);
			int delantero1_2=ponerCartaIndividualIndividual(elegirdelanteroI, plantilla.delantero1_2, "IBRAHIMOVIC", "MBAPPE", "BENZEMA", "FIRMINO", "MARTINEZ", "", "", "", "", "" ,"", "", "", "", "", "cartas/ibrahimovic.png", "cartas/mbappe.png", "cartas/benzema.png", "cartas/firmino.png", "cartas/martinez.png", "", "", "",  "", "", "",  "", "", "", "", 83, 90, 89, 87, 84, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);			
			quitarJugadorVendidoFormacion(plantilla.delanteroICcomboBox, "DELANTERO I.", plantilla.delantero1_2);
			int delantero2_2=ponerCartaIndividualIndividual(elegirdelanteroD, plantilla.delantero2_2, "LEWANDOWSKI", "AGUERO", "RONALDO", "IAGO ASPAS", "KANE", "", "", "", "", "" ,"", "", "", "", "", "cartas/lewandowski.png", "cartas/aguero.png", "cartas/ronaldo.png", "cartas/iago aspas.png", "cartas/kane.png", "", "", "",  "", "", "",  "", "", "", "", 91, 89, 92, 84, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);			
			quitarJugadorVendidoFormacion(plantilla.delanteroDCcomboBox, "DELANTERO D.", plantilla.delantero2_2);
			int delantero_1=ponerCartaIndividualIndividual(elegirdelantero, plantilla.delantero_1, "HAALAND", "PERES", "SUAREZ", "LUKAKU", "AUBAMEYANG", "", "", "", "", "" ,"", "", "", "", "", "cartas/haaland.png", "cartas/peres.png", "cartas/suarez.png", "cartas/lukaku.png", "cartas/aubameyang.png", "", "", "",  "", "", "",  "", "", "", "", 84, 77, 87, 85, 87, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);			
			quitarJugadorVendidoFormacion(plantilla.delanteroCcomboBox, "DELANTERO", plantilla.delantero_1);
			
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
				plantilla.info.setVisible(true);
				plantilla.info2.setVisible(true);
				String posicioon="";
				if(pos.equals("POR")) {posicioon="PORTERO"; }
				if(pos.equals("DEF D")) {posicioon="CENTRAL D."; }
				if(pos.equals("DEF I")) {posicioon="CENTRAL I."; } 
				if(pos.equals("LI")) {posicioon="LATERAL I."; }
				if(pos.equals("LD")) {posicioon="LATERAL D."; }
				if(pos.equals("MED")) {posicioon="MEDIO"; }
				if(pos.equals("MED I")) {posicioon="MEDIO I."; }
				if(pos.equals("MED D")) {posicioon="MEDIO D."; }
				if(pos.equals("CAR I")) {posicioon="CARRILERO I."; }
				if(pos.equals("CAR D")) {posicioon="CARRILERO D."; }
				if(pos.equals("EXT D")) {posicioon="EXTREMO D."; }
				if(pos.equals("EXT I")) {posicioon="EXTREMO I."; }
				if(pos.equals("DEL I")) {posicioon="DELANTERO I."; }
				if(pos.equals("DEL D")) {posicioon="DELANTERO D."; }
				if(pos.equals("DEL")) {posicioon="DELANTERO"; }
				plantilla.info.setText(carta.getNombreCartaComprada()+"\n\n"+posicioon+"\n\n"+carta.getPaisCartaComprada()+"\n\n"+carta.getEquipoCartaComprada()+"\n\n"+carta.getLigaCartaComprada()+"\n\n"+carta.getMediaCartaComprada());
				plantilla.info2.setText("NOMBRE: \n\nPOSICION: \n\nPAIS: \n\nEQUIPO: \n\nLIGA: \n\nMEDIA: ");
				if(e.getSource()==plantilla.cancelarvender) {
					plantilla.venderJugadores.setSelectedIndex(0);
					ocultarVender(false);
				}else if(e.getSource()==plantilla.aceptarvender) {
					ocultarVender(false);
					plantilla.venderJugadores.removeItem(decidirVender);
					plantilla.venderJugadores.setSelectedIndex(0);
					mediaPortero=vender(carta, pos, precioFinal, decidirVender, mediaPortero, "POR", plantilla.porterosComboBox);
					mediaLateralDerecho=vender(carta, pos, precioFinal, decidirVender, mediaLateralDerecho, "LD", plantilla.lateralDComboBox);
					mediaLateralIzquierdo=vender(carta, pos, precioFinal, decidirVender, mediaLateralIzquierdo, "LI", plantilla.lateralIComboBox);
					mediaCentral1_1=vender(carta, pos, precioFinal, decidirVender, mediaCentral1_1, "DEF D", plantilla.centralesDComboBox);
					mediaCentral1_3=vender(carta, pos, precioFinal, decidirVender, mediaCentral1_3, "DEF D", plantilla.centralesDComboBox);
					mediaCentral2_1=vender(carta, pos, precioFinal, decidirVender, mediaCentral2_1, "DEF I", plantilla.centralesIComboBox);
					mediaCentral3_3=vender(carta, pos, precioFinal, decidirVender, mediaCentral3_3, "DEF I", plantilla.centralesIComboBox);
					media1_1=vender(carta, pos, precioFinal, decidirVender, media1_1, "MED I", plantilla.mediosIComboBox);
					media2_2=vender(carta, pos, precioFinal, decidirVender, media2_2, "MED I", plantilla.mediosIComboBox);
					media3_1=vender(carta, pos, precioFinal, decidirVender, media3_1, "MED D", plantilla.mediosDComboBox);
					media3_2=vender(carta, pos, precioFinal, decidirVender, media3_2, "MED D", plantilla.mediosDComboBox);
					media2_1=vender(carta, pos, precioFinal, decidirVender, media2_1, "MED", plantilla.mediosComboBox);
					media1_2=vender(carta, pos, precioFinal, decidirVender, media1_2, "CAR I", plantilla.carrileroIComboBox);
					media4_2=vender(carta, pos, precioFinal, decidirVender, media4_2, "CAR D", plantilla.carrileroDComboBox);
					extremoizquierdo_1=vender(carta, pos, precioFinal, decidirVender, extremoizquierdo_1, "EXT I", plantilla.extremosICcomboBox);
					extremoderecho_1=vender(carta, pos, precioFinal, decidirVender, extremoizquierdo_1, "EXT D", plantilla.extremosDCcomboBox);
					delantero1_2=vender(carta, pos, precioFinal, decidirVender, delantero1_2, "DEL I", plantilla.delanteroICcomboBox);
					delantero2_2=vender(carta, pos, precioFinal, decidirVender, delantero2_2, "DEL D", plantilla.delanteroDCcomboBox);
					delantero_1=vender(carta, pos, precioFinal, decidirVender, delantero_1, "DEL", plantilla.delanteroCcomboBox);
					JOptionPane.showMessageDialog(null, "HAS VENDIDO A "+carta.getNombreCartaComprada(),"VENDER CARTA", JOptionPane.INFORMATION_MESSAGE);
					plantilla.registro.setText(plantilla.registro.getText()+"Has Vendido a "+carta.getNombreCartaComprada()+"\n");
				}
			}else if(plantilla.venderJugadores.getSelectedIndex()==0) {
				ocultarVender(false);
			}
					
			//funcionalidad cuando se coloca el jugador elegido del ComboBox en la formacion
			if(decidirFormacion.equals(" 4 - 3 - 3")) {
				plantilla.portero.setVisible(true); plantilla.central1_1.setVisible(true); plantilla.central2_1.setVisible(true); plantilla.medio1_1.setVisible(true); plantilla.medio2_1.setVisible(true); plantilla.medio3_1.setVisible(true); plantilla.extremoderecho_1.setVisible(true); plantilla.extremoizquierdo_1.setVisible(true); plantilla.delantero_1.setVisible(true); plantilla.lateralderecho_1.setVisible(true); plantilla.lateralizquierdo_1.setVisible(true); plantilla.puntos.setVisible(true);
				plantilla.medio1_2.setVisible(false); plantilla.medio2_2.setVisible(false); plantilla.medio3_2.setVisible(false); plantilla.medio4_2.setVisible(false); plantilla.delantero1_2.setVisible(false); plantilla.delantero2_2.setVisible(false); plantilla.central1_3.setVisible(false); plantilla.central3_3.setVisible(false); 	
				int media=(mediaPortero+mediaLateralDerecho+mediaLateralIzquierdo+mediaCentral1_1+mediaCentral2_1+media1_1+media3_1+media2_1+extremoizquierdo_1+extremoderecho_1+delantero_1)/11;
					String mediaa=String.valueOf(media);
					modificarPuntos(comparar, media, mediaa);
			}else if(decidirFormacion.equals(" 4 - 4 - 2")) {
				plantilla.portero.setVisible(true); plantilla.central1_1.setVisible(true); plantilla.central2_1.setVisible(true);plantilla.lateralderecho_1.setVisible(true); plantilla.lateralizquierdo_1.setVisible(true);plantilla.medio1_2.setVisible(true); plantilla.medio2_2.setVisible(true); plantilla.medio3_2.setVisible(true); plantilla.medio4_2.setVisible(true); plantilla.delantero1_2.setVisible(true); plantilla.delantero2_2.setVisible(true); plantilla.puntos.setVisible(true);
				plantilla.medio1_1.setVisible(false); plantilla.medio2_1.setVisible(false); plantilla.medio3_1.setVisible(false); plantilla.extremoderecho_1.setVisible(false); plantilla.extremoizquierdo_1.setVisible(false); plantilla.delantero_1.setVisible(false); plantilla.central1_3.setVisible(false); plantilla.central3_3.setVisible(false); 
				int media=(mediaPortero+mediaLateralDerecho+mediaLateralIzquierdo+mediaCentral1_1+mediaCentral2_1+media2_2+media3_2+media1_2+media4_2+delantero1_2+delantero2_2)/11;
					String mediaa=String.valueOf(media);
					modificarPuntos(comparar, media, mediaa);
			}else if(decidirFormacion.equals(" 2 - 4 - 4")) {
				plantilla.portero.setVisible(true); plantilla.central1_3.setVisible(true); plantilla.central3_3.setVisible(true); plantilla.medio1_2.setVisible(true); plantilla.medio2_2.setVisible(true); plantilla.medio3_2.setVisible(true); plantilla.medio4_2.setVisible(true); plantilla.extremoderecho_1.setVisible(true); plantilla.extremoizquierdo_1.setVisible(true); plantilla.delantero1_2.setVisible(true); plantilla.delantero2_2.setVisible(true); plantilla.puntos.setVisible(true);
				plantilla.medio1_1.setVisible(false); plantilla.medio2_1.setVisible(false); plantilla.medio3_1.setVisible(false); plantilla.delantero_1.setVisible(false); plantilla.central1_1.setVisible(false); plantilla.central2_1.setVisible(false); plantilla.lateralderecho_1.setVisible(false); plantilla.lateralizquierdo_1.setVisible(false);  
				int media=(mediaPortero+mediaCentral1_3+mediaCentral3_3+media2_2+media3_2+media1_2+media4_2+extremoizquierdo_1+extremoderecho_1+delantero1_2+delantero2_2)/11;
				 	String mediaa=String.valueOf(media);
					modificarPuntos(comparar, media, mediaa);
			}else if(decidirFormacion.equals(" 4 - 2 - 4")) {
				plantilla.portero.setVisible(true); plantilla.central1_1.setVisible(true); plantilla.central2_1.setVisible(true);  plantilla.extremoderecho_1.setVisible(true); plantilla.extremoizquierdo_1.setVisible(true); plantilla.delantero1_2.setVisible(true); plantilla.delantero2_2.setVisible(true); plantilla.lateralderecho_1.setVisible(true); plantilla.lateralizquierdo_1.setVisible(true); plantilla.medio2_2.setVisible(true); plantilla.medio3_2.setVisible(true); plantilla.puntos.setVisible(true);
				plantilla.medio2_1.setVisible(false); plantilla.delantero_1.setVisible(false); plantilla.central3_3.setVisible(false); plantilla.medio1_2.setVisible(false); plantilla.medio1_1.setVisible(false); plantilla.medio3_1.setVisible(false); plantilla.medio4_2.setVisible(false); plantilla.central1_3.setVisible(false); 
				int media=(mediaPortero+mediaLateralDerecho+mediaLateralIzquierdo+mediaCentral1_1+mediaCentral2_1+media2_2+media3_2+extremoizquierdo_1+extremoderecho_1+delantero1_2+delantero2_2)/11;
					String mediaa=String.valueOf(media);
					modificarPuntos(comparar, media, mediaa);
			}else if(decidirFormacion.equals("Elige Formacion")) {
				plantilla.portero.setVisible(false); plantilla.central1_1.setVisible(false); plantilla.central2_1.setVisible(false);  plantilla.extremoderecho_1.setVisible(false); plantilla.extremoizquierdo_1.setVisible(false); plantilla.delantero1_2.setVisible(false); plantilla.delantero2_2.setVisible(false); plantilla.lateralderecho_1.setVisible(false); plantilla.lateralizquierdo_1.setVisible(false); plantilla.medio2_2.setVisible(false); plantilla.medio3_2.setVisible(false); plantilla.puntos.setVisible(false);
				plantilla.medio2_1.setVisible(false); plantilla.delantero_1.setVisible(false); plantilla.central3_3.setVisible(false); plantilla.medio1_2.setVisible(false); plantilla.medio1_1.setVisible(false); plantilla.medio3_1.setVisible(false); plantilla.medio4_2.setVisible(false); plantilla.central1_3.setVisible(false); 
			}

			//mostrar el comboBox necesario al pulsar la posicion para elegir la carta
			if(e.getSource()==plantilla.portero) { ocultarComboBox(true, false, false, false, false, false, false, false, false, false, false, false, false, false, false); }
			if((e.getSource()==plantilla.central1_1)||(e.getSource()==plantilla.central1_3)) { ocultarComboBox(false, false, false, false, true, false, false, false, false, false, false, false, false, false, false); }
			if((e.getSource()==plantilla.central2_1)||(e.getSource()==plantilla.central3_3)) { ocultarComboBox(false, true, false, false, false, false, false, false, false, false, false, false, false, false, false); }
			if(e.getSource()==plantilla.lateralizquierdo_1) { ocultarComboBox(false, false, false, true, false, false, false, false, false, false, false, false, false, false, false); }
			if(e.getSource()==plantilla.lateralderecho_1) { ocultarComboBox(false, false, true, false, false, false, false, false, false, false, false, false, false, false, false); }
			if((e.getSource()==plantilla.medio1_1)||(e.getSource()==plantilla.medio2_2)) { ocultarComboBox(false, false, false, false, false, false, false, true, false, false, false, false, false, false, false); }
			if((e.getSource()==plantilla.medio3_2)||(e.getSource()==plantilla.medio3_1)) { ocultarComboBox(false, false, false, false, false, false, true, false, false, false, false, false, false, false, false); }
			if(e.getSource()==plantilla.medio2_1) { ocultarComboBox(false, false, false, false, false, true, false, false, false, false, false, false, false, false, false); }
			if(e.getSource()==plantilla.medio1_2) { ocultarComboBox(false, false, false, false, false, false, false, false, true, false, false, false, false, false, false); }
			if(e.getSource()==plantilla.medio4_2) { ocultarComboBox(false, false, false, false, false, false, false, false, false, true, false, false, false, false, false); }
			if(e.getSource()==plantilla.extremoizquierdo_1) { ocultarComboBox(false, false, false, false, false, false, false, false, false, false, false, true, false, false, false); }
			if(e.getSource()==plantilla.extremoderecho_1) { ocultarComboBox(false, false, false, false, false, false, false, false, false, false, true, false, false, false, false); }
			if(e.getSource()==plantilla.delantero1_2) { ocultarComboBox(false, false, false, false, false, false, false, false, false, false, false, false, false, true, false); }
			if(e.getSource()==plantilla.delantero2_2) { ocultarComboBox(false, false, false, false, false, false, false, false, false, false, false, false, false, false, true); }
			if(e.getSource()==plantilla.delantero_1) { ocultarComboBox(false, false, false, false, false, false, false, false, false, false, false, false, true, false, false); }
			
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
					plantilla.panelPartidos.setVisible(true);
					plantilla.panelranking.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "RANKING - ("+siglas+")", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));					
					listarRanking();					
				}
			}

			//funcionalidad si se pulsa el icono del panel de Ranking
			if(e.getSource()==plantilla.recarga) {
				listar.removeAll(listar);
				plantilla.listar.setText("");
				listarRanking();
			}
			
			//funcionalidad si se pulsa el icono del panel de Partidos Online
			if(e.getSource()==plantilla.vs) {
				int dinero=Integer.parseInt(plantilla.dinero.getText());
				String nombreSiglas=plantilla.siglas.getText();
				char[] myChars = nombreSiglas.toCharArray();
				char chhar1=0, chhar2=0, chhar3=0;
				for (int i=0; i<myChars.length; i++){
					chhar1=myChars[0];
					chhar2=myChars[1];
					chhar3=myChars[2];
				}
				if(dinero<3000) {
					JOptionPane.showMessageDialog(null, "DEBES DE TENER M??S DE 3000 $","DINERO INSUFICIENTE", JOptionPane.ERROR_MESSAGE);
				}else {
					int siglasOtro=(int)(Math.random()*listar.size());
					if((listar.get(siglasOtro).getSigla1()!=chhar1)&&(listar.get(siglasOtro).getSigla2()!=chhar2)&&(listar.get(siglasOtro).getSigla3()!=chhar3)) {
						jugarPartido(dinero, siglasOtro);
					}else {
						siglasOtro=(int)(Math.random()*listar.size());
						jugarPartido(dinero, siglasOtro);
					}					
				}
			}
						
		} catch (Exception e3) { e3.printStackTrace(); 
		} finally { if(sessionFactory != null) { sessionFactory.close(); } }	
	}

	private void modificarPuntos(int comparar, int media, String mediaa) {
		if(comparar<media) {
			asociarImagen2("verde.png", plantilla.flecha);
			plantilla.puntos.setText(mediaa);
		}else if(comparar>media){
			asociarImagen2("rojo.png", plantilla.flecha);
			plantilla.puntos.setText(mediaa);
		}
	}

	//meter los escucos en un array
	private void escudos() {
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
	}

	//enfrentarte a otros jugadores del ranking y para ganarles debes de tener m??s puntos que ellos
	private void jugarPartido(int dinero, int siglasOtro) {
		plantilla.yo.setVisible(true); 
		plantilla.versus.setVisible(true);
		plantilla.otro.setVisible(true);
		plantilla.miSigla.setVisible(true);
		int entero=Integer.parseInt(plantilla.puntos.getText());
		plantilla.miSigla.setText(plantilla.siglas.getText()+" ("+entero+")");
		int otro=(int)(Math.random()*escudos.size());
		asociarImagen2(escudos.get(otro), plantilla.otro);
		plantilla.siglasotro.setText(listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" ("+listar.get(siglasOtro).getNumero()+")");
		if(listar.get(siglasOtro).getNumero()>entero) {
			int resta=dinero-3000;
			String dineroFinal=String.valueOf(resta);
			plantilla.dinero.setText(dineroFinal);
			plantilla.registro.setText(plantilla.registro.getText()+"Has Perdido contra "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+"\n");
			asociarImagen2("perder.jpg", plantilla.emoticono);
			plantilla.partidoPerdido.setVisible(true); plantilla.partidoGanado.setVisible(false);
			JOptionPane.showMessageDialog(null, "HAS PERDIDO CONTRA "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" (-3000 $)\n           "+plantilla.siglas.getText()+" ("+entero+")     VS     "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" ("+listar.get(siglasOtro).getNumero()+")","PARTIDO PERDIDO", JOptionPane.ERROR_MESSAGE);
		}else if(listar.get(siglasOtro).getNumero()<entero){
			int resta=dinero+5000;
			String dineroFinal=String.valueOf(resta);
			plantilla.dinero.setText(dineroFinal);
			plantilla.registro.setText(plantilla.registro.getText()+"Has Ganado contra "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+"\n");
			asociarImagen2("ganar.png", plantilla.emoticono);
			plantilla.partidoPerdido.setVisible(false); plantilla.partidoGanado.setVisible(true);
			JOptionPane.showMessageDialog(null, "HAS GANADO CONTRA "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" (+5000 $)\n           "+plantilla.siglas.getText()+" ("+entero+")     VS     "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" ("+listar.get(siglasOtro).getNumero()+")","PARTIDO GANADO", JOptionPane.INFORMATION_MESSAGE);
		}else if(listar.get(siglasOtro).getNumero()==entero){
			int prorroga=(int)(Math.random()*10);
			if(prorroga>5) {
				int resta=dinero-3000;
				String dineroFinal=String.valueOf(resta);
				plantilla.dinero.setText(dineroFinal);
				plantilla.registro.setText(plantilla.registro.getText()+"Has Perdido contra "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+"\n");
				asociarImagen2("perder.jpg", plantilla.emoticono);
				plantilla.partidoPerdido.setVisible(true); plantilla.partidoGanado.setVisible(false);
				JOptionPane.showMessageDialog(null, "HAS PERDIDO CONTRA "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" EN LA PR??RROGA (-3000 $)\n                         "+plantilla.siglas.getText()+" ("+entero+")     VS     "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" ("+listar.get(siglasOtro).getNumero()+")","PARTIDO PERDIDO", JOptionPane.ERROR_MESSAGE);
			}else if(prorroga<=5) {					     
				int resta=dinero+5000;
				String dineroFinal=String.valueOf(resta);
				plantilla.dinero.setText(dineroFinal);
				plantilla.registro.setText(plantilla.registro.getText()+"Has Ganado contra "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+"\n");
				asociarImagen2("ganar.png", plantilla.emoticono);
				plantilla.partidoPerdido.setVisible(false); plantilla.partidoGanado.setVisible(true);
				JOptionPane.showMessageDialog(null, "HAS GANADO CONTRA "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+"  EN LA PR??RROGA (+5000 $)\n                        "+plantilla.siglas.getText()+" ("+entero+")     VS     "+listar.get(siglasOtro).getSigla1()+""+listar.get(siglasOtro).getSigla2()+""+listar.get(siglasOtro).getSigla3()+" ("+listar.get(siglasOtro).getNumero()+")","PARTIDO GANADO", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void listarRanking() {
		ArrayList<MODELO.Plantilla>listaUsuarios=modelo.listarUsuario(sessionFactory);
		//crear nombres aleatorios de los dem??s jugadores
		Ranking r=null;
		Ranking r2=null;
		String setOfCharacters = "ABCDEFGHIJKLMN??OPQRSTUVWXYZabcdefghijklmn??opqrstuvwxyz";
		Random random = new Random();
		for(int i=0; i<7; i++) {
			int randomInt1 = random.nextInt(setOfCharacters.length());
			char randomChar1 = setOfCharacters.charAt(randomInt1);
			int randomInt2 = random.nextInt(setOfCharacters.length());
			char randomChar2 = setOfCharacters.charAt(randomInt2);
			int randomInt3 = random.nextInt(setOfCharacters.length());
			int aleatorio=(int) (Math.random()*((101-0))+0);
			char randomChar3 = setOfCharacters.charAt(randomInt3);
			r=new Ranking(randomChar1, randomChar2, randomChar3, aleatorio);
			listar.add(r);		
		}	
		for(int j=0; j<listaUsuarios.size(); j++) {
			String nombreSiglas=listaUsuarios.get(j).getNombrePlantilla();
			char[] myChars = nombreSiglas.toCharArray();
			char chhar1=myChars[0];
			char chhar2=myChars[1];
			char chhar3=myChars[2];
			r2=new Ranking(chhar1, chhar2, chhar3, listaUsuarios.get(j).getPuntosPlantilla());
			listar.add(r2);
		}
		//incluirme en el ranking
		Ranking r3=null;
		String nombreSiglas=plantilla.siglas.getText()+"*";
		char[] myChars = nombreSiglas.toCharArray();
		char chhar1=myChars[0];
		char chhar2=myChars[1];
		char chhar3=myChars[2];
		char chhar4=myChars[3];
		int entero=Integer.parseInt(plantilla.puntos.getText());
		r3=new Ranking(chhar1, chhar2, chhar3, chhar4, entero);
		listar.add(r3);
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
			if(i1!=listar.size()) {
				plantilla.listar.setText(plantilla.listar.getText()+(i+1)+"??-"+listar.get(i).toString()+"\n");
			}else {
				plantilla.listar.setText(plantilla.listar.getText()+listar.size()+"??-"+listar.get(i).toString());
			}		
			if((listar.get(i).getSigla1()==chhar1)&&(listar.get(i).getSigla2()==chhar2)&&(listar.get(i).getSigla3()==chhar3)) {
				String mp=String.valueOf(i1);
				plantilla.miPosicion.setText(mp+"??");	
			}
		}
	}
	
	//vender carta seleccionada y borrar de la BBDD
	@SuppressWarnings("rawtypes")
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
	private void ocultarComboBox(Boolean uno, Boolean dos, Boolean tres, Boolean cuatro, Boolean cinco, Boolean seis, Boolean siete, Boolean ocho, Boolean nueve, Boolean diez, Boolean once, Boolean doce, Boolean trece, Boolean catorce, Boolean quince) {
		plantilla.porterosComboBox.setVisible(uno);
		plantilla.centralesDComboBox.setVisible(dos);	
		plantilla.lateralDComboBox.setVisible(tres);
		plantilla.lateralIComboBox.setVisible(cuatro);	
		plantilla.centralesIComboBox.setVisible(cinco);
		plantilla.mediosComboBox.setVisible(seis);
		plantilla.mediosDComboBox.setVisible(siete);
		plantilla.mediosIComboBox.setVisible(ocho);
		plantilla.carrileroIComboBox.setVisible(nueve);
		plantilla.carrileroDComboBox.setVisible(diez);
		plantilla.extremosDCcomboBox.setVisible(once);
		plantilla.extremosICcomboBox.setVisible(doce);
		plantilla.delanteroCcomboBox.setVisible(trece);
		plantilla.delanteroICcomboBox.setVisible(catorce);
		plantilla.delanteroDCcomboBox.setVisible(quince);
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
	
	private void ocultarCarta() {
		plantilla.nombre.setVisible(false); plantilla.pais.setVisible(false); plantilla.media.setVisible(false); plantilla.equipo.setVisible(false); plantilla.posicion.setVisible(false);
		plantilla.nombree.setVisible(false); plantilla.paiis.setVisible(false); plantilla.puntoos.setVisible(false); plantilla.equipoo.setVisible(false); plantilla.posicioon.setVisible(false);
	}

	private void ocultar1(boolean uno, boolean dos, boolean tres, boolean cuatro, boolean cinco, boolean seis, boolean siete, boolean ocho, boolean nueve) {
		plantilla.ampliar.setVisible(uno);
		plantilla.buscar1.setVisible(tres);
		plantilla.panel.setVisible(cinco);
		plantilla.comprarPosiciones.setSelectedIndex(0);
		plantilla.comprarPosiciones.setVisible(seis);
		plantilla.aceptar.setVisible(siete);
		plantilla.venderJugadores.setVisible(nueve); ;
		ocultarCarta();
	}

	private void ocultarVender(boolean uno) {
		plantilla.ampliarvender.setVisible(uno); 
		plantilla.aceptarvender.setVisible(uno); 
		plantilla.cancelarvender.setVisible(uno); 
		plantilla.info.setVisible(uno);
		plantilla.info2.setVisible(uno);
	}
	
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
		plantilla.mediosComboBox.setVisible(false);
		plantilla.mediosDComboBox.setVisible(false);
		plantilla.mediosIComboBox.setVisible(false);
		plantilla.carrileroDComboBox.setVisible(false);
		plantilla.carrileroIComboBox.setVisible(false);
		plantilla.extremosDCcomboBox.setVisible(false);
		plantilla.extremosICcomboBox.setVisible(false);
		plantilla.delanteroCcomboBox.setVisible(false);
		plantilla.delanteroDCcomboBox.setVisible(false);
		plantilla.delanteroICcomboBox.setVisible(false);
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
	
	//sacar informaci??n de las cartas que se eligan
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
		if(pos.equals("MED")) {pos="MEDIO"; }
		if(pos.equals("MED I")) {pos="MEDIO I."; }
		if(pos.equals("MED D")) {pos="MEDIO D."; }
		if(pos.equals("CAR I")) {pos="CARRILERO I."; }
		if(pos.equals("CAR D")) {pos="CARRILERO D."; }
		if(pos.equals("EXT D")) {pos="EXTREMO D."; }
		if(pos.equals("EXT I")) {pos="EXTREMO I."; }
		if(pos.equals("DEL I")) {pos="DELANTERO I."; }
		if(pos.equals("DEL D")) {pos="DELANTERO D."; }
		if(pos.equals("DEL")) {pos="DELANTERO"; }
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
	
	//preguntar en un JOptionPane si se quiere cerrar o no la ventana 
	public void cerrar(JFrame plantillaaa) {	
		plantillaaa.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		plantillaaa.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				String sig=plantilla.siglas.getText();
				Boolean sigBoolean=sig.isEmpty();
				SessionFactory sessionFactory = null;
		        Configuration configuration = new Configuration();
		        configuration.configure("hibernate.cfg.xml");
		        sessionFactory = configuration.buildSessionFactory();
		        sessionFactory.getCurrentSession();
				int option = JOptionPane.showConfirmDialog( plantillaaa,  "           ??QUIERES CERRAR LA APLICACI??N?\nDEBES DE REGISTRARTE ANTES EN EL RANKING\n   TU PUNTUACI??N SE GUARDAR?? EN LA BBDD", "CONFIRMACI??N DE CIERRE", JOptionPane.YES_NO_OPTION,  JOptionPane.WARNING_MESSAGE);
				if (option==JOptionPane.YES_OPTION && sigBoolean==false) {
					int puntuacion=Integer.parseInt(plantilla.puntos.getText());
					modelo.insertarPlantilla(sessionFactory, sig, puntuacion);
					modelo.borrarDatosTabla();
					System.exit(0);
				}
			}
		});
	}	
	}