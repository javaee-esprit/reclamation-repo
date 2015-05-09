package persistance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Reclamation
 * 
 */
@Entity
public class Reclamation implements Serializable {

	private int id;
	private String titre;
	private String description;
	private static final long serialVersionUID = 1L;

	private Etudiant etudiant;
	private TypeReclamation typeReclamation;

	public Reclamation() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@ManyToOne
	public TypeReclamation getTypeReclamation() {
		return typeReclamation;
	}

	public void setTypeReclamation(TypeReclamation typeReclamation) {
		this.typeReclamation = typeReclamation;
	}
}
