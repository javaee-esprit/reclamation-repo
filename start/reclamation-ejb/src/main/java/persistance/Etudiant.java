package persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Etudiant
 * 
 */
@Entity
public class Etudiant extends Utilisateur implements Serializable {

	private String nom;
	private String prenom;
	private static final long serialVersionUID = 1L;

	private List<Reclamation> reclamations;

	public Etudiant() {
		super();
	}

	public Etudiant(String email, String password, boolean actif, String nom, String prenom) {
		super(email, password,actif);
		this.nom = nom;
		this.prenom = prenom;
		// TODO Auto-generated constructor stub
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@OneToMany(mappedBy = "etudiant")
	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

}
