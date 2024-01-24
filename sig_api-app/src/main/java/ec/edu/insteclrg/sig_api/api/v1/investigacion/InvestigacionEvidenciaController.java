package ec.edu.insteclrg.sig_api.api.v1.investigacion;

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
import ec.edu.insteclrg.sig_api.domain.investigacion.InvestigacionEvidencia;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.investigacion.InvestigacionEvidenciaDTO;
import ec.edu.insteclrg.sig_api.service.investigacion.InvestigacionEvidenciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = {Constants.URI_API_INVESTIGACION_EVIDENCIA})
@Tag(name = "Investigacion Evidencia", description = "ejem: ")
public class InvestigacionEvidenciaController {

	@Autowired
	private InvestigacionEvidenciaService service;
		
	@Operation(summary = "Lista todos los InvestigacionEvidencia")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<InvestigacionEvidenciaDTO> list = service.findAll(new InvestigacionEvidenciaDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<InvestigacionEvidenciaDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
			} else {
				return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
			}
		}

	@Operation(summary = "Guarda un nuevo InvestigacionEvidencia")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody InvestigacionEvidenciaDTO InvestigacionEvidenciaDTO) {
		InvestigacionEvidenciaDTO InvestigacionEvidenciaDTOResult = service.save(InvestigacionEvidenciaDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, InvestigacionEvidenciaDTOResult), HttpStatus.CREATED);
		}

	@Operation(summary = "Actualiza un InvestigacionEvidencia")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody InvestigacionEvidenciaDTO InvestigacionEvidenciaDTO) {
		InvestigacionEvidenciaDTO resultDTO = service.update(InvestigacionEvidenciaDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
		}

	@Operation(summary = "Recupera por id un InvestigacionEvidencia")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		InvestigacionEvidenciaDTO dto = new InvestigacionEvidenciaDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
		}
		
	@Operation(summary = "Eliminar por id un InvestigacionEvidencia")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		InvestigacionEvidenciaDTO dto = new InvestigacionEvidenciaDTO();
		dto.setId(id);
		Optional<InvestigacionEvidencia> categoryOptional = service.find(dto);
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
			}
		}
}
