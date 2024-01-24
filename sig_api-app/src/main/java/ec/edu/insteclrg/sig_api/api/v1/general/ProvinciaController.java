package ec.edu.insteclrg.sig_api.api.v1.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.sig_api.common.Constants;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.general.ProvinciaDTO;
import ec.edu.insteclrg.sig_api.service.general.ProvinciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = { Constants.URI_API_PROVINCIA })
@Tag(name = "Provincia", description = "Gestiona provincias (ej. Azuay, Guayas, etc.")
public class ProvinciaController {
	
	@Autowired
	private ProvinciaService service;
	
	@Operation(summary = "Lista todos las Provincias")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<ProvinciaDTO> list = service.findAll(new ProvinciaDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<ProvinciaDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda una nueva Provincia")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody ProvinciaDTO ProvinciaDTO) {
		ProvinciaDTO ProvinciaDTOResult = service.save(ProvinciaDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, ProvinciaDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualiza una Provincia")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody ProvinciaDTO ProvinciaDTO) {
		ProvinciaDTO resultDTO = service.update(ProvinciaDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Recupera por id una Provincia")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		ProvinciaDTO dto = new ProvinciaDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}


}
