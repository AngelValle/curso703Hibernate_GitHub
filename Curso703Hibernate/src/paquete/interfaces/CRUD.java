package paquete.interfaces;

import paquete.clases.Employees;

//import curso.ejemplos.basedatos.DTO_Employees;
/**
 * Interfaz CRUD para EMPLOYEES, contiene los metodos: Insertar(create), Leer(read), Actualizar(update) y Borrar(delete).
 * @author Angel Valle
 *
 */
public interface CRUD {
		/**
		 * Metodo de la interfaz CRUD definido para insertar un empleado en la base de datos.
		 * 
		 * @param ObjectDTO
		 * Objeto Employees que insertaremos en la base de datos.
		 * @return
		 * Nos devuelve un Objeto Employees (Consulta a la base de datos del objeto insertado)
		 * @throws Exception
		 * Puede dar Excepcion SQL.
		 */
		 public Employees create (Employees ObjectDTO) throws Exception;	// Create
		 /**
		 * Metodo de la interfaz CRUD definido para leer un empleado de la base de datos.
		 * 
		 * @param ObjectDTO
		 * Objeto Employees que leeremos en la base de datos.
		 * @return
		 * Nos devuelve un Objeto Employees (Consulta a la base de datos del objeto leido)
		 * @throws Exception
		 * Puede dar Excepcion SQL.
		 */
		 public Employees read (Employees ObjectDTO) throws Exception;		// Read
		 /**
		 * Metodo de la interfaz CRUD definido para actualizar un empleado de la base de datos.
		 * 
		 * @param ObjectDTO
		 * Objeto Employees que actualizaremos en la base de datos.
		 * @return
		 * Nos devuelve un Objeto Employees (Consulta a la base de datos del objeto actualizado)
		 * @throws Exception
		 * Puede dar Excepcion SQL.
		 */
		 public Employees update (Employees ObjectDTO) throws Exception;	// Update
		 /**
		 * Metodo de la interfaz CRUD definido para borrar un empleado de la base de datos.
		 * 
		 * @param ObjectDTO
		 * Objeto Employees que borraremos de la base de datos.
		 * @return
		 * Nos devuelve un boolean con la comprobacion del metodo, True = Echo, False = Error.
		 * @throws Exception
		 * Puede dar Excepcion SQL.
		 */
		 public boolean delete (Employees ObjectDTO) throws Exception;		// Delete
}
