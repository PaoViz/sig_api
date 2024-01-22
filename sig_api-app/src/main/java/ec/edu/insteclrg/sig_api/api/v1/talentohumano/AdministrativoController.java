package ec.edu.insteclrg.sig_api.api.v1.talentohumano;

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
import ec.edu.insteclrg.sig_api.dto.talentohumano.AdministrativoDTO;
import ec.edu.insteclrg.sig_api.service.talentohumano.AdministrativoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_ADMINISTRATIVO })
@Tag(name = "Administrativo", description = "Gestiona Administrativos.")
public class AdministrativoController {

	@Autowired
	AdministrativoService service;

	@Operation(summary = "Lista todos los contratos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<AdministrativoDTO> list = service.findAll(new AdministrativoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<AdministrativoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
		
		
	}

	@Operation(summary = "Guarda un nuevo Administrativo")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody AdministrativoDTO administrativoDTO) {
	AdministrativoDTO AdministrativoDTOResult = service.save(administrativoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, AdministrativoDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualizar un Administrativo")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody AdministrativoDTO administrativoDTO) {
		AdministrativoDTO resultDTO = service.update(administrativoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}


	@Operation(summary = "Recupera por id un Administrativo")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		AdministrativoDTO dto = new AdministrativoDTO();dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	
}
	
