package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import modelo.Usuario;

public class Demo09 {
	public static void main(String[] args) {
		//obtener la conexion -> segund la unidad de persistencia
		// 1. fabrica el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// 2. crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//Validar un Usuario segun su usuario y clave->usar stored procedures
		
		String sql2="{call usp_validaAcceso (?, ?)}";
		
		Query query =em.createNativeQuery(sql2,Usuario.class);
		query.setParameter(1, "U002@gmail.com");
		query.setParameter(2, "10002");
		
		Usuario u= null;
		
		try {
			u=(Usuario) query.getSingleResult();
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
