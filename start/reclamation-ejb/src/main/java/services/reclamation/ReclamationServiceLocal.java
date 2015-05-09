package services.reclamation;

import java.util.List;

import javax.ejb.Local;

import persistance.Etudiant;
import persistance.Reclamation;
import persistance.TypeReclamation;

@Local
public interface ReclamationServiceLocal {
	 void ajouterReclamation(Reclamation reclamation);
	 void ajouterTypeReclamation(TypeReclamation typeReclamation);
	 List<Reclamation> listerReclamations();
	 List<TypeReclamation> listerTypeReclamations();
	 boolean existeTypeReclalamtion(String type);
	 TypeReclamation chercherTypeReclamationParType(String type);
	 List<Reclamation> listerReclamationParEtudiant(Etudiant etudiant);
}
