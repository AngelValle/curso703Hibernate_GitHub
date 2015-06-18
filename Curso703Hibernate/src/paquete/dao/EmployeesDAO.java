package paquete.dao;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;


import paquete.clases.Employees;
import paquete.interfaces.CRUD;
import paquete.sentenciasSQL.SentenciasSQL;


/**
 * Capa DAO de la clase EMPLOYEES.
 * 
 * Esta clase dao contiene los metodos para operar con la clase employees a nivel BD.
 * @author Angel Valle
 *
 */
public class EmployeesDAO extends SuperDAO implements CRUD{
	
	private SuperDAO superdao = null;
	
	/**
	 * Constructor sobrecargado que recoge un SuperDAO para compartir la misma session que la clase Service que lo llama
	 * @param superdao
	 * SuperDAO que contiene la session desde la que vamos a hacer la transaccion.
	 */
	public EmployeesDAO(SuperDAO superdao)
	{
		this.superdao = superdao;
	}
	
	/**
	 * Metodo que recoge el mayor asalariado de cada departamento (Dependiente de recuperarListaEmployeesPorDepartamento).
	 * 
	 * @return 
	 * List de Employees
	 */
	public List<Employees> recuperarListaMayorSalarioPorDepartamento()
	{
		List l_departments = null;
		List<Employees> l_employees = null;
		LinkedList<Employees> l_employees_ordenado = new LinkedList<Employees>();
		
		DepartmentsDAO departamento = new DepartmentsDAO(superdao);
		l_departments = departamento.recuperarListaDepartamentos();
				
		for (Object departament : l_departments) 
		{
			BigDecimal department = (BigDecimal)departament;
			l_employees = recuperarListaEmployeesPorDepartamento(department.intValue());
			l_employees_ordenado.add(l_employees.get(0));
			l_employees.clear();
		}
		return l_employees_ordenado;
	}
	
	/**
	 * Metodo que recoge los empleados de un departamento concreto.
	 * @param DEPARTMENT_ID
	 * Recoge un "int" que será el DEPARTMENT_ID
	 * @return
	 * List de Employees
	 */
	@SuppressWarnings("unchecked")
	public List<Employees> recuperarListaEmployeesPorDepartamento(int DEPARTMENT_ID)
	{
		List<Employees> l_employees = null;
		try
		{
			l_employees = superdao.getSesion().createSQLQuery(SentenciasSQL.recogeremployeespordepartamento(DEPARTMENT_ID)).addEntity(Employees.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return l_employees;
	}
	
	/**
	 * Metodo que recoge todos los empleados de la tabla EMPLOYEES.
	 * @return
	 * List de Employees
	 */
	@SuppressWarnings("unchecked")
	public List<Employees> obtenerEmpleados()
	{
		List<Employees> list_employees = null;
		try
		{
			list_employees = superdao.getSesion().createSQLQuery(SentenciasSQL.recogeremployees).addEntity(Employees.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list_employees;
	}
	
	@Override
	public Employees create(Employees ObjectDTO) throws Exception 
	{
		Employees empleado = null;
		
		try
		{
			superdao.getSesion().createSQLQuery(SentenciasSQL.insertaremployees(ObjectDTO));
			empleado = (Employees)superdao.getSesion().createSQLQuery(SentenciasSQL.recogeremployeesselecto(ObjectDTO)).uniqueResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return empleado;
	}

	@Override
	public Employees read(Employees ObjectDTO) throws Exception 
	{
		Employees empleadobuscado = null;
		try
		{
			empleadobuscado = (Employees)superdao.getSesion().createSQLQuery(SentenciasSQL.recogeremployeesselecto(ObjectDTO)).addEntity(Employees.class).uniqueResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return empleadobuscado;
	}

	@Override
	public Employees update(Employees ObjectDTO) throws Exception {
		return null;
	}

	@Override
	public boolean delete(Employees ObjectDTO) throws Exception 
	{
		boolean comprobacion = false;
		try
		{
			superdao.getSesion().createSQLQuery(SentenciasSQL.borraremployees(ObjectDTO));
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
