package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Usuario;

public class Demo07 {
	public static void main(String[] args) {
		//obtener la conexion -> segund la unidad de persistencia
		// 1. fabrica el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// 2. crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//--proceso:obtener listar usuario
		System.out.println("Listado de los usuarios");
		
		String sql="select u from Usuario u";//JPA u.codigo, u.etc
		
		List<Usuario>lstUsuario = em.createQuery(sql,Usuario.class).getResultList();
		
		System.out.println("Cantidad de usuarios: "+ lstUsuario.size());//para ver cantidad
		//para imprimir en consola el listado
		for(Usuario u:lstUsuario) {
			System.out.println(">>> "+u);
		}
		
		/////////////////listado por tipo (where)////////////////////////
		System.out.println("Listado de los usuarios por tipo");
		
		String sql2="select u from Usuario u where u.tipo= :xtipo";//JPA se usa la variable de la clase y se setea una variable con setParameter
		
		TypedQuery<Usuario> query = em.createQuery(sql2,Usuario.class);//para setear varias variables en listar
		query.setParameter("xtipo", 1);
		List<Usuario>lstUsuarioxtipo = query.getResultList();
		
		System.out.println("Cantidad de usuarios: "+ lstUsuarioxtipo.size());//para ver cantidad
		//para imprimir en consola el listado
		for(Usuario u:lstUsuarioxtipo) {
			System.out.println(">>> "+u);
		}
		em.close();
		
	}
}
