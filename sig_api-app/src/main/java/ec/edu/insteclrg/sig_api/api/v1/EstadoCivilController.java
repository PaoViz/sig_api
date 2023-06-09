package ec.edu.insteclrg.sig_api.api.v1;

import java.util.List;

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
import ec.edu.insteclrg.sig_api.dto.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.EstadoCivilDTO;
import ec.edu.insteclrg.sig_api.service.crud.EstadoCivilService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_ESTADO_CIVIL })
@Tag(name = "EstadoCivil", description = "Gestiona los estados civiles (ej. Soltero, Casado, etc.")
public class EstadoCivilController {
	
	@Autowired
	private EstadoCivilService service;
	
	@Operation(summary = "Lista todos los estados civiles")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<EstadoCivilDTO> list = service.findAll(new EstadoCivilDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<EstadoCivilDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda un nuevo estado civil")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody EstadoCivilDTO EstadoCivilDTO) {
		EstadoCivilDTO EstadoCivilDTOResult = service.save(EstadoCivilDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, EstadoCivilDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualiza un estado civil")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody EstadoCivilDTO EstadoCivilDTO) {
		EstadoCivilDTO resultDTO = service.update(EstadoCivilDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Recupera por id un estado civil")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		EstadoCivilDTO dto = new EstadoCivilDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}

}
