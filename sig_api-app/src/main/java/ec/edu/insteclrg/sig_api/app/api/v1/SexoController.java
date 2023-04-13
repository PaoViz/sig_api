package ec.edu.insteclrg.sig_api.app.api.v1;

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

import ec.edu.insteclrg.sig_api.app.common.Constants;
import ec.edu.insteclrg.sig_api.dto.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.SexoDTO;
import ec.edu.insteclrg.sig_api.service.crud.SexoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_SEXO })
@Tag(name = "Sexo", description = "Gestiona Sexos (ej. Hombre, Mujer, etc.")
public class SexoController {
	
	@Autowired
	private SexoService service;
	
	@Operation(summary = "Lista todos los sexos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<SexoDTO> list = service.buscarTodo(new SexoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<SexoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda un nuevo Sexo")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody SexoDTO sexoDTO) {
		SexoDTO SexoDTOResult = service.guardar(sexoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, SexoDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualiza un Sexo")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody SexoDTO SexoDTO) {
		SexoDTO resultDTO = service.actualizar(SexoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Recupera por id un Sexo")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		SexoDTO dto = new SexoDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.buscar(dto)), HttpStatus.OK);
	}

}
