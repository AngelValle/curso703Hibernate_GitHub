package paquete.dao;

import java.util.List;

import paquete.clases.Employees;
import paquete.interfaces.CRUD;
import paquete.sentenciasSQL.SentenciasSQL;

public class DepartmentsDAO extends SuperDAO implements CRUD{

	private SuperDAO superdao = null;
	
	public DepartmentsDAO(SuperDAO superdao)
	{
		this.superdao = superdao;
	}
	
	public List recuperarListaDepartamentos()
	{
		List list_departments = superdao.getSesion().createSQLQuery(SentenciasSQL.recogerlistadepartments).list();
		return list_departments;
	}

	@Override
	public Employees create(Employees ObjectDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employees read(Employees ObjectDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employees update(Employees ObjectDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Employees ObjectDTO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
