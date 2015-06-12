package paquete.servicios;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import paquete.clases.Employees;
import paquete.conexiones.SessionManager;
import paquete.dao.EmployeesDAO;
import paquete.dao.SuperDAO;


public class EmployeesServices {
	
	public static void incrementarSalario()
	{
		Session s_sesion = null;
		Transaction t_transaccion = null;
		EmployeesDAO employeesdao = new EmployeesDAO();
		
		List<Employees> list_employees = null;
		
		try
		{	
			s_sesion = SessionManager.obtenerSesionNueva();
			SuperDAO.setSesion(s_sesion);
			
			t_transaccion = s_sesion.beginTransaction();

			list_employees = employeesdao.obtenerEmpleados();
			
			for (Employees empleado : list_employees) 
			{
				empleado.setSalary(empleado.getSalary().multiply(new BigDecimal(1.2)));
			}
			t_transaccion.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			t_transaccion.rollback();
		}
		finally
		{
			SessionManager.cerrarSession(s_sesion);
			SessionManager.cerrarFactory();
		}
	}
}
