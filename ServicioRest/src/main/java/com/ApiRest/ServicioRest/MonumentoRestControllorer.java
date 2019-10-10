package com.ApiRest.ServicioRest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/monumento")
public class MonumentoRestControllorer {

	private final MonumentoRepository monumentorepository;
	
	@GetMapping("/")
	public ResponseEntity<?> index() {
		List<Monumento> result = monumentorepository.findAll();
		if (result.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			
			  
			
			return ResponseEntity.ok(result);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> unMonumento(@PathVariable Optional<Long> id) {
		Long theId = id.orElse(-1L);
		Monumento m = monumentorepository.findById(theId).orElse(null);
		return (m == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(m);

	}

	@PostMapping("/")
	public ResponseEntity<?> nuevoMonumento(@RequestBody Monumento monumento) {
		Monumento m = monumentorepository.save(monumento);
		return ResponseEntity
				.created(URI.create(String.format("http://localhost:8080/monumento/%s", m.getId())))
				.body(m);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editarMonumento(@PathVariable Optional<Long> id, @RequestBody Monumento monumento) {
		Long theId = id.orElse(-1L);
		
		return monumentorepository.findById(theId)
				.map(m -> {
					m.setCiudad(monumento.getCiudad());
					m.setDescripcion(monumento.getDescripcion());
					m.setImagen(monumento.getImagen());
					m.setNombre(monumento.getNombre());
					m.setPais(monumento.getPais());
					
					return ResponseEntity.ok(monumentorepository.save(m));
				}).orElse(ResponseEntity.notFound().build());
		
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMonumento(@PathVariable Optional<Long> id) {
		Long theId = id.orElse(-1L);
		Monumento p = monumentorepository.findById(theId).orElse(null);
		
		if (p == null)
			return ResponseEntity.notFound().build();
		else {
			monumentorepository.delete(p);
			return ResponseEntity.noContent().build();
		}

	}
}
