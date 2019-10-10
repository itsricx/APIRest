package com.ApiRest.ServicioRest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Pais {

	@Id @GeneratedValue
	private long Id;
	private String codigoISO;
	private String nombre;
}
