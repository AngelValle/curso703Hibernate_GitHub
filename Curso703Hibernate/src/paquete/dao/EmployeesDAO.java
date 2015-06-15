package paquete.dao;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;


import paquete.clases.Employees;
import paquete.interfaces.CRUD;
import paquete.sentenciasSQL.SentenciasSQL;

public class EmployeesDAO extends SuperDAO implements CRUD{
	
	private SuperDAO superdao = null;
	
	public EmployeesDAO(SuperDAO superdao)
	{
		this.superdao = superdao;
	}
	
	@SuppressWarnings("unchecked")
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
			l_employees = superdao.getSesion().createSQLQuery(SentenciasSQL.recogeremployeesordensalary((int)department.longValue())).addEntity(Employees.class).list();
			l_employees_ordenado.add(l_employees.get(0));
		}
		return l_employees_ordenado;
	}
	
	public List<Employees> obtenerEmpleados()
	{
		@SuppressWarnings("unchecked")
		
		List<Employees> list_employees = superdao.getSesion().createSQLQuery(SentenciasSQL.recogeremployees).addEntity(Employees.class).list();
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
	public Employees read(Employees ObjectDTO) throws Exception {
		return null;
	}

	@Override
	public Employees update(Employees ObjectDTO) throws Exception {
		return null;
	}

	@Override
	public boolean delete(Employees ObjectDTO) throws Exception {
		return false;
	}

	
	


}
