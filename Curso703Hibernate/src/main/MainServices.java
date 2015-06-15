package main;

import java.util.Iterator;
import java.util.List;

import paquete.clases.Employees;
import paquete.servicios.EmployeesServices;

public class MainServices {

	public static void main(String[] args) {
		
		EmployeesServices employeesservice = new EmployeesServices();
//		List<Employees> l_employees = employeesservice.recuperarListaMayorSalarioPorDepartamento();
//		List<Employees> l_employees2 = employeesservice.recuperarListaEmployeesPorDepartamento(10);
		Employees empleado = employeesservice.leerEmpleadoID(101);
		System.out.println(empleado);
		
		
		
		
		// RECORREMOS Y COMPROBAMOS
//		Iterator<Employees> it_employees2 = l_employees2.iterator();
//		while(it_employees2.hasNext())
//		{
//			System.out.println(it_employees2.next().toString());
//		}
		
		// RECORREMOS Y COMPROBAMOS
//		Iterator<Employees> it_employees = l_employees.iterator();
//		while(it_employees.hasNext())
//		{
//			System.out.println(it_employees.next().toString());
//		}
		
	}

}
