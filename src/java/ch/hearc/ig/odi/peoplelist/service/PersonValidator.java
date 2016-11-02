/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.peoplelist.service;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

/**
 *
 * @author dimitri.mella
 */
@FacesValidator("personValidator")
public class PersonValidator implements Validator {
    @Inject
    Services service;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        boolean matcher = service.matcher(value.toString());

        if (!matcher) {
            FacesMessage msg
                    = new FacesMessage(" Ajout personne plante.",
                            "Cette personne existe déjà");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);

            throw new ValidatorException(msg);
        }
    }

}
