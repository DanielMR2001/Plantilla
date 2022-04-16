package CONTROLADOR;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import MODELO.Carta;
import MODELO.Modelo;
import MODELO.Usuario;
import VISTA.Login;
import VISTA.Plantilla;

public class Controlador2 implements ActionListener{
	
	Login login=new Login();
	Modelo modelo=new Modelo();
	Plantilla plantilla=new Plantilla();
	SessionFactory sessionFactory = null;
	
	public Controlador2(VISTA.Plantilla plantilla) {
		this.plantilla=plantilla;
		this.plantilla.comprar.addActionListener(this);
		this.plantilla.vender.addActionListener(this);
		this.plantilla.ranking.addActionListener(this);
		this.plantilla.posiciones.addActionListener(this);
		this.plantilla.buscar1.addActionListener(this);
		this.plantilla.buscar2.addActionListener(this);
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
		this.plantilla.buscarJugadores.addActionListener(this);
		this.plantilla.posicionJugadores.addActionListener(this);
	}
			
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//configuracion del hibernate
			Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        sessionFactory = configuration.buildSessionFactory();
	        sessionFactory.getCurrentSession();
			
	        String posicion=(String) plantilla.posiciones.getSelectedItem();
	        String buscarPosicion=(String) plantilla.posicionJugadores.getSelectedItem();
	        
			//funcionalidad cuando se pulse el boton de comprar
			if(e.getSource()==plantilla.comprar) {				
				ocultar1(true, false, true, true, true, true, false, true, true, true);
			}
				
