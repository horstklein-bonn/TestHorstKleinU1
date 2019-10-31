package demo;

import java.util.List;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.PathParam;






@Stateless
public class PersRepository {
	@PersistenceContext(unitName = "HorstKleinU1")

	EntityManager em;

	public void save(PersEntity user) {
		em.persist(user);
		em.flush();
	}
	public List<PersEntity> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PersEntity> criteria = cb.createQuery(PersEntity.class);
		Root<PersEntity> member = criteria.from(PersEntity.class);

		criteria.select(member).orderBy(cb.asc(member.get("nachname")));
		return em.createQuery(criteria).getResultList();
	}
	
	public List<PersEntity> findAllOrderedByVorName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PersEntity> criteria = cb.createQuery(PersEntity.class);
		Root<PersEntity> member = criteria.from(PersEntity.class);

		criteria.select(member).orderBy(cb.asc(member.get("vorname")));
		return em.createQuery(criteria).getResultList();
	}
	
	public PersEntity findById(@PathParam("id") Integer id) {
		return em.find(PersEntity.class, id);
	}
	public void deleteById(PersEntity persent){
		em.remove(em.merge(persent));
		
		System.out.println("DDDDDDDDDDDDD");
		
	}
	
	

}
