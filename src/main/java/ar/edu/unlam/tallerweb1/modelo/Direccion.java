package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDireccion;
	
	private String calle;
	private String numero;
	
	@ManyToOne (fetch = FetchType.LAZY) //Muchas direcciones pertenecen a un barrio
	@JoinColumn (name="idBarrio") 
	private Barrio barrio;

	
	//CONSTRUCTORES
	
	public Direccion() {};
	
	public Direccion(String calle, String numero, Barrio barrio) {
		this.calle = calle;
		this.numero = numero;
		this.barrio = barrio;
	}

	
	//GETTERS Y SETTERS 
	
	public Long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}


	


	
	

}
