package main;

import paquete.servicios.EmployeesServices;

public class MainServices {

	public static void main(String[] args) {
		
		EmployeesServices employeesservice = new EmployeesServices();
		System.out.println("Comprobacion de Salario incrementado: "+employeesservice.incrementarSalario());
		
	}

}
