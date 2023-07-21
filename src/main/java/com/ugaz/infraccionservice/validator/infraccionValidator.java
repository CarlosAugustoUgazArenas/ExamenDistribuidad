package com.ugaz.infraccionservice.validator;

import com.ugaz.infraccionservice.entity.Infraccion;
import com.ugaz.infraccionservice.exceptions.ValidateServiceException;

public class infraccionValidator {
    public static void save(Infraccion infraccion) {
		
		if(infraccion.getInfraccion().length()>100) {
			throw new ValidateServiceException("La descripcion es muy extensa");
		}/* 
		if(infraccion.getPago()==null) {
			throw new ValidateServiceException("El pago es requerido");
		}
		if(infraccion.getPago() <= 0) {
			throw new ValidateServiceException("El pago debe ser mayor a cero");
		}  */
	}
}
