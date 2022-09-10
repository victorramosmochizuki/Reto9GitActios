
package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;



@FacesValidator(value = "correoValidator")
public class CorreoV implements Validator{

    private static final String EMAIL_PATTERN = "[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]";
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
     Pattern pattern = Pattern.compile(EMAIL_PATTERN);
     String email = ((String) value).trim();
        if (email.isEmpty()) {
            FacesMessage msg = new FacesMessage("Ingresar correo válido");
            throw  new ValidatorException(msg);
        }else{
        Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
            FacesMessage msg = new FacesMessage("Correo electronico inválido, formato correcto !#$%&'*+-/=?^_`{}|~@example.org");
            throw  new ValidatorException(msg);    
            }
            
            }
        }
        
        
    }

    
    

