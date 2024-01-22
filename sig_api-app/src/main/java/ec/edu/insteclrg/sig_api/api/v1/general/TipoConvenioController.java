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
import ec.edu.insteclrg.sig_api.domain.general.TipoConvenio;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.general.TipoConvenioDTO;
import ec.edu.insteclrg.sig_api.service.general.TipoConvenioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_TIPO_CONVENIO })
@Tag(name = "TipoConvenio", description = "Gestiona TipoConvenio (ej. Vinculación, PPP, Macro, Investigación.")
public class TipoConvenioController {

	@Autowired
	private TipoConvenioService service;
		
	@Operation(summary = "Lista todos los TipoConvenios")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<TipoConvenioDTO> list = service.findAll(new TipoConvenioDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<TipoConvenioDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
			} else {
				return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
			}
		}

	@Operation(summary = "Guarda un nuevo TipoConvenio")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody TipoConvenioDTO TipoConvenioDTO) {
		TipoConvenioDTO TipoConvenioDTOResult = service.save(TipoConvenioDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, TipoConvenioDTOResult), HttpStatus.CREATED);
		}

	@Operation(summary = "Actualiza un TipoConvenio")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody TipoConvenioDTO TipoConvenioDTO) {
		TipoConvenioDTO resultDTO = service.update(TipoConvenioDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
		}

	@Operation(summary = "Recupera por id un TipoConvenio")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		TipoConvenioDTO dto = new TipoConvenioDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
		}
		
	@Operation(summary = "Eliminar por id un Ciclo")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		TipoConvenioDTO dto = new TipoConvenioDTO();
		dto.setId(id);
		Optional<TipoConvenio> categoryOptional = service.find(dto);
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
			}
		}

}
