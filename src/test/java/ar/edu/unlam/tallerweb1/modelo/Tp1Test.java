package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;

public class Tp1Test extends SpringTest {
	
	
	private Farmacia primerFarmacia, segundaFarmacia, tercerFarmacia;
	private Barrio barrio1, barrio2;
	private Direccion direccion1, direccion2, direccion3;
	private Session miSesion;
	private Comuna comuna1;
	private List<Farmacia> farmacias;
	
	@Before
	public void inicializacion(){   //inicializo los objetos aca para no repetirlos en cada test
		
		primerFarmacia = new Farmacia();
		segundaFarmacia = new Farmacia();
		tercerFarmacia = new Farmacia();
		barrio1 = new Barrio();
		barrio2 = new Barrio();
		comuna1 = new Comuna();
		direccion1 = new Direccion();
		direccion2 = new Direccion();
		direccion3 = new Direccion();
		miSesion = getSession();
		farmacias = new ArrayList<Farmacia>();	
	}


	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(true)
	public void testQueBuscaTodasLasFarmaciasDeTurnoLosDiasMartes() {
		
		primerFarmacia.setDiaDeTurno("Martes");
		primerFarmacia.setNombreFarmacia("Mejorate");
		
		segundaFarmacia.setDiaDeTurno("Lunes");
		tercerFarmacia.setDiaDeTurno("Miercoles");
		
		getSession().save(primerFarmacia);
		getSession().save(segundaFarmacia);
		getSession().save(tercerFarmacia);
		
			
		//--- 1. Buscar todas las farmacias de turno los dias martes ---//
		
		farmacias = miSesion.createCriteria(Farmacia.class)
						.add(Restrictions.eq("diaDeTurno", "Martes"))
						.list();
		
		assertThat(farmacias).hasSize(1);
		assertThat(farmacias.get(0).getDiaDeTurno()).isEqualTo("Martes"); //verifico que el dia de turno traido sea Martes
		assertThat(farmacias.get(0).getNombreFarmacia()).isEqualTo("Mejorate");  //que su nombre sea Mejorate
		assertThat(farmacias.get(0).getDiaDeTurno()).isNotEqualTo("Lunes"); // y que el dia no sea Lunes
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(true)
	public void testQueBuscaTodasLasFarmaciasDeUnaCalle() {
		
		barrio1.setNombreBarrio("Buenos Aires");
		
		direccion1.setCalle("Lavalle");
		direccion1.setNumero("120");
		direccion1.setBarrio(barrio1);
		
		direccion2.setCalle("Lavalle");
		direccion2.setNumero("2450");
		direccion2.setBarrio(barrio1);
		
		direccion3.setCalle("Cordoba");
		direccion3.setNumero("630");
		direccion3.setBarrio(barrio1);
		
		primerFarmacia.setDireccion(direccion1);
		primerFarmacia.setNombreFarmacia("El Remedio Loco");
		
		segundaFarmacia.setDireccion(direccion2);
		segundaFarmacia.setNombreFarmacia("El Remedio Loco");
		
		tercerFarmacia.setDireccion(direccion3);
		tercerFarmacia.setNombreFarmacia("Mas Salud");
		
		getSession().save(primerFarmacia);
		getSession().save(segundaFarmacia);
		getSession().save(tercerFarmacia);
		getSession().save(barrio1);
		getSession().save(direccion1);
		getSession().save(direccion2);
		getSession().save(direccion3);
		
		
		//--- 2. Buscar todas las farmacias de una calle (calle Lavalle) ---//
		
		farmacias = miSesion.createCriteria(Farmacia.class)
						.createAlias("direccion", "dir")
						.add(Restrictions.eq("dir.calle", "Lavalle"))
						.list();
		
		assertThat(farmacias).hasSize(2);
		assertThat(farmacias.get(0).getNombreFarmacia()).isEqualTo("El Remedio Loco");
		assertThat(farmacias.get(0).getDireccion().getCalle()).isEqualTo("Lavalle"); //la calle de la farmacia en indice 0 es "Lavalle"
		assertThat(farmacias.get(1).getDireccion().getCalle()).isEqualTo("Lavalle"); //la del indice 1 tambien es Lavalle
		assertThat(farmacias.get(0).getDireccion().getCalle()).isNotEqualTo("Cordoba"); //la calle de la farmacia en indice 0 no es "Cordoba"
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(true)
	public void testQueBuscaTodasLasFarmaciasDeUnaBarrio() {
		
		comuna1.addBarrio(barrio1);
		comuna1.addBarrio(barrio2);
		
		barrio1.setNombreBarrio("CABA");
		barrio2.setNombreBarrio("San Justo");
		
		direccion1.setCalle("Lavalle");
		direccion1.setNumero("120");
		direccion1.setBarrio(barrio1);
		
		direccion2.setCalle("Arieta");
		direccion2.setNumero("2450");
		direccion2.setBarrio(barrio2);
		
		direccion3.setCalle("Cordoba");
		direccion3.setNumero("630");
		direccion3.setBarrio(barrio1);
		
		primerFarmacia.setDireccion(direccion1);
		primerFarmacia.setNombreFarmacia("Dr Ahorro");
		
		segundaFarmacia.setDireccion(direccion2);
		segundaFarmacia.setNombreFarmacia("Farmacity");
		
		tercerFarmacia.setDireccion(direccion3);
		tercerFarmacia.setNombreFarmacia("Simplicity");
		
		getSession().save(primerFarmacia);
		getSession().save(segundaFarmacia);
		getSession().save(tercerFarmacia);
		getSession().save(barrio1);
		getSession().save(barrio2);
		getSession().save(direccion1);
		getSession().save(direccion2);
		getSession().save(direccion3);
		getSession().save(comuna1);
		
		
		//--- 3. Buscar todas las farmacias de un barrio (CABA) ---//
		
		farmacias = miSesion.createCriteria(Farmacia.class)
						.createAlias("direccion", "dir")
						.createAlias("dir.barrio", "bar")
						.add(Restrictions.eq("bar.nombreBarrio", "CABA"))
						.list();
		
		
		assertThat(farmacias).hasSize(2);  //la consulta me trae 2 resultados
		assertThat(farmacias.get(0).getNombreFarmacia()).isEqualTo("Dr Ahorro");  //el nombre de la farmacia en indice 0 es "Dr Ahorro"
		assertThat(farmacias.get(1).getNombreFarmacia()).isEqualTo("Simplicity"); //el del indice 1 es "Simplicity"
		assertThat(farmacias.get(0).getDireccion().getBarrio().getNombreBarrio()).isEqualTo("CABA"); // el barrio de la farmacia es CABA
		assertThat(farmacias.get(0).getDireccion().getBarrio().getNombreBarrio()).isNotEqualTo("San Justo"); // y no es San Justo
	}


}
