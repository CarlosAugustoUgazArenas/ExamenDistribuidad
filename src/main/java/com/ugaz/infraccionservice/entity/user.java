package com.ugaz.infraccionservice.entity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="usuarios")
@EntityListeners(AuditingEntityListener.class)
public class user {
    @Id
	@Column(name="idUsers",columnDefinition="smallint")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsers;
	
	@Column(name="nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name="apellido", nullable = false, length = 100)
	private String apellido;
	
	@Column(name="numDoc", nullable = false, length = 15)
	private String numDoc;
	
	@Column(name="telefono", nullable = true, length = 20)
	private String telefono;
	
	@Column(name="email", nullable = true, length = 100)
	private String email;
	
	@Column(name="estado",nullable=false)
	private boolean estado;
	
}
