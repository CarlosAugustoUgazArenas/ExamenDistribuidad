package com.ugaz.infraccionservice.validator;

import com.ugaz.infraccionservice.entity.user;
import com.ugaz.infraccionservice.exceptions.ValidateServiceException;

public class userValidator {
    public static void save(user persona) {
		if(persona.getNumDoc() == null || persona.getNumDoc().trim().isEmpty()) {
			throw new ValidateServiceException("El numero de documento es requerido");
		}
		if(persona.getNombre().length()>100) {
			throw new ValidateServiceException("El nombre es muy extenso");
		}
		if(persona.getApellido() == null) {
			throw new ValidateServiceException("El apellidos es requerido");
		}
		
	}
}
