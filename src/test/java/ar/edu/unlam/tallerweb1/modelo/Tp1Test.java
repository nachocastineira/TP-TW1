package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;

public class Tp1Test extends SpringTest {

	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(true)
	public void testQueBuscaTodasLasFarmaciasDeTurnoLosDiasMartes() {
		
		Farmacia primerFarmacia = new Farmacia();
		primerFarmacia.setDiaDeTurno("Martes");
		
		Farmacia segundaFarmacia = new Farmacia();
		segundaFarmacia.setDiaDeTurno("Lunes");
		
		Farmacia tercerFarmacia = new Farmacia();
		tercerFarmacia.setDiaDeTurno("Miercoles");
		
		getSession().save(primerFarmacia);
		getSession().save(segundaFarmacia);
		getSession().save(tercerFarmacia);
		
		Session miSesion = getSession();
		
		List<Farmacia> miFarmacia;
		
		//--- 1. Buscar todas las farmacias de turno los dias martes ---//
		
		miFarmacia = miSesion.createCriteria(Farmacia.class)
						.add(Restrictions.eq("diaDeTurno", "Martes"))
						.list();
		
		assertThat(miFarmacia).hasSize(1);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(true)
	public void testQueBuscaTodasLasFarmaciasDeUnaCalle() {
		
		Barrio barrio1 = new Barrio();
		barrio1.setNombreBarrio("Buenos Aires");
		
		Direccion direccion1 = new Direccion();
		direccion1.setCalle("Lavalle");
		direccion1.setNumero("120");
		direccion1.setBarrio(barrio1);
		
		Direccion direccion2 = new Direccion();
		direccion1.setCalle("Lavalle");
		direccion1.setNumero("2450");
		direccion1.setBarrio(barrio1);
		
		Direccion direccion3 = new Direccion();
		direccion1.setCalle("Lavalle");
		direccion1.setNumero("630");
		direccion1.setBarrio(barrio1);
		
		Farmacia primerFarmacia = new Farmacia();
		primerFarmacia.setDireccion(direccion1);
		
		Farmacia segundaFarmacia = new Farmacia();
		segundaFarmacia.setDireccion(direccion2);
		
		Farmacia tercerFarmacia = new Farmacia();
		tercerFarmacia.setDireccion(direccion3);
		
		getSession().save(primerFarmacia);
		getSession().save(segundaFarmacia);
		getSession().save(tercerFarmacia);
		getSession().save(barrio1);
		getSession().save(direccion1);
		getSession().save(direccion2);
		getSession().save(direccion3);
		
		Session miSesion = getSession();
		
		List<Farmacia> farmacias;
		
		//--- 2. Buscar todas las farmacias de una calle (calle Lavalle) ---//
		
		farmacias = miSesion.createCriteria(Farmacia.class)
						.createAlias("direccion", "direccion")
						.add(Restrictions.eq("direccion.calle", "Lavalle"))
						.list();
		
		assertThat(farmacias).hasSize(3); //buscar problema, me toma todos los datos de la direccion, y no solo la calle, por eso tira 1
	}

}
