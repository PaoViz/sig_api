package ec.edu.insteclrg.sig_api.api.v1.general;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.sig_api.common.Constants;
import ec.edu.insteclrg.sig_api.domain.general.NivelInstruccion;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.general.NivelInstruccionDTO;
import ec.edu.insteclrg.sig_api.service.general.NivelInstruccionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = { Constants.URI_API_NIVEL_INSTRUCCION })
@Tag(name = "Nivel Instruccion", description = "Gestiona el nivel de instruccion(ej. Bachiller, etc")
public class NivelInstruccionController {

	@Autowired
	NivelInstruccionService service;
	
	@Operation(summary = "Lista los niveles de instruccion")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<NivelInstruccionDTO> list = service.findAll(new NivelInstruccionDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<NivelInstruccionDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary = "Guarda una nuevo nivel de instruccion")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody NivelInstruccionDTO nivelInstruccionDTO) {
		NivelInstruccionDTO nivelInstruccionDTOResult  = service.save(nivelInstruccionDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, nivelInstruccionDTOResult), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Actualiza el nivel de instruccion")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody NivelInstruccionDTO nivelInstruccionDTO) {
		NivelInstruccionDTO resultDTO = service.update(nivelInstruccionDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Recupera un nivel de instruccion por medio del id")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		NivelInstruccionDTO dto = new NivelInstruccionDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	@Operation(summary = "Eliminar por id un Nivel")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		NivelInstruccionDTO dto = new NivelInstruccionDTO();
		dto.setId(id);
		Optional<NivelInstruccion> categoryOptional = service.find(dto);
	
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
}
