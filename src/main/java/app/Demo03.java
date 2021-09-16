package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo03 {
	public static void main(String[] args) {
		//obtener la conexion -> segund la unidad de persistencia
		// 1. fabrica el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// 2. crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//--proceso:registrar nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(20);
		
		
		// para reg y actualizar
		em.getTransaction().begin();
		em.remove(u);//-->para eliminar(va a borrar de la tabla/recomendable cambiar de estado)
		// 5. confirmar la transacción
		em.getTransaction().commit();
		System.out.println("Eliminacion ok");
		em.close();
		
	}
}
