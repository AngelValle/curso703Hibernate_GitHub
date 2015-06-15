package paquete.dao;

import java.util.List;

import paquete.clases.Departments;
import paquete.sentenciasSQL.SentenciasSQL;

public class DepartmentsDAO {

	private SuperDAO superdao = null;
	
	public DepartmentsDAO(SuperDAO superdao)
	{
		this.superdao = superdao;
	}
	
	public List recuperarListaDepartamentos()
	{
		List list_employees = superdao.getSesion().createSQLQuery(SentenciasSQL.recogerlistadepartments).list();
		return list_employees;
	}
}
