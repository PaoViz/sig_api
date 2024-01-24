package ec.edu.insteclrg.sig_api.api.v1.general;

import java.util.List;
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
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.general.TipoAdministrativoDTO;
import ec.edu.insteclrg.sig_api.service.general.TipoAdministrativoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = {Constants.URI_API_TIPO_ADMINISTRATIVO})
@Tag(name = "Tipo Administrativo", description = "Gestiona tipo administrativo")
public class TipoAdministrativoController {
	@Autowired
	private TipoAdministrativoService service;
	
	@Operation(summary = "Lista todos los tipos administrativo")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<TipoAdministrativoDTO> list = service.findAll(new TipoAdministrativoDTO());
		if (!list.isEmpty()) {
		
			ApiResponseDTO<List<TipoAdministrativoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda un nuevo Tipo administrativo")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody TipoAdministrativoDTO TipoAdministrativoDTO) {
		TipoAdministrativoDTO TipoAdministrativoDTOResult = service.save(TipoAdministrativoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, TipoAdministrativoDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualiza un Tipo administrativo")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody TipoAdministrativoDTO TipoAdministrativoDTO) {
		TipoAdministrativoDTO resultDTO = service.update(TipoAdministrativoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Recupera por id un Tipo administrativo")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		TipoAdministrativoDTO dto = new TipoAdministrativoDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	@Operation(summary = "Eliminar por id Tipo administrativo")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		TipoAdministrativoDTO dto = new TipoAdministrativoDTO();
		dto.setId(id);
	 return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	
	}
}
