package ejemplo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Persona {

	@GetMapping("/")
	public List<Persona> index(){
		
	}
}
