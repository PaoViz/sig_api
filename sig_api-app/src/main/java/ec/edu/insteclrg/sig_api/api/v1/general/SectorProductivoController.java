package ec.edu.insteclrg.sig_api.api.v1.general;

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
import ec.edu.insteclrg.sig_api.domain.general.SectorProductivo;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.general.SectorProductivoDTO;
import ec.edu.insteclrg.sig_api.service.general.SectorProductivoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_SECTOR_PRODUCTIVO})
@Tag(name = "Sector Productivo", description = "Gestiona el sector productivo (ej. Clic Soluciones, Junta de Agua, etc")
public class SectorProductivoController {
	@Autowired
	SectorProductivoService service;
	
	@Operation(summary = "Lista todos los sectores productivos") 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<SectorProductivoDTO> list = service.findAll(new SectorProductivoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<SectorProductivoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary = "Guarda una nuevo sector productivo")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody SectorProductivoDTO sectorProductivoDTO) {
		SectorProductivoDTO sectorProductivoDTOResult  = service.save(sectorProductivoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, sectorProductivoDTOResult), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Actualiza el Sector Productivo")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody SectorProductivoDTO sectorProductivoDTO) {
		SectorProductivoDTO resultDTO = service.update(sectorProductivoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Recupera un sector productivo por id")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		SectorProductivoDTO dto = new SectorProductivoDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	@Operation(summary = "Eliminar por id un Sector Productivo")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		SectorProductivoDTO dto = new SectorProductivoDTO();
		dto.setId(id);
		Optional<SectorProductivo> categoryOptional = service.find(dto);
	
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
}

