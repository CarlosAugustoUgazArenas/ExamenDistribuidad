package com.ugaz.infraccionservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ugaz.infraccionservice.entity.user;

@Repository
public interface userRepository extends JpaRepository< user, Integer> {
	public user findByNombre(String nombre);
	public user findByNumDoc(String nrodoc);
	public List<user> findByNombreContaining(String nombre);    
}
