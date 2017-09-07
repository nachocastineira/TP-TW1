package ar.edu.unlam.tallerweb1.modelo;

import static org.junit.Assert.*;

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
		
		miFarmacia = miSesion.createCriteria(Farmacia.class).add(Restrictions.lt("diaDeTurno", "martes")).list();
		
		assertThat(miFarmacia.get(0).getDiaDeTurno());
		assertThat(miFarmacia).hasSize(1);
	}

}
