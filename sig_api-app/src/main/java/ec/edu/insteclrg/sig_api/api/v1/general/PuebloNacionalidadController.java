package ec.edu.insteclrg.sig_api.api.v1.general;

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
import ec.edu.insteclrg.sig_api.dto.general.PuebloNacionalidadDTO;
import ec.edu.insteclrg.sig_api.service.general.PuebloNacionalidadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_TIPO_PUEBLO_NACIONALIDAD })
@Tag(name = "Pueblo_Nacionalidad", description = "Gestiona de pueblos o nacionalidades (ej. Achuar, Cañari, etc.")
public class PuebloNacionalidadController {
	
	@Autowired
	private PuebloNacionalidadService service;
	
	@Operation(summary = "Lista todos los Pueblos y Nacionalidades")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<PuebloNacionalidadDTO> list = service.findAll(new PuebloNacionalidadDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<PuebloNacionalidadDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda un nuevo Pueblo o Nacionalidad")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody PuebloNacionalidadDTO PuebloNacionalidadDTO) {
		PuebloNacionalidadDTO PuebloNacionalidadDTOResult = service.save(PuebloNacionalidadDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, PuebloNacionalidadDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualiza un Pueblo o Nacionalidad")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody PuebloNacionalidadDTO PuebloNacionalidadDTO) {
		PuebloNacionalidadDTO resultDTO = service.update(PuebloNacionalidadDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Recupera por id un Pueblo o Nacionalidad")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		PuebloNacionalidadDTO dto = new PuebloNacionalidadDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	

}
