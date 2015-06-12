package paquete.conexiones;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionManager {
	
	private static Configuration c_configuracion = new Configuration().configure();
	private static StandardServiceRegistryBuilder b_builder = new StandardServiceRegistryBuilder().applySettings(c_configuracion.getProperties());
	private static SessionFactory s_factory = c_configuracion.buildSessionFactory(b_builder.build()); // PATRON "SINGLETON" : CREAMOS UN UNICO SessionFactory.
	
	private SessionManager (){} // PATRON "SINGLETON" : CONSTRUCTOR PRIVADO.
	
	public static SessionFactory getSessionFactory ()
	{
		return s_factory;
	}
	
	public static Session obtenerSesionNueva ()
	{
		return s_factory.openSession();
	}
	
	public static void cerrarSession (Session sesion)
	{
		sesion.close();
	}
	
	public static void cerrarFactory()
	{
		s_factory.close();
	}
}
