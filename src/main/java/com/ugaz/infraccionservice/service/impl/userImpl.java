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
    public List<user> findByNombreContaining(String nombre) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public user findByNumDoc(String nrodoc) {
        // TODO Auto-generated method stub
        return null;
    }
	@Override
	public user create(user obj) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public user update(user obj) {
		// TODO Auto-generated method stub
		return null;
	}
    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        return 0;
    }
}
