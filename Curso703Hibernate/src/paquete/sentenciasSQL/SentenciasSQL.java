package paquete.sentenciasSQL;

import paquete.clases.Employees;

public class SentenciasSQL {
	
	public static String recogeremployees = "SELECT * FROM EMPLOYEES";
	
	public static String insertaremployees(Employees ObjectDTO)
	{
		String insertaremployees = "INSERT INTO EMPLOYEES VALUES "+"'"+ObjectDTO.getFirstName()+"'"+","+"'"+ObjectDTO.getLastName()+"'"+","+"'"+ObjectDTO.getEmail()+"'"+","+"'"+ObjectDTO.getPhoneNumber()+"'"+","+"'"+ObjectDTO.getHireDate()+"'"+","+"'"+ObjectDTO.getJobs()+"'"+","+"'"+ObjectDTO.getSalary()+"'";
		
		return insertaremployees;
	}
}
