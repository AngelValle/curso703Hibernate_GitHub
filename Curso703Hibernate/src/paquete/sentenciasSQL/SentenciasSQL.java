package paquete.sentenciasSQL;

import paquete.clases.Employees;

public class SentenciasSQL {
	
	public static String recogeremployees = "SELECT * FROM EMPLOYEES ";
	public static String incrementosalarioemployees = "1.2";
	public static String recogerlistadepartments = "SELECT DISTINCT DEPARTMENT_ID FROM EMPLOYEES WHERE department_id IS NOT NULL";
	
	public static String recogeremployeesordensalary(int department_id)
	{
		String recogeremployeesordensalary = null;
		if(department_id==0){}
		else if(department_id!=0)
		{
			recogeremployeesordensalary = "SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = "+department_id+" ORDER BY SALARY DESC";
		}
		return recogeremployeesordensalary;
	}
	
	public static String recogeremployeesselecto(Employees ObjectDTO)
	{
		String recogeremployeesselecto = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = "+ObjectDTO.getEmployeeId();
		return recogeremployeesselecto;
	}
			
	public static String insertaremployees(Employees ObjectDTO)
	{
		String insertaremployees = "INSERT INTO EMPLOYEES VALUES "+"'"+ObjectDTO.getFirstName()+"'"+","+"'"+ObjectDTO.getLastName()+"'"+","+"'"+ObjectDTO.getEmail()+"'"+","+"'"+ObjectDTO.getPhoneNumber()+"'"+","+"'"+ObjectDTO.getHireDate()+"'"+","+"'"+ObjectDTO.getSalary()+"'";
		return insertaremployees;
	}
}
