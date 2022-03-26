package CONTROLADOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MODELO.Modelo;
import VISTA.Vista;

public class Controlador implements ActionListener{
	Vista vista=new Vista();
	
	public Controlador(VISTA.Vista frame) {
		this.vista=frame;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}


