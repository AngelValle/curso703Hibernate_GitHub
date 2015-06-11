package main;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import paquete.clases.Countries;
import paquete.clases.Regions;

public class BuscarCountriesPorRegion {
	
	private static Configuration c_configuracion = null;
	private static StandardServiceRegistryBuilder b_builder = null;
	private static SessionFactory s_factory = null;
	private static Session s_sesion = null;
	private static Transaction t_transaccion = null;
	
	public static void mostrarRegionYPaises()
	{
		try
		{
			c_configuracion = new Configuration().configure();
			b_builder = new StandardServiceRegistryBuilder().applySettings(c_configuracion.getProperties());
			s_factory = c_configuracion.buildSessionFactory(b_builder.build());
			s_sesion = s_factory.openSession();
			t_transaccion = s_sesion.beginTransaction();
		
			@SuppressWarnings("unchecked")
			List<Regions> list_regions = s_sesion.createSQLQuery("SELECT * FROM REGIONS").addEntity(Regions.class).list();
			Iterator<Regions> it_regions = list_regions.iterator();
			
			while(it_regions.hasNext())
			{
				Regions region = it_regions.next();
				System.out.println(region);
				@SuppressWarnings("unchecked")
				Set<Countries> setcountries = region.getCountrieses();
				for (Countries countries : setcountries) 
				{
					System.out.println(countries);
				}
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			s_sesion.close();
			s_factory.close();
		}
	}
}
