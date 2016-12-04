/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import java.util.ArrayList;
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
@FacesValidator("validators.LoginReq")
public class LoginReq implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        String vvalue = String.valueOf(value);
        
        if(value.toString().length()<5)
        { 
            FacesMessage message = new FacesMessage("Имя должно быть не менее 5 букв");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message); 
        }
         
        else if(getArray().contains(vvalue))
        {
            FacesMessage message = new FacesMessage("Такие имена уже используются, введите другое имя ");
            message.setSeverity(FacesMessage.SEVERITY_FATAL);
            throw new ValidatorException(message); 
        }
        
        else if(value.toString().length()==0)
        {
            FacesMessage message = new FacesMessage("Это поле должно быть заполненным.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message); 
        }
        
        
    }
    
    private ArrayList<String> getArray()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Dmitrii");
        list.add("username");
        
        
        return list;
    }
}
