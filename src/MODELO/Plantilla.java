package MODELO;
// Generated 22 may. 2022 18:02:12 by Hibernate Tools 5.4.32.Final

/**
 * Plantilla generated by hbm2java
 */
public class Plantilla implements java.io.Serializable {

	private int idPlantilla;
	private String nombrePlantilla;
	private int puntosPlantilla;

	public Plantilla() {
	}

	public Plantilla(int idPlantilla, String nombrePlantilla, int puntosPlantilla) {
		this.idPlantilla = idPlantilla;
		this.nombrePlantilla = nombrePlantilla;
		this.puntosPlantilla = puntosPlantilla;
	}

	public int getIdPlantilla() {
		return this.idPlantilla;
	}

	public void setIdPlantilla(int idPlantilla) {
		this.idPlantilla = idPlantilla;
	}

	public String getNombrePlantilla() {
		return this.nombrePlantilla;
	}

	public void setNombrePlantilla(String nombrePlantilla) {
		this.nombrePlantilla = nombrePlantilla;
	}

	public int getPuntosPlantilla() {
		return this.puntosPlantilla;
	}

	public void setPuntosPlantilla(int puntosPlantilla) {
		this.puntosPlantilla = puntosPlantilla;
	}

}