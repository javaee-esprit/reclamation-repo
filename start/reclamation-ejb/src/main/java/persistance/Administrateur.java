package persistance;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Administrateur
 * 
 */
@Entity
public class Administrateur extends Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;

	public Administrateur() {
		super();
	}

	public Administrateur(String email, String password, boolean actif) {
		super(email, password, actif);
	}

}
