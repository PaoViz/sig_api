package ec.edu.insteclrg.sig_api.api.v1.general;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.sig_api.common.Constants;
import ec.edu.insteclrg.sig_api.domain.general.Persona;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.general.PersonaDTO;
import ec.edu.insteclrg.sig_api.service.general.PersonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_PERSONA })
@Tag(name = "Persona", description = "Gestiona a las personas(ej. Maria Coronel, Ricardo Perez, etc.")
public class PersonaController {
	
	@Autowired
	private PersonaService service;

	@Operation(summary = "Lista todas las personas")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<PersonaDTO> list = service.findAll(new PersonaDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<PersonaDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
			} else {
				return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
			}
		}

	@Operation(summary = "Guarda una nueva persona")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody PersonaDTO personaDTO) {
		PersonaDTO TipoConvenioDTOResult = service.save(personaDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, TipoConvenioDTOResult), HttpStatus.CREATED);
		}

	@Operation(summary = "Actualiza una persona")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody PersonaDTO personaDTO) {
		PersonaDTO resultDTO = service.update(personaDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
		}

	@Operation(summary = "Recupera por id una persona")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		PersonaDTO dto = new PersonaDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
		}
		
	@Operation(summary = "Recupera por numeroIdentificacion")
	@GetMapping(value = "{numero_identificacion}/archivo/numero_identificacion", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorNumeroIdentificacion(@Valid @PathVariable("numero_identificacion") String numeroIdentificacion) {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.buscarPorNumeroIdentificacion(numeroIdentificacion)), HttpStatus.OK);
	}
	
	
	
}
