package com.ugaz.infraccionservice.service;

import java.util.List;

import com.ugaz.infraccionservice.entity.Infraccion;

public interface infraccionService {
    public List<Infraccion> findAll();
	public Infraccion findById(int id);
	public Infraccion findByInfraccion(String infracccion);
    public Infraccion create(Infraccion obj);
    public Infraccion update(Infraccion obj);
    public int delete(int id);
}
