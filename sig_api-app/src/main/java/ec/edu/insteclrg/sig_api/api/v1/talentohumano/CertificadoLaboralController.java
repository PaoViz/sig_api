package ec.edu.insteclrg.sig_api.api.v1.talentohumano;

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
import ec.edu.insteclrg.sig_api.domain.talentohumano.CertificadoLaboral;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.talentohumano.CertificadoLaboralDTO;
import ec.edu.insteclrg.sig_api.service.talentohumano.CertificadoLaboralService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = {Constants.URI_API_CERTIFICADO_LABORAL})
@Tag(name = "Certificado Laboral", description = "Gestiona los certificados laborales de los profesores")
public class CertificadoLaboralController {

	@Autowired
	private CertificadoLaboralService service;
	
	@Operation(summary = "Lista todos los Certificados Laborales ")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<CertificadoLaboralDTO> list = service.findAll(new CertificadoLaboralDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<CertificadoLaboralDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda un nuevo Certificado Laboral")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody CertificadoLaboralDTO CertificadoLaboralDTO) {
		CertificadoLaboralDTO CertificadoLaboralDTOResult = service.save(CertificadoLaboralDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, CertificadoLaboralDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualiza un Certificado Laboral")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody CertificadoLaboralDTO CertificadoLaboralDTO) {
		CertificadoLaboralDTO resultDTO = service.update(CertificadoLaboralDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Recupera por id un Certificado Laboral")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		CertificadoLaboralDTO dto = new CertificadoLaboralDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	@Operation(summary = "Eliminar por id un Certificado Laboral")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		CertificadoLaboralDTO dto = new CertificadoLaboralDTO();
		dto.setId(id);
		Optional<CertificadoLaboral> categoryOptional = service.find(dto);
	
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}
