package main;

import java.util.Iterator;
import java.util.List;

import paquete.clases.Employees;
import paquete.servicios.EmployeesServices;

public class MainServices {

	public static void main(String[] args) {
		
		EmployeesServices employeesservice = new EmployeesServices();
		List<Employees> l_employees = employeesservice.recuperarListaMayorSalarioPorDepartamento();
		
		
		// RECORREMOS Y COMPROBAMOS
		Iterator<Employees> it_employees = l_employees.iterator();
		while(it_employees.hasNext())
		{
			System.out.println(it_employees.next().toString());
		}
		
	}

}
