/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author brinda
 */
@FacesValidator(value="fileUploadValidator")
public class FileUploadValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Part file = (Part) value;
 
        FacesMessage message=null;
 
        try {
 
            if (file==null || file.getSize()<=0 || file.getContentType().isEmpty() ){
                message=new FacesMessage("Select a valid file");}
            else if (!file.getContentType().endsWith("pdf")){
                message=new FacesMessage("Select PDF file");}
            else if (file.getSize()>2000000){
                 message=new FacesMessage("File size too big. File size allowed  is less than or equal to 2 MB.");
            }
            if (message!=null && !message.getDetail().isEmpty())
                {
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(message );
                }
 
        } catch (Exception ex) {
               throw new ValidatorException(new FacesMessage(ex.getMessage()));
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