			//funcionalidad cuando se pulse el boton de buscar1 y al selecciona alguna opcion del ComboBox para Comprar
			if(posicion.equals("Elige Posicion")) {
				ocultar2(plantilla.panel, plantilla.ampliar, plantilla.aceptar);
			}else if(posicion.equals("Portero")) {
				ocultar2(plantilla.panel, plantilla.ampliar, plantilla.aceptar);
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					for(int i=0; i<=15; i++) {
						modelo.sacarJugadores(sessionFactory, i);
					}
					comprarJugadores("cartas/oblak.png", "cartas/terstegen.png", "cartas/alisson.png", "cartas/courtois.png", "cartas/neuer.png", "cartas/ederson.png", "cartas/handanovic.png", "cartas/keylornavas.png", "cartas/szczesny.png", "cartas/lloris.png", "cartas/degea.png",  "cartas/donnarumma.png", "cartas/leno.png", "cartas/gulacsi.png", "cartas/sommer.png");	
				}
			}else if(posicion.equals("Central")) {
				ocultar2(plantilla.panel, plantilla.ampliar, plantilla.aceptar);
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					for(int i=16; i<=30; i++) {
						modelo.sacarJugadores(sessionFactory, i);
					}
					comprarJugadores("cartas/hummels.png", "cartas/deligt.png", "cartas/laporte.png", "cartas/pique.png", "cartas/devrij.png", "cartas/lenglet.png", "cartas/manolas.png", "cartas/coates.png",  "cartas/kounde.png", "cartas/skriniar.png", "cartas/nacho.png",  "cartas/upamecano.png", "cartas/koulibaly.png", "cartas/vandijk.png", "cartas/ramos.png");
				}
			}else if(posicion.equals("Lateral Izquierdo")) {
				ocultar2(plantilla.panel, plantilla.ampliar, plantilla.aceptar);
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					for(int i=31; i<=45; i++) {
						modelo.sacarJugadores(sessionFactory, i);
					}
					comprarJugadores("cartas/davies.png", "cartas/acuña.png", "cartas/bernat.png", "cartas/grimaldo.png", "cartas/jordialba.png", "cartas/robertson.png", "cartas/digne.png", "cartas/spinazzola.png",  "cartas/telles.png", "cartas/sandro.png", "cartas/tagliafico.png", "cartas/marcelo.png", "cartas/guerreiro.png", "cartas/mendy.png", "cartas/gelson.png");
				}
			}else if(posicion.equals("Lateral Derecho")) {
				ocultar2(plantilla.panel, plantilla.ampliar, plantilla.aceptar);
				if(e.getSource()==plantilla.buscar1) {
					plantilla.panel.setVisible(true);
					for(int i=46; i<=60; i++) {
						modelo.sacarJugadores(sessionFactory, i);
					}
					comprarJugadores("cartas/azpilicueta.png", "cartas/trippier.png", "cartas/jesusnavas.png", "cartas/carvajal.png", "cartas/arnold.png", "cartas/cancelo.png", "cartas/bissaka.png", "cartas/walker.png",  "cartas/cuadrado.png", "cartas/pereira.png", "cartas/dest.png",  "cartas/kamara.png", "cartas/kimmich.png", "cartas/corona.png", "cartas/hakimi.png");
				}
			}
			
			//funcionalidad cuando se pulse alguna de las cartas
			if(posicion.equals("Portero")){
				plantilla.nombre.setText(""); plantilla.pais.setText(""); plantilla.posicion.setText(""); plantilla.media.setText("");
				plantilla.nombree.setVisible(false); plantilla.paiis.setVisible(false); plantilla.posicioon.setVisible(false); plantilla.puntoos.setVisible(false);
				sacarCarta(e, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, plantilla.aceptar, "cartas/oblak.png", "cartas/terstegen.png", "cartas/alisson.png", "cartas/courtois.png",  "cartas/neuer.png", "cartas/ederson.png", "cartas/handanovic.png", "cartas/keylornavas.png", "cartas/szczesny.png", "cartas/lloris.png", "cartas/degea.png",  "cartas/donnarumma.png",  "cartas/leno.png", "cartas/gulacsi.png", "cartas/sommer.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PORTEROS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
				if(e.getSource()==plantilla.aceptar) {
					plantilla.panel.setVisible(true); 
				}
			}else if(posicion.equals("Central")){
				plantilla.nombre.setText(""); plantilla.pais.setText(""); plantilla.posicion.setText(""); plantilla.media.setText("");
				plantilla.nombree.setVisible(false); plantilla.paiis.setVisible(false); plantilla.posicioon.setVisible(false); plantilla.puntoos.setVisible(false);
				sacarCarta(e, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, plantilla.aceptar,"cartas/hummels.png", "cartas/deligt.png", "cartas/laporte.png", "cartas/pique.png",  "cartas/devrij.png", "cartas/lenglet.png", "cartas/manolas.png", "cartas/coates.png", "cartas/kounde.png", "cartas/skriniar.png", "cartas/nacho.png",  "cartas/upamecano.png",  "cartas/koulibaly.png", "cartas/vandijk.png", "cartas/ramos.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CENTRALES", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
				if(e.getSource()==plantilla.aceptar) {
					plantilla.panel.setVisible(true);
				}
			}else if(posicion.equals("Lateral Izquierdo")){
				plantilla.nombre.setText(""); plantilla.pais.setText(""); plantilla.posicion.setText(""); plantilla.media.setText("");
				plantilla.nombree.setVisible(false); plantilla.paiis.setVisible(false); plantilla.posicioon.setVisible(false); plantilla.puntoos.setVisible(false);
				sacarCarta(e, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, plantilla.aceptar,"cartas/davies.png", "cartas/acuña.png", "cartas/bernat.png", "cartas/grimaldo.png", "cartas/jordialba.png", "cartas/robertson.png", "cartas/digne.png", "cartas/spinazzola.png", "cartas/telles.png", "cartas/sandro.png", "cartas/tagliafico.png", "cartas/marcelo.png", "cartas/guerreiro.png", "cartas/mendy.png", "cartas/gelson.png");
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "LATERALES IZQUIERDOS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
				if(e.getSource()==plantilla.aceptar) {
					plantilla.panel.setVisible(true);
				}
			}else if(posicion.equals("Lateral Derecho")){
				plantilla.nombre.setText(""); plantilla.pais.setText(""); plantilla.posicion.setText(""); plantilla.media.setText("");
				plantilla.nombree.setVisible(false); plantilla.paiis.setVisible(false); plantilla.posicioon.setVisible(false); plantilla.puntoos.setVisible(false);
				sacarCarta(e, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, plantilla.aceptar, "cartas/azpilicueta.png", "cartas/trippier.png", "cartas/jesusnavas.png", "cartas/carvajal.png", "cartas/arnold.png", "cartas/cancelo.png", "cartas/bissaka.png", "cartas/walker.png", "cartas/cuadrado.png", "cartas/pereira.png", "cartas/dest.png",  "cartas/kamara.png", "cartas/kimmich.png", "cartas/corona.png", "cartas/hakimi.png");				
				plantilla.panel.setBorder((new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "LATERALES DERECHOS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0))));
				if(e.getSource()==plantilla.aceptar) {
					plantilla.panel.setVisible(true);
				}
			}

			//funcionalidad cuando se pulse el boton de vender 
			if(e.getSource()==plantilla.vender) {
				ocultar1(true, false, true, true, true, true, false, true, true, true);
			}
				
			//funcionalidad cuando se pulse el boton de buscar2 y al selecciona alguna opcion del ComboBox para Vender
			if((e.getSource()==plantilla.buscar2)&&(posicion.equals("Elige Posicion"))) {
				plantilla.panel.setVisible(false);
			}else if((e.getSource()==plantilla.buscar2)&&(posicion.equals("Portero"))) {
								
			}
				
			//funcionalidad cuando se pulse el boton de ranking
			if(e.getSource()==plantilla.ranking) {
				ocultar1(true, true, false, false, false, true, false, true, true, true);
			}

			//funcionalidad cuando se pulse alguna opcion del ComboBox para buscar los jugadores Comprados y pulsar el boton de buscarJugadores
			if(buscarPosicion.equals("Elige Posicion")) {
				if(e.getSource()==plantilla.buscarJugadores) {
					ocultar1(true, false, true, true, true, false, false, true, true, true);

				}
			}else if(posicion.equals("Portero")) {
				ocultar2(plantilla.panel, plantilla.ampliar, plantilla.aceptar);
				if(e.getSource()==plantilla.buscarJugadores) {
					ocultar1(true, false, true, true, true, true, false, true, true, true);

				}
			}else if(buscarPosicion.equals("Central")) {
				ocultar2(plantilla.panel, plantilla.ampliar, plantilla.aceptar);
				if(e.getSource()==plantilla.buscarJugadores) {
					ocultar1(true, false, true, true, true, true, false, true, true, true);

				}
			}else if(buscarPosicion.equals("Lateral Izquierdo")) {
				ocultar2(plantilla.panel, plantilla.ampliar, plantilla.aceptar);
				if(e.getSource()==plantilla.buscarJugadores) {
					ocultar1(true, false, true, true, true, true, false, true, true, true);

				}
			}else if(buscarPosicion.equals("Lateral Derecho")) {
				ocultar2(plantilla.panel, plantilla.ampliar, plantilla.aceptar);
				if(e.getSource()==plantilla.buscarJugadores) {
					ocultar1(true, false, true, true, true, true, false, true, true, true);

				}
			}
			
		} catch (Exception e3) { e3.printStackTrace(); 
		} finally { if(sessionFactory != null) { sessionFactory.close(); } }
	
	}

	//poner visible o invisible los componentes, dependiendo de lo que se quiera hacer cuando se llame al metodo
	private void ocultar1(boolean uno, boolean dos, boolean tres, boolean cuatro, boolean cinco, boolean seis, boolean siete, boolean ocho, boolean nueve, boolean diez) {
		plantilla.ampliar.setVisible(uno);
		plantilla.panelranking.setVisible(dos);
		plantilla.buscar1.setVisible(tres);
		plantilla.buscar2.setVisible(cuatro);
		plantilla.panel.setVisible(cinco);
		plantilla.posiciones.setSelectedIndex(0);
		plantilla.posicionJugadores.setSelectedIndex(0);
		plantilla.posiciones.setVisible(seis);
		plantilla.aceptar.setVisible(siete);
		plantilla.buscarJugadores.setVisible(ocho);
		plantilla.posicionJugadores.setVisible(nueve);
		plantilla.jugadores.setVisible(diez);
		plantilla.nombre.setText(""); plantilla.pais.setText(""); plantilla.posicion.setText(""); plantilla.media.setText("");
		plantilla.nombree.setVisible(false); plantilla.paiis.setVisible(false); plantilla.posicioon.setVisible(false); plantilla.puntoos.setVisible(false);
	}

	//ocultar el panel, jlabel y el jbutton que se le pase por parámetro
	private void ocultar2(JPanel panel,JLabel label, JButton button) {
		panel.setVisible(false);
		label.setVisible(false);
		button.setVisible(false);
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
	
	//modificar los datos de la carta dependiendo de la carta que sea
	private void sacarPrecio(ActionEvent e, int numero) {
		plantilla.nombree.setVisible(true); plantilla.paiis.setVisible(true); plantilla.posicioon.setVisible(true); plantilla.puntoos.setVisible(true);
		Carta carta1=modelo.sacarJugadores(sessionFactory, numero);
		String precio=String.valueOf(carta1.getPrecio());
		String nombre=String.valueOf(carta1.getNombre());
		String pais=String.valueOf(carta1.getPais());
		String media=String.valueOf(carta1.getMedia());
		String posicion=String.valueOf(carta1.getPosicion());
		if(posicion.equals("POR")) {posicion="PORTERO"; }
		if(posicion.equals("DEF")) {posicion="CENTRAL"; }
		if(posicion.equals("LI")) {posicion="LATERAL IZQ."; }
		if(posicion.equals("LD")) {posicion="LATERAL DER."; }
		plantilla.aceptar.setVisible(true);
		plantilla.aceptar.setText("- "+precio+" €");
		plantilla.aceptar.setForeground(Color.RED);
		plantilla.nombre.setText(nombre);
		plantilla.pais.setText(pais);
		plantilla.posicion.setText(posicion);
		plantilla.media.setText(media);
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