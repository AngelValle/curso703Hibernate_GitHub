package paquete.interfaces;

import paquete.clases.Employees;

//import curso.ejemplos.basedatos.DTO_Employees;

public interface CRUD {
	
		 public boolean create (Employees ObjectDTO) throws Exception;		// Create
		 public Employees read (Employees ObjectDTO) throws Exception;		// Read
		 public Employees update (Employees ObjectDTO) throws Exception;	// Update
		 public boolean delete (Employees ObjectDTO) throws Exception;		// Delete
}
