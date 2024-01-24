package ec.edu.insteclrg.sig_api.api.v1.talentohumano;

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
import ec.edu.insteclrg.sig_api.domain.talentohumano.ContratoLaboral;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.talentohumano.ContratoLaboralDTO;
import ec.edu.insteclrg.sig_api.service.talentohumano.ContratoLaboralService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = {Constants.URI_API_CONTRATO_LABORAL})
@Tag(name = "ContratoLaboral", description = "Gestiona Tiempo completo, medio tiempi, etc.")
public class ContratoLaboralController {
	@Autowired
	ContratoLaboralService service;

	@Operation(summary = "Lista todos los contratos laborales")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<ContratoLaboralDTO> list = service.findAll(new ContratoLaboralDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<ContratoLaboralDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda un nuevo contrato laboral")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody ContratoLaboralDTO contratolaboralDTO) {
		ContratoLaboralDTO ContratoLaboralDTOResult = service.save(contratolaboralDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, ContratoLaboralDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualizar un Contrato Laboral")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody ContratoLaboralDTO contratolaboralDTO) {
		ContratoLaboralDTO resultDTO = service.update(contratolaboralDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Recupera por id un Contrato Laboral")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		ContratoLaboralDTO dto = new ContratoLaboralDTO();dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	@Operation(summary = "Eliminar por id un Contrato Laboral")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		ContratoLaboralDTO dto = new ContratoLaboralDTO();
		dto.setId(id);
		Optional<ContratoLaboral> categoryOptional = service.find(dto);
	
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}
