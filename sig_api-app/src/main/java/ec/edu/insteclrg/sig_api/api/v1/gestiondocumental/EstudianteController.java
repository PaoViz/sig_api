package ec.edu.insteclrg.sig_api.api.v1.gestiondocumental;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.sig_api.common.Constants;
import ec.edu.insteclrg.sig_api.domain.gestiondocumental.Estudiante;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.gestiondocumental.EstudianteDTO;
import ec.edu.insteclrg.sig_api.service.gestiondocumental.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = {Constants.URI_API_ESTUDIANTE})
@Tag(name = "estudiante", description = "Gestion de Estudiantes (ej. Almacena registros de certificados emitidos de los estudiantes.")
public class EstudianteController {
	
	@Autowired
	EstudianteService service;
	
	@Operation(summary = "Lista todos registros de certificados emitidos de los estudiantes")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<EstudianteDTO> list = service.findAll(new EstudianteDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<EstudianteDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary = "Guarda un nuevo certificado emitido de un estudiante")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody EstudianteDTO EstudianteDTO ) {
		EstudianteDTO EstudianteDTOResult = service.save(EstudianteDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, EstudianteDTOResult), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Recupera por id un certificado emitidos de un estudiante")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		EstudianteDTO dto = new EstudianteDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	@Operation(summary = "Eliminar por id un certificado emitido de un estudiante")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		EstudianteDTO dto = new EstudianteDTO();
		dto.setId(id);
		Optional<Estudiante> categoryOptional = service.find(dto);
	
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}
