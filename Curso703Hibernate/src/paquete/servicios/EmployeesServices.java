package paquete.servicios;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import paquete.clases.Employees;
import paquete.conexiones.SessionManager;
import paquete.dao.EmployeesDAO;
import paquete.dao.SuperDAO;
import paquete.sentenciasSQL.SentenciasSQL;


public class EmployeesServices {
	
	private SuperDAO superdao = null;
	private EmployeesDAO employeesdao = null;
	
	public EmployeesServices()
	{
		superdao = new SuperDAO();
		employeesdao = new EmployeesDAO(superdao);
	}
	
	public List<Employees> recuperarListaMayorSalarioPorDepartamento()
	{
		Session s_sesion = null;
		List<Employees> list_employees = null;
		
		try
		{	
			s_sesion = SessionManager.obtenerSesionNueva();
			superdao.setSesion(s_sesion);
			
			list_employees = employeesdao.recuperarListaMayorSalarioPorDepartamento();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionManager.cerrarSession(s_sesion);
		}
		
		return list_employees;
	}
	
	public List<Employees> recuperarListaEmployeesPorDepartamento(int DEPARTMENT_ID)
	{	
		Session s_sesion = null;
		List<Employees> list_employees = null;
		
		try
		{	
			s_sesion = SessionManager.obtenerSesionNueva();
			superdao.setSesion(s_sesion);
			
			list_employees = employeesdao.recuperarListaEmployeesPorDepartamento(DEPARTMENT_ID);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionManager.cerrarSession(s_sesion);
		}
		
		return list_employees;
	}
	
	public Employees insertarEmployee(Employees employee)
	{
		Employees employeeinsertado = null;
		
		Session s_sesion = null;
		Transaction t_transaccion = null;
		
		try
		{	
			s_sesion = SessionManager.obtenerSesionNueva();
			superdao.setSesion(s_sesion);
			t_transaccion = s_sesion.beginTransaction();
			
			employeeinsertado = employeesdao.create(employee);
			
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
		}
		
		return employeeinsertado;
	}
	
	public boolean incrementarSalario()
	{
		boolean comprobacion = false;
		Session s_sesion = null;
		Transaction t_transaccion = null;
		
		List<Employees> list_employees = null;
		
		try
		{	
			s_sesion = SessionManager.obtenerSesionNueva();
			superdao.setSesion(s_sesion);
			
			t_transaccion = s_sesion.beginTransaction();

			list_employees = employeesdao.obtenerEmpleados();
			
			for (Employees empleado : list_employees) 
			{
				empleado.setSalary(empleado.getSalary().multiply(new BigDecimal(SentenciasSQL.incrementosalarioemployees)));
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
		}
		return comprobacion;
	}
	
//	public Employees leerEmpleado(Employees empleado)
//	{
//		Employees empleadorecibido = empleado;
//		Session s_sesion = null;
//		
//		try
//		{	
//			s_sesion = SessionManager.obtenerSesionNueva();
//			superdao.setSesion(s_sesion);
//			
//			empleadorecibido = employeesdao.read(empleado);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			SessionManager.cerrarSession(s_sesion);
//		}
//		
//		return list_employees;
//	}
	
	public Employees leerEmpleadoID(int id_empleado)
	{
		Employees empleadorecibido = new Employees();
		Employees empleadodevuelta = new Employees();
		Session s_sesion = null;

		empleadorecibido.setEmployeeId(id_empleado);
		
		try
		{	
			s_sesion = SessionManager.obtenerSesionNueva();
			superdao.setSesion(s_sesion);
			
			empleadodevuelta = employeesdao.read(empleadorecibido);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionManager.cerrarSession(s_sesion);
		}
		
		return empleadodevuelta;
	}
	
	public boolean borrarEmpleadoID(int id_empleado)
	{
		Employees empleadorecibido = new Employees();
		Boolean comprobacion = false;
		Session s_sesion = null;

		empleadorecibido.setEmployeeId(id_empleado);
		
		try
		{	
			s_sesion = SessionManager.obtenerSesionNueva();
			superdao.setSesion(s_sesion);
			
			comprobacion = employeesdao.delete(empleadorecibido);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SessionManager.cerrarSession(s_sesion);
		}
		return comprobacion;
	}
	
	public boolean cerrarFactory()
	{
		boolean comprobacion;
		try
		{
			SessionManager.cerrarFactory();
			comprobacion = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			comprobacion = false;
		}
		return comprobacion;
	}
}
