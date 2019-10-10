package com.ApiRest.ServicioRest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Monumento {

	@Id @GeneratedValue
	private long Id;
	
	@ManyToOne
	private Ciudad ciudad;
	@ManyToOne
	private Pais pais;
	@OneToMany
	private Imagen imagen;
	private String nombre;
	private String descripcion;
}
