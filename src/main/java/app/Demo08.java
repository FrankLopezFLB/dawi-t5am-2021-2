package app;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Usuario;

public class Demo08 {
	//login
	public static void main(String[] args) {
		//obtener la conexion -> segund la unidad de persistencia
		// 1. fabrica el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// 2. crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//Validar un Usuario segun su usuario y clave
		
		String sql2="select u from Usuario u where u.usuario = :xusr and u.clave = :xcla";
		
		TypedQuery<Usuario>query =em.createQuery(sql2,Usuario.class);
		query.setParameter("xusr", "U002@gmail.com");
		query.setParameter("xcla", "10002");
		
		Usuario u= null;
		
		try {
			u=query.getSingleResult();
		} catch (Exception e) {
			
		}
		
		if(u==null) {
			System.out.println("Codigo No existe");
			
		}else {
			System.out.println("Bienvenido: "+u.getNombre());
			System.out.println(u);
		}
		
		em.close();
		
	}
}
