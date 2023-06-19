package ec.edu.insteclrg.sig_api.api.v1.administracion;

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
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.administracion.Tipo_IdentificacionDTO;
import ec.edu.insteclrg.sig_api.service.administracion.TipoIdentificacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_TIPO_IDENTIFICACION })
@Tag(name = "Tipo_Identificacion", description = "Gestiona Tipos de identificacion (ej. Cedula, Pasaporte, etc.")
public class TipoIdentificacionController {
	
	@Autowired
	private TipoIdentificacionService service;
	
	@Operation(summary = "Lista todos los tipos de identificacion")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<Tipo_IdentificacionDTO> list = service.findAll(new Tipo_IdentificacionDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<Tipo_IdentificacionDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda un nuevo tipo de identificacion")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody Tipo_IdentificacionDTO Tipo_IdentificacionDTO) {
		Tipo_IdentificacionDTO Tipo_IdentificacionDTOResult = service.save(Tipo_IdentificacionDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, Tipo_IdentificacionDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualiza un tipo de identificacion")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody Tipo_IdentificacionDTO Tipo_IdentificacionDTO) {
		Tipo_IdentificacionDTO resultDTO = service.update(Tipo_IdentificacionDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Recupera por id un tipo de identificacion")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		Tipo_IdentificacionDTO dto = new Tipo_IdentificacionDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}

}
