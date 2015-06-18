package paquete.dao;

import java.util.List;

import paquete.clases.Employees;
import paquete.interfaces.CRUD;
import paquete.sentenciasSQL.SentenciasSQL;


/**
 * Capa DAO de la clase DEPARTMENTS.
 * 
 * Esta clase dao contiene los metodos para operar con la clase a nivel BD.
 * @author Angel Valle
 *
 */
public class DepartmentsDAO extends SuperDAO implements CRUD{

	private SuperDAO superdao = null;
	
	/**
	 * Constructor sobrecargado que recoge un SuperDAO para compartir la misma session que la clase Service que lo llama.
	 * @param superdao
	 * SuperDAO que contiene la session desde la que vamos a hacer la transaccion.
	 */
	public DepartmentsDAO(SuperDAO superdao)
	{
		this.superdao = superdao;
	}
	
	/**
	 * Metodo que recoge todos los diferentes DEPARTMENT_ID de la tabla EMPLOYEES.
	 * @return
	 * List generico (de objetos) que contiene los diferentes DEPARTMENT_ID como Objetos.
	 */
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
