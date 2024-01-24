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
import ec.edu.insteclrg.sig_api.domain.general.Periodo;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.general.PeriodoDTO;
import ec.edu.insteclrg.sig_api.service.general.PeriodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = { Constants.URI_API_PERIODO })
@Tag(name = "Periodo", description = "Gestiona los diferentes periodos academicos (ej. Noviembre 2022- Abril 2023, etc")
public class PeriodoController {

	@Autowired
	PeriodoService service;
	
	@Operation(summary = "Lista los diferentes periodos academicos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<PeriodoDTO> list = service.findAll(new PeriodoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<PeriodoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary = "Guarda una nuevo periodo academico")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody PeriodoDTO periodoDTO) {
		PeriodoDTO nivelInstruccionDTOResult  = service.save(periodoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, nivelInstruccionDTOResult), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Actualiza el periodo academico")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody PeriodoDTO periodoDTO) {
		PeriodoDTO resultDTO = service.update(periodoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Recupera un periodo academico por medio del id")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		PeriodoDTO dto = new PeriodoDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	@Operation(summary = "Eliminar por id un periodo academico")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		PeriodoDTO dto = new PeriodoDTO();
		dto.setId(id);
		Optional<Periodo> categoryOptional = service.find(dto);
	
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}
