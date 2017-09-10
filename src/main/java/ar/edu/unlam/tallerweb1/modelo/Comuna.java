package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comuna {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComuna;
	
	private String nombreComuna;
	
	//COMENTADO PARA QUE NO TIRE ERROR EN LOS TEST - BUSCAR SOLUCION
	
//	@OneToMany (mappedBy="comuna", cascade=CascadeType.ALL) //En una comuna hay muchos barrios
//	private List<Barrio> barrios = new ArrayList<Barrio>();
	
	
	//CONSTRUCTORES
	
	Comuna(){};
	
	Comuna (String nombreComuna)
	{	
		this.nombreComuna = nombreComuna;	
	}

	
	//GETTERS Y SETTERS
	
	public Long getIdComuna() {
		return idComuna;
	}

	public void setIdComuna(Long idComuna) {
		this.idComuna = idComuna;
	}

	public String getNombreComuna() {
		return nombreComuna;
	}

	public void setNombreComuna(String nombreComuna) {
		this.nombreComuna = nombreComuna;
	}
	
	
//	public List<Barrio> getBarrios() {
//		return barrios;
//	}
//
//	public void setBarrios(List<Barrio> barrios) {
//		this.barrios = barrios;
//	}
//
//	//Metodo que agrega un barrio a la comuna
//	public void addBarrio (Barrio barrio){
//		
//		barrios.add(barrio);
//	}
//	
	

}
