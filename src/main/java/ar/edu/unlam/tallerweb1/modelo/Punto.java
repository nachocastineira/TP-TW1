package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Punto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPunto;
	private String latitud;
	private String longitud;
	
	
	//CONSTRUCTORES
	
	public Punto(){}
	
	public Punto(String latitud , String longitud){
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	
	//GETTERS Y SETTERS 
	
	public Long getIdPunto() {
		return idPunto;
	}
	
	public void setIdPunto(Long idPunto) {
		this.idPunto = idPunto;
	}
	
	public String getLatitud() {
		return latitud;
	}
	
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	
	public String getLongitud() {
		return longitud;
	}
	
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
	
}
