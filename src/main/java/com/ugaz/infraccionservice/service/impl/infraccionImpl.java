package com.ugaz.infraccionservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ugaz.infraccionservice.entity.Infraccion;
import com.ugaz.infraccionservice.exceptions.GeneralServiceException;
import com.ugaz.infraccionservice.exceptions.NoDataFoundException;
import com.ugaz.infraccionservice.exceptions.ValidateServiceException;
import com.ugaz.infraccionservice.repository.infraccionRepository;
import com.ugaz.infraccionservice.service.infraccionService;
import com.ugaz.infraccionservice.validator.infraccionValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class infraccionImpl implements infraccionService{
    
     @Autowired
	private infraccionRepository repository;

     @Override
    public List<Infraccion> findAll() {
        try {
			return repository.findAll();
		
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
    }
    @Override
    public Infraccion findById(int id) {
        try {
			return repository.findById(id).orElse(null);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
    }
    
    @Override
    public Infraccion findByInfraccion(String infraccion) {
        try {
			return repository.findByinfraccion(infraccion);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
    }
    @Override
	public Infraccion create(Infraccion obj) {
		try {
			//Validación
			infraccionValidator.save(obj);
			Infraccion infraccion = findByInfraccion(obj.getInfraccion());
			if(infraccion!=null) {
				throw new ValidateServiceException("Ya hay una Infraccion con esa descripcion");
			}
			//Guardamos
			obj.setEstado(true);
			return repository.save(obj);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public Infraccion update(Infraccion obj) {
		try {
			infraccionValidator.save(obj);
			Infraccion infraccionDb=findById(obj.getIdInfraccion());
			if(infraccionDb==null) {
				throw new ValidateServiceException("No hay un registro con ese ID");
			}
			//Validación de ...
            			
			//Actualizamos la Infraccion
			infraccionDb.setInfraccion(obj.getInfraccion());
			infraccionDb.setFalta(obj.getFalta());
			infraccionDb.setIdUsers(obj.getIdUsers());
			return repository.save(infraccionDb);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Infraccion infraccionDb= findById(id);
			if(infraccionDb==null) {
				return 0;
			}else {
				infraccionDb.setEstado(false);
				repository.save(infraccionDb);
				return 1;
			}
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}
   

}
