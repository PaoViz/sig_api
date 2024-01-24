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

import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.gestiondocumental.EstructuraConvenioCarreraDTO;
import ec.edu.insteclrg.sig_api.service.gestiondocumental.EstructuraConvenioCarreraService;
import ec.edu.insteclrg.sig_api.common.Constants;
import ec.edu.insteclrg.sig_api.domain.gestiondocumental.EstructuraConvenioCarrera;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = {Constants.URI_API_ESTRUCTURA_CONVENIO_CARRERA})
@Tag(name = "estructura_convenio_carrera", description = "Guarda lista de convenios por carrera(ejm: convenio 1-carrera Software)")
public class EstructuraConvenioCarreraController {
	
	@Autowired
	private EstructuraConvenioCarreraService service;
		
	@Operation(summary = "Lista todos los GestionDocumental")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<EstructuraConvenioCarreraDTO> list = service.findAll(new EstructuraConvenioCarreraDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<EstructuraConvenioCarreraDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
			} else {
				return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
			}
		}

	@Operation(summary = "Guarda una nueva EstructuraConvenioCarrera")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody EstructuraConvenioCarreraDTO EstructuraConvenioCarreraDTO) {
		EstructuraConvenioCarreraDTO EstructuraConvenioCarreraDTOResult = service.save(EstructuraConvenioCarreraDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, EstructuraConvenioCarreraDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualiza una EstructuraConvenioCarrera")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody EstructuraConvenioCarreraDTO EstructuraConvenioCarreraDTO) {
		EstructuraConvenioCarreraDTO resultDTO = service.update(EstructuraConvenioCarreraDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
		}

	@Operation(summary = "Recupera por id una EstructuraConvenioCarrera")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		EstructuraConvenioCarreraDTO dto = new EstructuraConvenioCarreraDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
		}
		
    @Operation(summary="Eliminar por id una EstructuraConvenioCarrera")
	@DeleteMapping(value = "{id}/archivo/id",produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		EstructuraConvenioCarreraDTO dto = new EstructuraConvenioCarreraDTO();
		dto.setId(id);
		Optional<EstructuraConvenioCarrera> categoryOptional = service.find(dto);
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
			}
		}

}
