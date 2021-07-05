/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.*;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author brinda
 */
@Named("password")
@RequestScoped
public class password implements Validator {
    
    String password;   
String confirmPassword;   
public void validatePassword(FacesContext context, UIComponent toValidate, Object value) {   
        String confirm = (String) value;   
        UIInput passComp = (UIInput) toValidate.getAttributes().get("passwordComponent");   
        String password=(String)passComp.getValue();   
        if (!password.equals(confirm)) {   
            FacesMessage message = new FacesMessage("Password and Confirm Password Should match");   
            throw new ValidatorException(message);   
        }   
    }   

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
