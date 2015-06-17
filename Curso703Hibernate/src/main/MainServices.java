package main;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import paquete.clases.Employees;
import paquete.servicios.EmployeesServices;

public class MainServices {

	public static int pedirInt() {
		int numero = 0;
		Scanner sc = new Scanner(System.in);
		numero = sc.nextInt();
		return numero;
	}
	
	
	public static void main(String[] args) {
		
		EmployeesServices employeesservice = new EmployeesServices();
		boolean salir = false;
		
		while(salir==false)
		{
			int valorentrada;
			int departamento;
			int idempleado;
			List<Employees> l_employees;
			Employees empleado;
			
			System.out.println(" ================================================ ");
			System.out.println(" ||    1º Incrementar Salario                  || ");
			System.out.println(" ||    2º Recuperar Lista Mayor Asalariados    || ");
			System.out.println(" ||    3º Recuperar Lista Por Departamento     || ");
			System.out.println(" ||    4º Insertar Empleado                    || ");
			System.out.println(" ||    5º Buscar empleado por ID               || ");
			System.out.println(" ||    6º Salir (Cierra Factory)               || ");
			System.out.println(" ================================================ ");
			System.out.println();
			
			valorentrada = pedirInt();
			
			if (valorentrada==0) 
			{
				System.out.println("Por favor, ingrese un número valido.(1-6)");
				valorentrada = pedirInt();
			}
			
			switch (valorentrada) 
			{
			case 1: employeesservice.incrementarSalario();
				break;
			case 2: l_employees = employeesservice.recuperarListaMayorSalarioPorDepartamento();
					for (Employees employees : l_employees) 
					{
						System.out.println(employees);
					}
				break;
			case 3: System.out.println("Por favor, ingrese un numero de DEPARTAMENTO");
					departamento = pedirInt();
					l_employees = employeesservice.recuperarListaEmployeesPorDepartamento(departamento);
					for (Employees employees : l_employees) 
					{
						System.out.println(employees);
					}
				break;
			case 4: employeesservice.insertarEmployee(new Employees("Angel", "Valle", "email@email.com", "666777888", new Date(1993, 02, 01), new BigDecimal(80000)));
				break;
			case 5: System.out.println("Por favor, imgrese un ID de empleado");
					idempleado = pedirInt();
					empleado = employeesservice.leerEmpleadoID(idempleado);
					System.out.println(empleado);
				break;
			case 6: employeesservice.cerrarFactory();
					salir = true;
				break;
			}
		}
	}
}
