package paquete.servicios;

import static org.junit.Assert.*;

import org.hamcrest.core.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import paquete.clases.Employees;
import paquete.conexiones.SessionManager;
import paquete.dao.SuperDAO;
import paquete.sentenciasSQL.SentenciasSQL;

public class TestEmployeesServices {
	
	SessionFactory s_factory = null;
	Session s_session = null;
	SuperDAO superdao = new SuperDAO();
	
	@Before
	public void startTest()
	{
		s_factory = SessionManager.getSessionFactory();
		s_session = SessionManager.obtenerSesionNueva();
		superdao.setSesion(s_session);
	}
	
	@After
	public void finTest()
	{
		SessionManager.cerrarSession(s_session);
		SessionManager.cerrarFactory();
	}
	
//	@Test
//	public void testEmployeesServices() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testIncrementarSalario() 
	{
		int ID = 100;
		Employees empleado1 = (Employees)s_session.createSQLQuery(SentenciasSQL.recogeremployeesselectoid(ID)).addEntity(Employees.class).uniqueResult();
		s_session.evict(empleado1);
		EmployeesServices employeesservices = new EmployeesServices();
		System.out.println(empleado1);
		employeesservices.incrementarSalario();
		Employees empleado2 = (Employees)s_session.createSQLQuery(SentenciasSQL.recogeremployeesselectoid(ID)).addEntity(Employees.class).uniqueResult();
		System.out.println(empleado2);
		assertTrue(empleado1.getSalary().intValue()<empleado2.getSalary().intValue());
	}

}
