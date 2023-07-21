package com.ugaz.infraccionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ugaz.infraccionservice.entity.Infraccion;

public interface infraccionRepository extends JpaRepository<Infraccion,Integer>{
    public Infraccion findByinfraccion(String infraccion);
}
