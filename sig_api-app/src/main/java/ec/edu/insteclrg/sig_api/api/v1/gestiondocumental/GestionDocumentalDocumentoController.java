package ec.edu.insteclrg.sig_api.api.v1.gestiondocumental;

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
import ec.edu.insteclrg.sig_api.dto.gestiondocumental.GestionDocumentalDocumentoDTO;
import ec.edu.insteclrg.sig_api.service.gestiondocumental.GestionDocumentalDocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = { Constants.URI_API_GESTION_DOCUMENTAL_DOCUMENTO })
@Tag(name = "gestionDocumentalDocumento", description = "Gestiona Documentos de Gestion Documental (ej. muestra archivos como de notas, y otros documentos.")

public class GestionDocumentalDocumentoController {
	@Autowired
	GestionDocumentalDocumentoService service;
	
	@Operation(summary = "Lista todos los Documentos de Gestion Documental")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<GestionDocumentalDocumentoDTO> list = service.findAll(new GestionDocumentalDocumentoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<GestionDocumentalDocumentoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary = "Guarda un nuevo Documento de Gestion Documental")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody GestionDocumentalDocumentoDTO GestionDocumentalDocumentoDTO) {
		GestionDocumentalDocumentoDTO GestionDocumentalDocumentoDTOResult = service.save(GestionDocumentalDocumentoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, GestionDocumentalDocumentoDTOResult), HttpStatus.CREATED);
	}
	

	@Operation(summary = "Actualizar un Documento de Gestion Documental")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody GestionDocumentalDocumentoDTO GestionDocumentalDocumentoDTO) {
		GestionDocumentalDocumentoDTO resultDTO = service.update(GestionDocumentalDocumentoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Recupera por código un Documento de Gestion Documental")
	@GetMapping(value = "{codigo}/archivo/codigo", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorCodigo(@Valid @PathVariable("codigo") String codigo) {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.buscarPorCodigo(codigo)), HttpStatus.OK);
	}
	
	@Operation(summary = "Recupera por id un Documento de Gestion Documental")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		GestionDocumentalDocumentoDTO dto = new GestionDocumentalDocumentoDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}

}
