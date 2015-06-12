package paquete.dao;

import org.hibernate.Session;


public class SuperDAO {

	private Session sesion = null;

	public Session getSesion() {
		return sesion;
	}

	public void setSesion(Session session) {
		sesion = session;
	}
}
