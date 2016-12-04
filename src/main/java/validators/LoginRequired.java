/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Администратор
 */
@FacesValidator("validators.LoginRequired")
public class LoginRequired implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       if(value.toString().length()<5)
       {
        ResourceBundle bundle = ResourceBundle.getBundle("nls.messages" , FacesContext.getCurrentInstance().getViewRoot().getLocale());
        FacesMessage message = new FacesMessage(bundle.getString("login_required"));
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        throw new ValidatorException(message); 
       }
       }
    
}
