package MODELO;

public class Ranking {
	
	private char sigla1, sigla2, sigla3, sigla4;
	private int numero;
	
	public Ranking(char sigla1, char sigla2, char sigla3, int numero) {
		this.sigla1 = sigla1;
		this.sigla2 = sigla2;
		this.sigla3 = sigla3;
		this.numero = numero;
	}
	
	public Ranking(char sigla1, char sigla2, char sigla3, char sigla4, int numero) {
		this.sigla1 = sigla1;
		this.sigla2 = sigla2;
		this.sigla3 = sigla3;
		this.sigla4 = sigla4;
		this.numero = numero;
	}

	public char getSigla1() {
		return sigla1;
	}

	public void setSigla1(char sigla1) {
		this.sigla1 = sigla1;
	}

	public char getSigla2() {
		return sigla2;
	}

	public void setSigla2(char sigla2) {
		this.sigla2 = sigla2;
	}

	public char getSigla3() {
		return sigla3;
	}

	public void setSigla3(char sigla3) {
		this.sigla3 = sigla3;
	}

	public char getSigla4() {
		return sigla4;
	}

	public void setSigla4(char sigla4) {
		this.sigla4 = sigla4;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return sigla1 +""+ sigla2 +""+ sigla3 +"................." + numero+ sigla4;
	}
	
}
