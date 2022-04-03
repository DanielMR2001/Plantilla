package CONTROLADOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.Clip;
import org.hibernate.SessionFactory;
import MODELO.Modelo;
import VISTA.Login;
import VISTA.Plantilla;

public class Controlador2 implements ActionListener{
	
	Login login=new Login();
	Modelo modelo=new Modelo();
	Plantilla plantilla=new Plantilla();
	SessionFactory sessionFactory = null;
	Clip sonido=null;
	
	public Controlador2(VISTA.Plantilla plantilla) {
		this.plantilla=plantilla;
		this.plantilla.comprar.addActionListener(this);
		this.plantilla.vender.addActionListener(this);
		this.plantilla.ranking.addActionListener(this);
		this.plantilla.posiciones.addActionListener(this);
		this.plantilla.buscar1.addActionListener(this);
		this.plantilla.buscar2.addActionListener(this);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String posicion=(String) plantilla.posiciones.getSelectedItem();
				
			//funcionalidad cuando se pulse el boton de comprar
			if(e.getSource()==plantilla.comprar) {
				plantilla.panelranking.setVisible(false);
				plantilla.posiciones.setVisible(true);
				plantilla.posiciones.setSelectedIndex(0);
				plantilla.buscar1.setVisible(true);
				plantilla.panel.setVisible(false);
				plantilla.buscar2.setVisible(false);
			}
				
			//funcionalidad cuando se pulse el boton de buscar1
			if((e.getSource()==plantilla.buscar1)&&(posicion.equals("Elige Posicion"))) {
				plantilla.panel.setVisible(false);
			}else if((e.getSource()==plantilla.buscar1)&&(posicion.equals("Portero"))) {
				plantilla.panel.setVisible(true);
			}	
				
			//funcionalidad cuando se pulse el boton de vender
			if(e.getSource()==plantilla.vender) {
				plantilla.panelranking.setVisible(false);
				plantilla.buscar1.setVisible(false);
				plantilla.buscar2.setVisible(true);
				plantilla.panel.setVisible(false);
				plantilla.posiciones.setSelectedIndex(0);
				plantilla.posiciones.setVisible(true);
			}
				
			//funcionalidad cuando se pulse el boton de buscar2
			if((e.getSource()==plantilla.buscar2)&&(posicion.equals("Elige Posicion"))) {
				plantilla.panel.setVisible(false);
			}else if((e.getSource()==plantilla.buscar2)&&(posicion.equals("Portero"))) {
				plantilla.panel.setVisible(true);
			}
				
			//funcionalidad cuando se pulse el boton de ranking
			if(e.getSource()==plantilla.ranking) {
				plantilla.posiciones.setVisible(false);
				plantilla.buscar1.setVisible(false);
				plantilla.panel.setVisible(false);
				plantilla.panelranking.setVisible(true);
			}
		} catch (Exception e3) { e3.printStackTrace(); 
		} finally { if(sessionFactory != null) { sessionFactory.close(); } }
	
	}

}