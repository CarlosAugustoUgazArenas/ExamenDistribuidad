package com.ugaz.infraccionservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ugaz.infraccionservice.entity.user;
import com.ugaz.infraccionservice.exceptions.GeneralServiceException;
import com.ugaz.infraccionservice.exceptions.NoDataFoundException;
import com.ugaz.infraccionservice.exceptions.ValidateServiceException;
import com.ugaz.infraccionservice.repository.userRepository;
import com.ugaz.infraccionservice.service.userService;
import com.ugaz.infraccionservice.validator.userValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class userImpl implements userService {
    
    @Autowired
	private userRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<user> findAll() {
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
	@Transactional(readOnly = true)
	public user findById(int id) {
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
	@Transactional(readOnly = true)
    public user findByNumDoc(String nrodoc) {
        try {
			return repository.findByNumDoc(nrodoc);
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
    }
    @Override
	@Transactional(readOnly = true)
    public List<user> findByNombreContaining(String nombre) {
        try {
			return repository.findByNombreContaining(nombre);
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
	public user create(user obj) {
		try {
			//Validación
			userValidator.save(obj);
			user user = findByNumDoc(obj.getNumDoc());
			if(user!=null) {
				throw new ValidateServiceException("Ya hay un registro con el numero del documento");
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
	public user update(user obj) {
		try {
			userValidator.save(obj);
			user userDb=findById(obj.getIdUsers());
			if(userDb==null) {
				throw new ValidateServiceException("No hay un registro con ese ID");
			}
			//Validación de nombre repetido
			user persona=findByNumDoc(obj.getNumDoc());
			if(persona!=null && obj.getIdUsers()!=persona.getIdUsers()) {
				throw new ValidateServiceException("Ya hay un registro con ese DNI");
			}
			//Actualizamos 
			userDb.setNombre(obj.getNombre());
			userDb.setApellido(obj.getApellido());
			userDb.setEmail(obj.getEmail());
			userDb.setNumDoc(obj.getNumDoc());
			userDb.setTelefono(obj.getTelefono());
			
			return repository.save(userDb);
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
			user personaDb= findById(id);
			if(personaDb==null) {
				return 0;
			}else {
				personaDb.setEstado(false);
				repository.save(personaDb);
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
