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

import ec.edu.insteclrg.sig_api.common.Constants;
import ec.edu.insteclrg.sig_api.domain.administracion.CertificadoTipo;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.administracion.CertifdicadoTipoDTO;
import ec.edu.insteclrg.sig_api.service.administracion.CertificadoTipoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_CERTIFICADO_TIPO })
@Tag(name = "CertificadoTipo", description = "Gestiona CertificadoTipo (ej. Ecuador, Colombia, etc.")
public class CertificadoTipoController {
	
	@Autowired
	CertificadoTipoService service;
	
	@Operation(summary = "Lista todos los CertificadoTipo")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<CertifdicadoTipoDTO> list = service.findAll(new CertifdicadoTipoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<CertifdicadoTipoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary = "Guarda un nuevo CertificadoTipo")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody CertifdicadoTipoDTO certifdicadoTipoDTO) {
		CertifdicadoTipoDTO CertificadoTipoDTOResult = service.save(certifdicadoTipoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, CertificadoTipoDTOResult), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Actualizar un CertificadoTipo")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody CertifdicadoTipoDTO CertifdicadoTipoDTO) {
		CertifdicadoTipoDTO resultDTO = service.update(CertifdicadoTipoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Recupera por id un CertificadoTipo")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		CertifdicadoTipoDTO dto = new CertifdicadoTipoDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	@Operation(summary = "Eliminar por id un CertificadoTipo")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		CertifdicadoTipoDTO dto = new CertifdicadoTipoDTO();
		dto.setId(id);
		Optional<CertificadoTipo> categoryOptional = service.find(dto);
	
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

}
