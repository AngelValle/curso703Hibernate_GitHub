package paquete.servicios;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

import paquete.clases.Employees;
import paquete.conexiones.SessionManager;
import paquete.dao.EmployeesDAO;
import paquete.dao.SuperDAO;
import paquete.sentenciasSQL.SentenciasSQL;

/**
 * Capa SERVICE de la clase EMPLOYEES.
 * 
 * Esta clase service contiene los metodos para operar con la clase employees.
 * @author Angel Valle
 * 
 */
public class EmployeesServices {
	
	private final static Logger logger = Logger.getLogger("mylog");
	private SuperDAO superdao = null;
	private EmployeesDAO employeesdao = null;
	
	/**
	 * Constructor que crea un SuperDAO(Clase que contiene una session) y hace una instancia de employeesdao pasandole el mismo SuperDAO para compartir session.
	 */
	public EmployeesServices()
	{
		superdao = new SuperDAO();
		employeesdao = new EmployeesDAO(superdao);
	}
	
	/**
	 * Metodo que recoge el mayor asalariado de cada departamento.
	 * 
	 * @return 
	 * List de Employees
	 */
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
			logger.fatal("ERROR AL RECUPERAR LISTA POR MAYOR SALARIO DE CADA DEPARTAMENTO.");
			e.printStackTrace();
		}
		finally
		{
			SessionManager.cerrarSession(s_sesion);
		}
		logger.info("LA LISTA DE EMPLEADOS MAYOR ASALARIADOS POR DEPARTAMENTO HA SIDO RECUPERADA EXITOSAMENTE.");
		return list_employees;
	}
	
	/**
	 * Metodo que recoge los empleados de un departamento concreto.
	 * @param DEPARTMENT_ID
	 * Recoge un "int" que será el DEPARTMENT_ID
	 * @return
	 * List de Employees
	 */
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
			logger.fatal("ERROR AL RECUPERAR LISTA DE EMPLEADOS POR DEPARTAMENTO_ID.");
			e.printStackTrace();
		}
		finally
		{
			SessionManager.cerrarSession(s_sesion);
		}
		logger.info("LA LISTA DE EMPLEADOS POR DEPARTAMENTO_ID HA SIDO RECUPERADA EXITOSAMENTE.");
		return list_employees;
	}
	
	/**
	 * Metodo utilizado para insertar un empleado en la base de datos EMPLOYEES.
	 * @param employee
	 * Objeto Empleado que posteriormente insertaremos en la base de datos.
	 * @return
	 * Nos devuelve un Employee, resultado de una consulta a la BD del Employee insertado anteriormente.
	 */
	public Employees insertarEmployee(Employees employee) // No funciona, comprobar.
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
			logger.fatal("ERROR AL INSERTAR EMPLEADO EN LA TABLA EMPLOYEES.");
			e.printStackTrace();
			t_transaccion.rollback();
		}
		finally
		{
			SessionManager.cerrarSession(s_sesion);
		}
		logger.info("EL EMPLEADO HA SIDO INSERTADO EXITOSAMENTE.");
		return employeeinsertado;
	}
	
	/**
	 * Metodo para incrementar a todos los empleados el salario, SentenciasSQL.incrementosalarioemployees = Porcentaje de incremento.
	 * @return
	 * Nos devuelve un Boolean como comprobacion del metodo. True = Echo , False = Error.
	 */
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
			logger.fatal("ERROR AL INCREMENTAR SALARIOS DE EMPLEADOS EN LA TABLA EMPLOYEES.");
			e.printStackTrace();
			t_transaccion.rollback();
		}
		finally
		{
			SessionManager.cerrarSession(s_sesion);
		}
		logger.info("EL SALARIO DE LOS EMPLEADOS DE LA TABLA EMPLOYEES HA SIDO INCREMENTADO EXITOSAMENTE.");
		return comprobacion;
	}
	
	/**
	 * Metodo para leer un empleado (Employee) de la BD.
	 * @param id_empleado
	 * Recogemos un INT que posteriormente utilizaremos para su busqueda por Employee_ID
	 * @return
	 * Nos devuelve un empleado (Employee) leido.
	 */
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
			logger.fatal("ERROR AL LEER EMPLEADO DE LA TABLA EMPLOYEES.");
			e.printStackTrace();
		}
		finally
		{
			SessionManager.cerrarSession(s_sesion);
		}
		logger.info("EL EMPLEADO HA SIDO LEIDO EXITOSAMENTE.");
		return empleadodevuelta;
	}
	
	/**
	 * Metodo para borrar un empleado de la BD.
	 * @param id_empleado
	 * Recogemos un INT que posteriormente usaremos para borrar el empleado por Employee_ID
	 * @return
	 * Nos devuelve un boolean con la comprobacion del metodo, True = Echo, False = Error.
	 */
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
			logger.fatal("ERROR AL BORRAR EMPLEADO DE LA TABLA EMPLOYEES.");
			e.printStackTrace();
		}
		finally
		{
			SessionManager.cerrarSession(s_sesion);
		}
		logger.info("EL EMPLEADO HA SIDO BORRADO EXITOSAMENTE.");
		return comprobacion;
	}
	
	/**
	 * Metodo obligatorio de uso final para cerrar el factory del SuperDAO.
	 * @return
	 * Nos devuelve un boolean con la comprobacion del metodo, True = Echo, False = Error.
	 */
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
			logger.fatal("ERROR AL CERRAR LA SESSION FACTORY.");
			e.printStackTrace();
			comprobacion = false;
		}
		logger.info("LA SESSION FACTORY HA SIDO CERRADA EXITOSAMENTE.");
		return comprobacion;
	}
}
