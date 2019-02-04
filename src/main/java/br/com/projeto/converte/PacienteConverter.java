package br.com.projeto.converte;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.projeto.entity.PacienteEntity;

//@FacesConverter(forClass = PacienteEntity.class)
public class PacienteConverter //implements Converter 
{

//	@Override
//	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
//		if (value != null && !value.isEmpty()) {
//			return (PacienteEntity) uiComponent.getAttributes().get(value);
//		}
//		return null;
//	}
//
//	@Override
//	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
//		if (value instanceof PacienteEntity) {
//			PacienteEntity paciente = (PacienteEntity) value;
//			if (paciente != null && paciente instanceof PacienteEntity && paciente.getId() != null) {
//				uiComponent.getAttributes().put(paciente.getId().toString(), paciente);
//				return paciente.getId().toString();
//			}
//		}
//		return "";
//	}

}