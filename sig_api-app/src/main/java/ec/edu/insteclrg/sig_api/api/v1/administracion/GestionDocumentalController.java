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
import ec.edu.insteclrg.sig_api.domain.administracion.GestionDocumental;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.administracion.GestionDocumentalDTO;
import ec.edu.insteclrg.sig_api.service.administracion.GestionDocumentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping(value = { Constants.URI_API_GESTION_DOCUMENTAL })
@Tag(name = "Gestion Documental", description = "Gestion Documental")
public class GestionDocumentalController {

	@Autowired
	private GestionDocumentalService service;
		
	@Operation(summary = "Lista todos los GestionDocumental")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<GestionDocumentalDTO> list = service.findAll(new GestionDocumentalDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<GestionDocumentalDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
			} else {
				return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
			}
		}

	@Operation(summary = "Guarda un nuevo GestionDocumental")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody GestionDocumentalDTO GestionDocumentalDTO) {
		GestionDocumentalDTO GestionDocumentalDTOResult = service.save(GestionDocumentalDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, GestionDocumentalDTOResult), HttpStatus.CREATED);
		}

	@Operation(summary = "Actualiza un GestionDocumental")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody GestionDocumentalDTO GestionDocumentalDTO) {
		GestionDocumentalDTO resultDTO = service.update(GestionDocumentalDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
		}

	@Operation(summary = "Recupera por id un GestionDocumental")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		GestionDocumentalDTO dto = new GestionDocumentalDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
		}
		
	@Operation(summary = "Eliminar por id un GestionDocumental")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		GestionDocumentalDTO dto = new GestionDocumentalDTO();
		dto.setId(id);
		Optional<GestionDocumental> categoryOptional = service.find(dto);
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
			}
		}

}
