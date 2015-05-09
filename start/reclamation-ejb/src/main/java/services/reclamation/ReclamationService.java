package services.reclamation;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistance.Etudiant;
import persistance.Reclamation;
import persistance.TypeReclamation;

/**
 * Session Bean implementation class ReclamationService
 */
@Stateless
public class ReclamationService implements ReclamationServiceLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public ReclamationService() {
		// TODO Auto-generated constructor stub
	}

	public void ajouterReclamation(Reclamation reclamation) {
		entityManager.persist(reclamation);

	}

	public void ajouterTypeReclamation(TypeReclamation typeReclamation) {
		entityManager.merge(typeReclamation);

	}

	public List<Reclamation> listerReclamations() {
		Query query = entityManager.createQuery("select r from Reclalamtion r");
		return query.getResultList();
	}

	public boolean existeTypeReclalamtion(String type) {
		boolean exists = false;
		String jpql = "select case when (count(u) > 0)  then true else false end from TypeReclamation u where u.type=:type";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("type", type);
		exists = (Boolean) query.getSingleResult();
		return exists;
	}

	public List<TypeReclamation> listerTypeReclamations() {
		Query query = entityManager
				.createQuery("select r from TypeReclamation r");
		return query.getResultList();
	}

	public TypeReclamation chercherTypeReclamationParType(String type) {
		TypeReclamation found = null;
		Query query = entityManager
				.createQuery("select t from TypeReclamation t where t.type=:type");
		query.setParameter("type", type);
		try {
			found = (TypeReclamation) query.getSingleResult();
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO,"no type found");
		}

		return found;
	}

	public List<Reclamation> listerReclamationParEtudiant(Etudiant etudiant) {
		Query query = entityManager
				.createQuery("select distinct r from Reclamation r where r.etudiant=:e");
		query.setParameter("e", etudiant);
		return query.getResultList();
	}

}
