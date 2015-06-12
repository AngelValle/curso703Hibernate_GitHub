package paquete.dao;

import java.util.LinkedList;
import java.util.List;


import paquete.clases.Departments;
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
		List<Departments> l_departments = null;
		List<Employees> l_employees = null;
		LinkedList<Employees> l_employees_ordenado = new LinkedList<Employees>();
		
		DepartmentsDAO departamento = new DepartmentsDAO(superdao);
		l_departments = departamento.recuperarListaDepartamentos();
		
		for (Departments departments : l_departments) 
		{
			l_employees = superdao.getSesion().createSQLQuery(SentenciasSQL.recogeremployeesordensalary(departments.getDepartmentId())).addEntity(Employees.class).list();
			l_employees_ordenado.add(l_employees.get(1));
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
