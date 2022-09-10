/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value ="MinimoPalabrasV")
public class MinimoPalabrasV implements Validator{

    @Override
    public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
         int cantidadDeEspacios = 0;
        // Recorremos la cadena:
        for (int i = 0; i < ((String)arg2).length(); i++) {
            // Si el carácter en [i] es un espacio (' ') aumentamos el contador 
            if (((String)arg2).charAt(i) == ' ') cantidadDeEspacios++;
        }
        
      if (cantidadDeEspacios <12) {
         throw new ValidatorException(new FacesMessage("Al menos más de 12 palabras "));
      }
    }
}
