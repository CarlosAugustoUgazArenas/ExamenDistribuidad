package com.ugaz.infraccionservice.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Infraciones")
@EntityListeners(AuditingEntityListener.class)
public class Infraccion {
    @Id
	@Column(name="idInfraccion",columnDefinition="smallint")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInfraccion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="User_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private user idUsers; 
	
	@Column(name="DNI",nullable = false, length = 8)
	private String dni;
	
	@jakarta.persistence.Temporal(jakarta.persistence.TemporalType.DATE)
	private java.util.Date fecha;
	
	@Column(name="Falta", nullable = false, length = 3)
	private String falta;
	
	@Column(name="Infraccion", nullable = true, length = 200)
	private String infraccion;

	@Column(name="Estado",nullable=false)
	private Boolean estado;
}
