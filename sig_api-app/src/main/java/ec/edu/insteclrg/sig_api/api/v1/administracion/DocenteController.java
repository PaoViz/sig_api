package ec.edu.insteclrg.sig_api.api.v1.administracion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.sig_api.common.Constants;
import ec.edu.insteclrg.sig_api.domain.administracion.Docente;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.administracion.DocenteDTO;
import ec.edu.insteclrg.sig_api.service.administracion.DocenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_DOCENTE })
@Tag(name = "Docente", description = "Gestiona los docentes que getionan detro de la Institucion (ej. ING, Cristian Calle, etc")
public class DocenteController {

	@Autowired
	DocenteService service;
	
	@Operation(summary = "Lista los docentes de la institucion")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<DocenteDTO> list = service.findAll(new DocenteDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<DocenteDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary = "Guarda una nuevo docente en la institucion")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody DocenteDTO docenteDTO) {
		DocenteDTO docenteDTOResult  = service.save(docenteDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, 	docenteDTOResult), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Actualiza el docente guardado")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody DocenteDTO docenteDTO) {
		DocenteDTO resultDTO = service.update(docenteDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Recupera un docente por medio del id")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		DocenteDTO dto = new DocenteDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	
}
