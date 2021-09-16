package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo02 {
	public static void main(String[] args) {
		//obtener la conexion -> segund la unidad de persistencia
		// 1. fabrica el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// 2. crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//--proceso:registrar nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(20);
		u.setNombre("Eren");
		u.setApellido("Jeager");
		u.setUsuario("eren24@gmail.com");
		u.setClave("paloma");
		u.setFnacim("2021/08/24");
		u.setTipo(1);
		u.setEstado(1);
		
		// para reg y actualizar
		em.getTransaction().begin();
		em.merge(u);//-->para actualizar-> si existe el codigo/ pero si no existe lo registra
		// 5. confirmar la transacción
		em.getTransaction().commit();
		System.out.println("Actualizacion ok");
		em.close();
		
	}
}
