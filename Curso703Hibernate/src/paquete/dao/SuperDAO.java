package paquete.dao;

import org.hibernate.Session;


public class SuperDAO {

	private static Session sesion = null;

	public static Session getSesion() {
		return sesion;
	}

	public static void setSesion(Session session) {
		sesion = session;
	}
}
