package br.edu.infnet.simple;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.infnet.simple.model.Bid;
import br.edu.infnet.simple.model.Item;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mitjava");
		EntityManager em = emf.createEntityManager();

//    	
//    	em.getTransaction().begin();
//    	Usuario usuario = new Usuario();
//    	usuario.setEmail("edveloso@gmail.com");
//    	usuario.setNome("edveloso");
//    	em.persist(usuario);
//    	em.getTransaction().commit();
//    	em.close();
//    	emf.close();
//    	

//    	
//    	Usuario find = em.getReference(Usuario.class, 1);
//    	System.out.println(find);
//    	
//
//    	List<Usuario> lista = em.createQuery("select u from Usuario u where u.id > :id ")
//    			.setParameter("id", 3)
//    			.getResultList();
////    	

//		CriteriaBuilder builder = em.getCriteriaBuilder();
//		CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
//		Root<Usuario> from = query.from(Usuario.class);
//		Path<Integer> path = from.get("id");
//		TypedQuery<Usuario> tq = em.createQuery(query.select(from).where(builder.gt(path, 2)));
//
//		List<Usuario> lista = tq.getResultList();
//
//		for (Usuario usuario1 : lista) {
//			System.out.println(usuario1.getId());
//		}

//		CriteriaBuilder builder = em.getCriteriaBuilder();
//		CriteriaQuery<Usuario> q = builder.createQuery(Usuario.class);
//		Root<Usuario> u = q.from(Usuario.class);
//		Path<Integer> path = u.get("id");
//		
//		Expression<Boolean> restriction = builder.gt(path, Integer.getInteger("2"));
//		TypedQuery<Usuario> createQuery = em.createQuery(q.select(u).where(restriction));
//		List<Usuario> list = createQuery.getResultList();
//		for (Usuario usuario : lista) {
//			System.out.println(usuario.getId());
//		}

//		
//		em.getTransaction().begin();
//		Item item = new Item();
//		item.setCreateOn(new Date());
//		item.setName("car idea");
//		Bid bid = new Bid();
//		bid.setAmount(new BigDecimal(1200));
//		bid.setCreateOn(new Date());
//		item.addBid(bid);
//		em.persist(item);
//		em.persist(bid);
//		em.getTransaction().commit();
//		em.close();
//		emf.close();

		em.getTransaction().begin();
		Item item = em.find(Item.class, 1);
		Bid bid = new Bid();
		bid.setAmount(new BigDecimal(1500));
		bid.setCreateOn(new Date());
		item.addBid(bid);
		em.persist(bid);
		em.getTransaction().commit();
		em.clear();
		emf.close();

	}
}
