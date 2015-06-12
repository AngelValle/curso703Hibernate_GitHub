package paquete.dao;

import java.util.List;

import org.hibernate.Session;

import paquete.clases.Employees;
import paquete.interfaces.CRUD;
import paquete.sentenciasSQL.SentenciasSQL;

public class EmployeesDAO extends SuperDAO implements CRUD{
	
	private SuperDAO superdao = null;
	
	public EmployeesDAO(SuperDAO superdao)
	{
		this.superdao = superdao;
	}
	
	public List<Employees> obtenerEmpleados()
	{
		Session sesion = superdao.getSesion();
		@SuppressWarnings("unchecked")
		List<Employees> list_employees = sesion.createSQLQuery(SentenciasSQL.recogeremployees).addEntity(Employees.class).list();
		return list_employees;
	}
	
	@Override
	public boolean create(Employees ObjectDTO) throws Exception 
	{
		boolean comprobacion = false;
		Session sesion = superdao.getSesion();
		try
		{
			sesion.createSQLQuery(SentenciasSQL.insertaremployees(ObjectDTO));
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
