package main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import paquete.clases.Employees;

public class IncrementarSalarios {
	
	public static void mostrar()
	{
		Configuration c_configuracion = null;
		StandardServiceRegistryBuilder b_builder = null;
		SessionFactory s_factory = null;
		Session s_sesion = null;
		
		try
		{
			c_configuracion = new Configuration().configure();
			b_builder = new StandardServiceRegistryBuilder().applySettings(c_configuracion.getProperties());
			s_factory = c_configuracion.buildSessionFactory(b_builder.build());
			s_sesion = s_factory.openSession();
			
			@SuppressWarnings("unchecked")
			List<Employees> list_employees = s_sesion.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = 80").addEntity(Employees.class).list();
			Iterator<Employees> it_employees = list_employees.iterator();
			
			while(it_employees.hasNext())
			{
				System.out.println(it_employees.next());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			s_sesion.disconnect();
			s_sesion.close();
			s_factory.close();
		}
	}
	
	public static void incrementar()
	{
		Configuration c_configuracion = null;
		StandardServiceRegistryBuilder b_builder = null;
		SessionFactory s_factory = null;
		Session s_sesion = null;
		Transaction t_transaccion = null;
		
		try
		{	
			c_configuracion = new Configuration().configure();
			b_builder = new StandardServiceRegistryBuilder().applySettings(c_configuracion.getProperties());
			s_factory = c_configuracion.buildSessionFactory(b_builder.build());
			s_sesion = s_factory.openSession();
			t_transaccion = s_sesion.beginTransaction();
			
			@SuppressWarnings("unchecked")
			List<Employees> list_employees = s_sesion.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = 80").addEntity(Employees.class).list();
			Iterator<Employees> it_employees = list_employees.iterator();
			
			while(it_employees.hasNext())
			{
				Employees empleado = null;
				empleado = it_employees.next();
				empleado.setSalary(empleado.getSalary().multiply(new BigDecimal(1.2)));
			}
			t_transaccion.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			t_transaccion.rollback();
		}
		finally
		{
			s_sesion.disconnect();
			s_sesion.close();
			s_factory.close();
		}
	}
}
