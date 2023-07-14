package ec.edu.insteclrg.sig_api.api.v1.administracion;

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

import ec.edu.insteclrg.dto.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.common.Constants;
import ec.edu.insteclrg.sig_api.domain.administracion.ModalidadContrato;
import ec.edu.insteclrg.sig_api.dto.administracion.ModalidadContratoDTO;
import ec.edu.insteclrg.sig_api.service.administracion.ModalidadContratoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_MODALIDAD_CONTRATO })
@Tag(name = "ModalidadContrato", description = "Gestiona Contratos (ej. Tiempo Completo,Medio Tiempo, etc.")
public class ModalidadContratoController {

	@Autowired
	ModalidadContratoService service;

	@Operation(summary = "Lista todos los contratos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<ModalidadContratoDTO> list = service.findAll(new ModalidadContratoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<ModalidadContratoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda un nuevo Contrato")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody ModalidadContratoDTO modalidadContratoDTO) {
		ModalidadContratoDTO PaisDTOResult = service.save(modalidadContratoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, PaisDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualizar un Contrato")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody ModalidadContratoDTO ModalidadContratoDTO) {
		ModalidadContratoDTO resultDTO = service.update(ModalidadContratoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}


	@Operation(summary = "Recupera por id un Contrato")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		ModalidadContratoDTO dto = new ModalidadContratoDTO();dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	@Operation(summary = "Eliminar por id un ModalidadContrato")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		ModalidadContratoDTO dto = new ModalidadContratoDTO();
		dto.setId(id);
		Optional<ModalidadContrato> categoryOptional = service.find(dto);
	
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

}
