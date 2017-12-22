package ar.edu.unlam.tallerweb1.modelo;

public class Suma {

	private String primerValor;
	private String segundoValor;
	private Boolean numerosCorrectos;
	
	
	public String getPrimerValor() {
		return primerValor;
	}
	
	public void setPrimerValor(String primerValor) {
		this.primerValor = primerValor;
	}
	
	public String getSegundoValor() {
		return segundoValor;
	}
	
	public void setSegundoValor(String segundoValor) {
		this.segundoValor = segundoValor;
	}

	public Boolean getNumerosCorrectos() {
		return numerosCorrectos;
	}

	public void setNumerosCorrectos(Boolean numerosCorrectos) {
		this.numerosCorrectos = numerosCorrectos;
	}
	
	public void verificaNumerosCorrectos() {
		
		if(numerosCorrectos.equals(numerosCorrectos)) {
			this.numerosCorrectos = true;
		} else {
			this.numerosCorrectos = false;
		}
	}
	
	public Integer getSuma() {
		
		if(this.primerValor + this.segundoValor != null) {
			return Integer.parseInt(primerValor) + Integer.parseInt(segundoValor);
		}
		
		return 0;
	}
	
	
}
