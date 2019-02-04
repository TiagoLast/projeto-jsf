package br.com.projeto.converte;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.projeto.entity.ConvenioEntity;

//@FacesConverter(forClass = ConvenioEntity.class)
public class ConvenioConverter // implements Converter 

{

//	@Override
//	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
//		if (value != null && !value.isEmpty()) {
//			return (ConvenioEntity) uiComponent.getAttributes().get(value);
//		}
//		return null;
//	}
//
//	@Override
//	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
//		if (value instanceof ConvenioEntity) {
//			ConvenioEntity convenio = (ConvenioEntity) value;
//			if (convenio != null && convenio instanceof ConvenioEntity && convenio.getId() != null) {
//				uiComponent.getAttributes().put(convenio.getId().toString(), convenio);
//				return convenio.getId().toString();
//			}
//		}
//		return "";
//	}

}