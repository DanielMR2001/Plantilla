package MODELO;
// Generated 24 abr. 2022 13:28:11 by Hibernate Tools 5.4.32.Final

/**
 * Cartas generated by hbm2java
 */
public class Cartas implements java.io.Serializable {

	private Integer idCarta;
	private String nombre;
	private String posicion;
	private String pais;
	private String equipo;
	private String liga;
	private int precio;
	private int media;

	public Cartas() {
	}

	public Cartas(Integer idCarta, String nombre, String posicion, String pais, String equipo, String liga, int precio, int media) {
		this.idCarta = idCarta;
		this.nombre = nombre;
		this.posicion = posicion;
		this.pais = pais;
		this.equipo = equipo;
		this.liga = liga;
		this.precio = precio;
		this.media = media;
	}

	public Integer getIdCarta() {
		return this.idCarta;
	}

	public void setIdCarta(Integer idCarta) {
		this.idCarta = idCarta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return this.posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEquipo() {
		return this.equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getLiga() {
		return this.liga;
	}

	public void setLiga(String liga) {
		this.liga = liga;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getMedia() {
		return this.media;
	}

	public void setMedia(int media) {
		this.media = media;
	}

}