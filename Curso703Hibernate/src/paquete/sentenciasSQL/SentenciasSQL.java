package paquete.sentenciasSQL;

import paquete.clases.Employees;

public class SentenciasSQL {
	
	public static String recogeremployees = "SELECT * FROM EMPLOYEES ";
	public static String incrementosalarioemployees = "1.2";
	public static String recogerlistadepartments = "SELECT DISTINCT DEPARTMENT_ID FROM EMPLOYEES WHERE department_id IS NOT NULL";
//	public static String recogerempleadomasasalariadodecadadepartamento = "SELECT * FROM EMPLOYEES WHERE (DEPARTMENT_ID, SALARY) IN (SELECT DEPARTMENT_ID, MAX(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID) ORDER BY DEPARTMENT_ID DESC";
	
	public static String recogeremployeesselecto(Employees ObjectDTO)
	{
		String recogeremployeesselecto = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = "+ObjectDTO.getEmployeeId();
		return recogeremployeesselecto;
	}
	
	public static String recogeremployeespordepartamento(int departamento)
	{
		String recogeremployeesselecto = "SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = "+departamento+" ORDER BY SALARY DESC";
		return recogeremployeesselecto;
	}
	
	public static String recogeremployeesselectoid(int ID)
	{
		String recogeremployeesselecto = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = "+ID;
		return recogeremployeesselecto;
	}
			
	public static String insertaremployees(Employees ObjectDTO)
	{
		String insertaremployees = "INSERT INTO EMPLOYEES VALUES "+"'"+ObjectDTO.getFirstName()+"'"+","+"'"+ObjectDTO.getLastName()+"'"+","+"'"+ObjectDTO.getEmail()+"'"+","+"'"+ObjectDTO.getPhoneNumber()+"'"+","+"'"+ObjectDTO.getHireDate()+"'"+","+"'"+ObjectDTO.getSalary()+"'";
		return insertaremployees;
	}
	
	public static String borraremployees(Employees ObjectDTO)
	{
		String borraremployees = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = "+ObjectDTO.getEmployeeId();
		return borraremployees;
	}
}
