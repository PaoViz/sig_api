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
import ec.edu.insteclrg.sig_api.domain.general.Carrera;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.general.CarreraDTO;
import ec.edu.insteclrg.sig_api.service.general.CarreraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_CARRERA})
@Tag(name = "Carrera", description = "Gestiona Carreras ")
public class CarreraController {

	@Autowired
	CarreraService service;

	@Operation(summary = "Lista todos las Carreras")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<CarreraDTO> list = service.findAll(new CarreraDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<CarreraDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda una nueva Carrera")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody CarreraDTO CarreraDTO) {
		CarreraDTO CarreraDTOResult = service.save(CarreraDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, CarreraDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualizar una Carrera")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody CarreraDTO CarreraDTO) {
		CarreraDTO resultDTO = service.update(CarreraDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Recupera por código una Carrera")
	@GetMapping(value = "{codigo}/archivo/codigo", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorCodigo(@Valid @PathVariable("codigo") String codigo) {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.buscarPorCodigo(codigo)), HttpStatus.OK);
	}

	@Operation(summary = "Recupera por id una Carrera")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		CarreraDTO dto = new CarreraDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	@Operation(summary = "Eliminar por id una Carrera")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		CarreraDTO dto = new CarreraDTO();
		dto.setId(id);
		Optional<Carrera> categoryOptional = service.find(dto);
	
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

}

