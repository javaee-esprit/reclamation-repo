package beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import persistance.Administrateur;
import persistance.Etudiant;
import persistance.Utilisateur;
import services.authentification.AuthentificationServiceLocal;

@ManagedBean( name="access")
@RequestScoped
public class AccessBean {
	
	@EJB
	private AuthentificationServiceLocal authentificationServiceLocal;
	
	@ManagedProperty("#{identity}")
	private IdentityBean identityBean;
	
	private String email;
	private String password;
	
	public AccessBean() {
	}

	public String getEmail() {
		return email;
	}
	
	public String doLogin(){
		String navigateTo = null;
		Utilisateur found = authentificationServiceLocal.authentifier(email, password);
		if (found != null && found.isActif()) {
			identityBean.setIdentifiedUser(found);
			if(found instanceof Administrateur){
				navigateTo = "/admin/home?faces-redirect=true";
			}else if (found instanceof Etudiant) {
				navigateTo = "/etu/home?faces-redirect=true";
			}
			
		}else {
			FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"NON AUTORISE",
					null
					
			));
		}
		return navigateTo;
	}
	
	public String doLogout(){
		String navigateTo = null;
		FacesContext
		.getCurrentInstance()
		.getExternalContext()
		.getSessionMap()
		.clear();
		navigateTo = "/login?faces-redirect=true";
		return navigateTo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}
	
	

}
