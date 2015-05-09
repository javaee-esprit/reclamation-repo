package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import persistance.TypeReclamation;
import services.reclamation.ReclamationServiceLocal;

@FacesConverter("typeReclamationConverter")
public class TypeReclamationConverter implements Converter{
	
	@Inject
	private ReclamationServiceLocal reclamationServiceLocal;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		TypeReclamation eqTypeReclamation = null;
		if (!value.trim().equals("")) {
			eqTypeReclamation  = reclamationServiceLocal.chercherTypeReclamationParType(value);
		}
		return eqTypeReclamation;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String eqString = null;
		if (value == null || value.equals("")) {
			eqString = "";
		}else{
			eqString = ((TypeReclamation)value).getType();
		}
		return eqString;
	}

}
