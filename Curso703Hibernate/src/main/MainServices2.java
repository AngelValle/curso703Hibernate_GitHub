package main;

import paquete.clases.Employees;
import paquete.dao.EmployeesHibernateDAO;
import paquete.dao.EmployeesJDBCDAO;
import paquete.dao.EmployeesJPADAO;
import paquete.interfaces.RECUPERABLE;
import paquete.servicios.EmployeesServices2;

public class MainServices2 {
	
	public static void main(String[] args) {
		
		EmployeesServices2 es = new EmployeesServices2();
		
		RECUPERABLE o_dao1 = new EmployeesHibernateDAO();
		
		es.setO_dao(o_dao1);
		Object empleado1 = es.leerEmpleadoService(150);
		System.out.println(empleado1.toString());
		
		RECUPERABLE o_dao2 = new EmployeesJDBCDAO();
		
		es.setO_dao(o_dao2);
		Object empleado2 = es.leerEmpleadoService(150);
		System.out.println(empleado2.toString());
		
		RECUPERABLE o_dao3 = new EmployeesJPADAO();
		
		es.setO_dao(o_dao3);
		Object empleado3 = (Employees)es.leerEmpleadoService(150);
		System.out.println(empleado3.toString());
	}

}
