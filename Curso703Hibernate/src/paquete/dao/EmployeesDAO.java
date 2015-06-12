package paquete.dao;

import java.util.List;

import org.hibernate.Session;

import paquete.clases.Employees;
import paquete.interfaces.CRUD;

public class EmployeesDAO extends SuperDAO implements CRUD{
	
	public List<Employees> obtenerEmpleados()
	{
		Session sesion = SuperDAO.getSesion();
		@SuppressWarnings("unchecked")
		List<Employees> list_employees = sesion.createSQLQuery("SELECT * FROM EMPLOYEES").addEntity(Employees.class).list();
		return list_employees;
	}
	
	@Override
	public boolean create(Employees ObjectDTO) throws Exception 
	{
		boolean comprobacion = false;
		Session sesion = SuperDAO.getSesion();
		try
		{
			sesion.createSQLQuery("INSERT INTO EMPLOYEES VALUES "+"'"+ObjectDTO.getFirstName()+"'"+","+"'"+ObjectDTO.getLastName()+"'"+","+"'"+ObjectDTO.getEmail()+"'"+","+"'"+ObjectDTO.getPhoneNumber()+"'"+","+"'"+ObjectDTO.getHireDate()+"'"+","+"'"+ObjectDTO.getJobs()+"'"+","+"'"+ObjectDTO.getSalary()+"'");
			comprobacion = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			comprobacion = false;
		}
		return comprobacion;
		
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
