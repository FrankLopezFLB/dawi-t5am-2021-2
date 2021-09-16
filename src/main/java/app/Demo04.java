package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo04 {
	public static void main(String[] args) {
		//obtener la conexion -> segund la unidad de persistencia
		// 1. fabrica el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// 2. crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//--proceso:obtener nuevo usuario
		Usuario u = em.find(Usuario.class, 20);//devuelve el objeto usuario segun la P.K.
		
		if(u==null) {
			System.out.println("Codigo No existe");
			
		}else {
			System.out.println("Bienvenido: "+u.getNombre());
			System.out.println(u);
		}
		
		em.close();
		
	}
}
