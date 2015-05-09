package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistance.Etudiant;
import services.authentification.AuthentificationServiceLocal;

@ManagedBean( name = "accounts")
@ViewScoped
public class AccountsBean {
	
	@EJB
	private AuthentificationServiceLocal authentificationServiceLocal;
	
	private List<Etudiant> etudiants;
	
	public AccountsBean() {
	}
	
	@PostConstruct
	public void initModel(){
		etudiants = authentificationServiceLocal.listerEtudiants();
	}
	
	public String doToggleStudentState(Etudiant etudiant){
		String navigateTo = null;
		if (etudiant.isActif()) {
			etudiant.setActif(false);
		}else {
			etudiant.setActif(true);
		}
		authentificationServiceLocal.sauvegarderUtilisateur(etudiant);
		etudiants = authentificationServiceLocal.listerEtudiants();
		return navigateTo;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	

}
