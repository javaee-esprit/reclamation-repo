package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import persistance.Administrateur;
import persistance.Etudiant;
import persistance.Utilisateur;

@FacesConverter("identifiedUserConverter")
public class IdentifiedUserConverter implements Converter{

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return context
				.getApplication()
				.evaluateExpressionGet(
						context,
						"#{identity.identifiedUser}",
						Utilisateur.class
				);
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String equivalentString = null;
		if (value instanceof Administrateur) {
			equivalentString = ((Administrateur)value).getEmail().split("@")[0];
			
		}else if (value instanceof Etudiant) {
			equivalentString = ((Etudiant)value).getPrenom();
		}
		return equivalentString;
	}

}
