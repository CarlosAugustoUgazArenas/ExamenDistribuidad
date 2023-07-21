package com.ugaz.infraccionservice.service;

import java.util.List;

import com.ugaz.infraccionservice.entity.user;

public interface userService {
	public List<user> findAll();
	public user findById(int id);
	public user findByNumDoc(String nrodoc);
	public List<user> findByNombreContaining(String nombre);
	public user create(user obj);
    public user update(user obj);
    public int delete(int id);
}
