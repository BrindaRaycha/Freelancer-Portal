/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;



/**
 *
 * @author brinda
 */
@FacesValidator("PasswordValidator")
public class PasswordValidator implements Validator{
FacesMessage msg;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       // Retrieve the value passed to this method
    String confirmPassword = (String) value;

    // Retrieve the temporary value from the password field
    UIInput passwordInput = (UIInput) component.findComponent("password");
    String password = (String) passwordInput.getLocalValue();
    if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
        msg = new FacesMessage("password validation faild","invalid password");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        throw new ValidatorException(msg);
    }

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
