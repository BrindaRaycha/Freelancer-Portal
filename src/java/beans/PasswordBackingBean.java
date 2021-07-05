/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import Entity.*;
import javax.faces.component.UIInput;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;

/**
 *
 * @author brinda
 */
@Named("passwordBacking")
@RequestScoped
@FacesValidator("com.tutorialspoint.test.PasswordBackingBean")
public class PasswordBackingBean implements Serializable,Validator {
    
    @Inject
    private CompanyTB company;
    
    private String passwordConfirm;

    public CompanyTB getCompany() {
        return company;
    }

    public void setCompany(CompanyTB company) {
        this.company = company;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
    public String doSomething() throws Exception {
        return "doSomething";
    }
    
    
     public void validatePasswordError(FacesContext context, UIComponent component,
            Object value) {

        if (!company.getCompanyOwnerPassword().equals(passwordConfirm)) {
            String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['nomatch']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
     
     public void validatePasswordCorrect(FacesContext context, UIComponent component,
        Object value) {

    // Retrieve the value passed to this method
    String confirmPassword = (String) value;

    // Retrieve the temporary value from the password field
    UIInput passwordInput = (UIInput) component.findComponent("password");
    String password = (String) passwordInput.getLocalValue();

    if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
        String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['nomatch']}", String.class);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
        throw new ValidatorException(msg);
    }
}

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
         if (!company.getCompanyOwnerPassword().equals(passwordConfirm)) {
            String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['nomatch']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
}
