package ec.edu.insteclrg.sig_api.api.v1.vinculacion;

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
import ec.edu.insteclrg.sig_api.domain.vinculacion.ProyectoPracticas;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.vinculacion.ProyectoPracticasDTO;
import ec.edu.insteclrg.sig_api.service.vinculacion.ProyectoPracticasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = { Constants.URI_API_PROYECTO_PRACTICAS})
@Tag(name = "Proyecto Practicas", description = "Ejem: horas planificadas 240")
public class ProyectoPracticasController {
	
	@Autowired
	private ProyectoPracticasService service;
		
	@Operation(summary = "Lista todos los ProyectoPracticas")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<ProyectoPracticasDTO> list = service.findAll(new ProyectoPracticasDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<ProyectoPracticasDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
			} else {
				return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
			}
		}

	@Operation(summary = "Guarda un nuevo ProyectoPracticas")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody ProyectoPracticasDTO ProyectoPracticasDTO) {
		ProyectoPracticasDTO ProyectoPracticasDTOResult = service.save(ProyectoPracticasDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, ProyectoPracticasDTOResult), HttpStatus.CREATED);
		}

	@Operation(summary = "Actualiza un ProyectoPracticas")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody ProyectoPracticasDTO ProyectoPracticasDTO) {
		ProyectoPracticasDTO resultDTO = service.update(ProyectoPracticasDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
		}

	@Operation(summary = "Recupera por id un ProyectoPracticas")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		ProyectoPracticasDTO dto = new ProyectoPracticasDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
		}
		
	@Operation(summary = "Eliminar por id un ProyectoPracticas")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		ProyectoPracticasDTO dto = new ProyectoPracticasDTO();
		dto.setId(id);
		Optional<ProyectoPracticas> categoryOptional = service.find(dto);
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
			}
		}



}
