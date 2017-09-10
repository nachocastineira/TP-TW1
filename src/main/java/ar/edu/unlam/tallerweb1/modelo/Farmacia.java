package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Farmacia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFarmacia;
	private String nombreFarmacia;
	private String telefonoFarmacia;
	private String diaDeTurno;
	
	@OneToOne
	private Direccion direccion;
	
	@OneToOne
	private Punto geoLocalizacion;
	
	
	
	//CONSTRUCTORES
	
	public Farmacia(){}
	
	public Farmacia(String nombreFarmacia , String telefonoFarmacia){
		this.nombreFarmacia = nombreFarmacia;
		this.telefonoFarmacia = telefonoFarmacia;
	}

	
	//GETTERS Y SETTERS 
	
	public Long getIdFarmacia() {
		return idFarmacia;
	}

	public void setIdFarmacia(Long idFarmacia) {
		this.idFarmacia = idFarmacia;
	}

	public String getNombreFarmacia() {
		return nombreFarmacia;
	}

	public void setNombreFarmacia(String nombreFarmacia) {
		this.nombreFarmacia = nombreFarmacia;
	}

	public String getTelefonoFarmacia() {
		return telefonoFarmacia;
	}

	public void setTelefonoFarmacia(String telefonoFarmacia) {
		this.telefonoFarmacia = telefonoFarmacia;
	}

	public String getDiaDeTurno() {
		return diaDeTurno;
	}

	public void setDiaDeTurno(String diaDeTurno) {
		this.diaDeTurno = diaDeTurno;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Punto getGeoLocalizacion() {
		return geoLocalizacion;
	}

	public void setGeoLocalizacion(Punto geoLocalizacion) {
		this.geoLocalizacion = geoLocalizacion;
	}

	

	


	
	
	
	
	
	
}
