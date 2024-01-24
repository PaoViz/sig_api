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
import ec.edu.insteclrg.sig_api.dto.general.TipoSangreDTO;
import ec.edu.insteclrg.sig_api.service.general.TipoSangreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = { Constants.URI_API_TIPO_SANGRE })
@Tag(name = "TipoSangre", description = "Gestiona tipos de Sangre (ej. OH+, OH-, etc.")
public class TipoSangreController {
	
	@Autowired
	private TipoSangreService service;
	
	@Operation(summary = "Lista todos los tipos de Sangres")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<TipoSangreDTO> list = service.findAll(new TipoSangreDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<TipoSangreDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda un nuevo Tipo de Sangre")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody TipoSangreDTO TipoSangreDTO) {
		TipoSangreDTO TipoSangreDTOResult = service.save(TipoSangreDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, TipoSangreDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualiza un Tipo de Sangre")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody TipoSangreDTO TipoSangreDTO) {
		TipoSangreDTO resultDTO = service.update(TipoSangreDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Recupera por id un Tipo de Sangre")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		TipoSangreDTO dto = new TipoSangreDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}

}
