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
import ec.edu.insteclrg.sig_api.domain.general.TipoCertificadoLaboral;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.general.TipoCertificadoLaboralDTO;
import ec.edu.insteclrg.sig_api.service.general.TipoCertificadoLaboralService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = { Constants.URI_API_TIPO_CERTIFICADO_LABORAL})
@Tag(name = "TipoCertificadoLaboral", description = "Gestion TipoCertificadoLaboral (ej. Docencia, Institucional)")
public class TipoCertificadoLaboralController {

	@Autowired
	TipoCertificadoLaboralService service;
	@Operation(summary = "Lista todos los TipoCertificadoLaboral")
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<TipoCertificadoLaboralDTO> list = service.findAll(new TipoCertificadoLaboralDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<TipoCertificadoLaboralDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary = "Guarda un nuevo TipoCertificadoLaboral")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody TipoCertificadoLaboralDTO TipoCertificadoLaboralDTO) {
		TipoCertificadoLaboralDTO TipoCertificadoLaboralDTOResult = service.save(TipoCertificadoLaboralDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, TipoCertificadoLaboralDTOResult), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Actualizar un TipoCertificadoLaboral")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody TipoCertificadoLaboralDTO TipoCertificadoLaboralDTO) {
		TipoCertificadoLaboralDTO resultDTO = service.update(TipoCertificadoLaboralDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}
	
	
	@Operation(summary = "Recupera por id un TipoCertificadoLaboral")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		TipoCertificadoLaboralDTO dto = new TipoCertificadoLaboralDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}	
	
	@Operation(summary = "Eliminar por id un TipoCertificadoLaboral")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		TipoCertificadoLaboralDTO dto = new TipoCertificadoLaboralDTO();
		dto.setId(id);
		Optional<TipoCertificadoLaboral> categoryOptional = service.find(dto);
	
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}
