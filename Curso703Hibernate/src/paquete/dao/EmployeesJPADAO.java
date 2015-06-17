package paquete.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.logging.Logger;

import paquete.clases.Employees;
import paquete.interfaces.RECUPERABLE;

public class EmployeesJPADAO implements RECUPERABLE{
	
	private final static Logger logger = Logger.getLogger("mylog");
	
	@Override
	public Object leerEmpleado(int id) 
	{
		Employees empleadoleido = new Employees();
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try
		{	
			emf = Persistence.createEntityManagerFactory("UnidadPersonas"); // Que valor debe llevar? Por que?
			em = emf.createEntityManager();
			
			empleadoleido = em.find(Employees.class, id);
		}
		catch(Exception e)
		{
			logger.fatal("ERROR AL LEER EMPLEADO DE LA TABLA EMPLOYEES.");
			e.printStackTrace();
		}
		finally
		{
			em.close();
			emf.close();
		}
		logger.info("EL EMPLEADO HA SIDO LEIDO EXITOSAMENTE.");
		return empleadoleido;
	}
}
