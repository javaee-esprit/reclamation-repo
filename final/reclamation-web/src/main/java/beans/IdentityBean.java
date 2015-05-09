package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistance.Administrateur;
import persistance.Etudiant;
import persistance.Utilisateur;

@ManagedBean(name = "identity")
@SessionScoped
public class IdentityBean {

	private Utilisateur identifiedUser;

	public IdentityBean() {
	}

	public Utilisateur getIdentifiedUser() {
		return identifiedUser;
	}

	public void setIdentifiedUser(Utilisateur identifiedUser) {
		this.identifiedUser = identifiedUser;
	}

	public Boolean hasRole(String role) {
		Boolean response = false;
		switch (role) {
		case "Admin":
			response = identifiedUser instanceof Administrateur;
			break;
		case "Etu":
			response = identifiedUser instanceof Etudiant;
			break;
		}
		return response;
	}

}
