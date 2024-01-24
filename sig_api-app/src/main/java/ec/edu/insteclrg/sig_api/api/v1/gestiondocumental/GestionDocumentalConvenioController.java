package ec.edu.insteclrg.sig_api.api.v1.gestiondocumental;

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
import ec.edu.insteclrg.sig_api.domain.gestiondocumental.GestionDocumentalConvenio;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.gestiondocumental.GestionDocumentalConvenioDTO;
import ec.edu.insteclrg.sig_api.service.gestiondocumental.GestionDocumentalConvenioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = { Constants.URI_API_GESTION_DOCUMENTAL_CONVENIO})
@Tag(name = "Gestion Documental Convenio", description = "ejem: municipio, tiendas, etc")
public class GestionDocumentalConvenioController {
	
	@Autowired
	private GestionDocumentalConvenioService service;
		
	@Operation(summary = "Lista todos los GestionDocumentalConvenio")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<GestionDocumentalConvenioDTO> list = service.findAll(new GestionDocumentalConvenioDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<GestionDocumentalConvenioDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
			} else {
				return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
			}
		}

	@Operation(summary = "Guarda un nuevo GestionDocumentalConvenio")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody GestionDocumentalConvenioDTO GestionDocumentalConvenioDTO) {
		GestionDocumentalConvenioDTO GestionDocumentalConvenioDTOResult = service.save(GestionDocumentalConvenioDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, GestionDocumentalConvenioDTOResult), HttpStatus.CREATED);
		}

	@Operation(summary = "Actualiza un GestionDocumentalConvenio")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody GestionDocumentalConvenioDTO GestionDocumentalConvenioDTO) {
		GestionDocumentalConvenioDTO resultDTO = service.update(GestionDocumentalConvenioDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
		}

	@Operation(summary = "Recupera por id un GestionDocumentalConvenio")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		GestionDocumentalConvenioDTO dto = new GestionDocumentalConvenioDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
		}
		
	@Operation(summary = "Eliminar por id un GestionDocumentalConvenio")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		GestionDocumentalConvenioDTO dto = new GestionDocumentalConvenioDTO();
		dto.setId(id);
		Optional<GestionDocumentalConvenio> categoryOptional = service.find(dto);
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
			}
		}


}
