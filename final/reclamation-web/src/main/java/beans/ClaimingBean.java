package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import persistance.Etudiant;
import persistance.Reclamation;
import persistance.TypeReclamation;
import services.reclamation.ReclamationServiceLocal;

@ManagedBean( name = "claiming")
@ViewScoped
public class ClaimingBean {
	
	@EJB
	private ReclamationServiceLocal reclamationServiceLocal; 
	
	@ManagedProperty("#{identity.identifiedUser}")
	private Etudiant etudiant;
	
	private Reclamation reclamation;
	private List<Reclamation> reclamations;
	private List<TypeReclamation> typeReclamations;
	
	
	public ClaimingBean() {
	}
	
	@PostConstruct
	public void initModel(){
		reclamation = new Reclamation();
		reclamations = reclamationServiceLocal.listerReclamationParEtudiant(etudiant);
		typeReclamations = reclamationServiceLocal.listerTypeReclamations();
	}
	
	public String doAjouterReclamation(){
		String navigateTo = null;
		reclamation.setEtudiant(etudiant);
		reclamationServiceLocal.ajouterReclamation(reclamation);
		reclamations = reclamationServiceLocal.listerReclamationParEtudiant(etudiant);
		reclamation = new Reclamation();
		return navigateTo;
	}

	public Reclamation getReclamation() {
		return reclamation;
	}

	public void setReclamation(Reclamation reclamation) {
		this.reclamation = reclamation;
	}

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}
	
	public List<TypeReclamation> getTypeReclamations() {
		return typeReclamations;
	}

	public void setTypeReclamations(List<TypeReclamation> typeReclamations) {
		this.typeReclamations = typeReclamations;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	

}
