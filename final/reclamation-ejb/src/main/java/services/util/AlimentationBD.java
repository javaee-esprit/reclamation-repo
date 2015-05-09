package services.util;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import persistance.Administrateur;
import persistance.Etudiant;
import persistance.TypeReclamation;
import persistance.Utilisateur;
import services.authentification.AuthentificationServiceLocal;
import services.reclamation.ReclamationServiceLocal;

/**
 * Session Bean implementation class AlimentationBD
 */
@Singleton
@Startup
public class AlimentationBD {

	@EJB
	AuthentificationServiceLocal authentificationService;
	@EJB
	ReclamationServiceLocal reclamationService;

	public AlimentationBD() {
	}

	@PostConstruct
	public void addData() {
		
		if (!authentificationService.existeEmail("user1@esprit.tn")) {
			Utilisateur utilisateur = new Etudiant("user1@esprit.tn", "user1", true,
					"Tounsi", "Sabri");
			authentificationService.sauvegarderUtilisateur(utilisateur);

		}
		
		if (!authentificationService.existeEmail("user2@esprit.tn")) {
			Utilisateur utilisateur = new Etudiant("user2@esprit.tn", "user2", true,
					"Ben Slimane", "Amina");
			authentificationService.sauvegarderUtilisateur(utilisateur);

		}
		if (!authentificationService.existeEmail("user3@esprit.tn")) {
			Utilisateur utilisateur = new Etudiant("user3@esprit.tn", "user3", true,
					"Ben Slah", "Ahmed");
			authentificationService.sauvegarderUtilisateur(utilisateur);

		}
		
		if (!authentificationService.existeEmail("admin@esprit.tn")) {
			Utilisateur utilisateur = new Administrateur("admin@esprit.tn", "admin", true);
			authentificationService.sauvegarderUtilisateur(utilisateur);

		}
		
		if (!reclamationService.existeTypeReclalamtion("Administrative")) {
			TypeReclamation typeReclamation = new TypeReclamation(
					"Administrative");
			reclamationService.ajouterTypeReclamation(typeReclamation);
		}
		if (!reclamationService.existeTypeReclalamtion("P�dagogique")) {
			TypeReclamation typeReclamation = new TypeReclamation("P�dagogique");
			reclamationService.ajouterTypeReclamation(typeReclamation);
		}
		if (!reclamationService.existeTypeReclalamtion("Mat�riel d�fectueux")) {
			TypeReclamation typeReclamation = new TypeReclamation(
					"Mat�riel d�fectueux");
			reclamationService.ajouterTypeReclamation(typeReclamation);
		}
	}
}
