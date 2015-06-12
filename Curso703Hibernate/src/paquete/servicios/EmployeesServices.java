package paquete.servicios;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import paquete.clases.Employees;
import paquete.conexiones.SessionManager;
import paquete.dao.EmployeesDAO;
import paquete.dao.SuperDAO;


public class EmployeesServices {
	
	private SuperDAO superdao = null;
	
	public EmployeesServices()
	{
		superdao = new SuperDAO();
	}
	
	public boolean incrementarSalario()
	{
		boolean comprobacion = false;
		Session s_sesion = null;
		Transaction t_transaccion = null;
		EmployeesDAO employeesdao = new EmployeesDAO(superdao);
		
		List<Employees> list_employees = null;
		
		try
		{	
			s_sesion = SessionManager.obtenerSesionNueva();
			superdao.setSesion(s_sesion);
			
			t_transaccion = s_sesion.beginTransaction();

			list_employees = employeesdao.obtenerEmpleados();
			
			for (Employees empleado : list_employees) 
			{
				empleado.setSalary(empleado.getSalary().multiply(new BigDecimal(1.2)));
			}
			t_transaccion.commit();
			comprobacion = true;
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
		return comprobacion;
	}
}
