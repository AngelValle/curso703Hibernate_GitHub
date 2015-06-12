package main;

import java.math.BigDecimal;
import java.util.Date;

import paquete.clases.Employees;
import paquete.servicios.EmployeesServices;
import java.util.Date;

public class MainServices {

	public static void main(String[] args) {
		
		EmployeesServices employeesservice = new EmployeesServices();
//		System.out.println("Comprobacion de Salario incrementado: "+employeesservice.incrementarSalario());
//		System.out.println(employeesservice.insertarEmployee(new Employees("Angel", "Valle", "angel.sine.leganes@gmail.com", "666555444", new Date(1993, 02, 01), new BigDecimal(20000))));
		employeesservice.recuperarListaMayorSalarioPorDepartamento();
	}

}
