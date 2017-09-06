package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Barrio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBarrio;
	
	private String nombreBarrio;
	
	@ManyToOne (fetch = FetchType.LAZY)  //muchos barrios pertenecen a una comuna
	@JoinColumn (name="idComuna")  //se joinea con el id de comuna
	private Comuna Comuna;
	
	
	//CONSTRUCTORES
	
	Barrio(){};
	
	Barrio (String nombreBarrio)
	{	
		this.nombreBarrio = nombreBarrio;	
	}

	
	//GETTERS Y SETTERS
	
	public Long getIdBarrio() {
		return idBarrio;
	}

	public void setIdBarrio(Long idBarrio) {
		this.idBarrio = idBarrio;
	}

	public String getNombreBarrio() {
		return nombreBarrio;
	}

	public void setNombreBarrio(String nombreBarrio) {
		this.nombreBarrio = nombreBarrio;
	}

	public Comuna getComuna() {
		return Comuna;
	}

	public void setComuna(Comuna comuna) {
		Comuna = comuna;
	}

	
	//HASHCODE Y EQUALS
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Comuna == null) ? 0 : Comuna.hashCode());
		result = prime * result + ((idBarrio == null) ? 0 : idBarrio.hashCode());
		result = prime * result + ((nombreBarrio == null) ? 0 : nombreBarrio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Barrio other = (Barrio) obj;
		if (Comuna == null) {
			if (other.Comuna != null)
				return false;
		} else if (!Comuna.equals(other.Comuna))
			return false;
		if (idBarrio == null) {
			if (other.idBarrio != null)
				return false;
		} else if (!idBarrio.equals(other.idBarrio))
			return false;
		if (nombreBarrio == null) {
			if (other.nombreBarrio != null)
				return false;
		} else if (!nombreBarrio.equals(other.nombreBarrio))
			return false;
		return true;
	}
	
	
	
	
	
	

}
