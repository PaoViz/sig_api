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
import ec.edu.insteclrg.sig_api.domain.administracion.ProyectoVinculacionPlanificacion;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.administracion.ProyectoVinculacionPlanificacionDTO;
import ec.edu.insteclrg.sig_api.service.administracion.ProyectoVinculacionPlanificacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_PROYECTO_VINCULACION_PLANIFICACION})
@Tag(name = "ProyectoVinculacionPlanificacion", description = "Gestiona los diferentes proyectos realizados detro de la Institucion (ej. ING, Proyecto HUB, etc")
public class ProyectoVinculacionPlanificacionController {

	@Autowired
	ProyectoVinculacionPlanificacionService service;
	
	@Operation(summary = "Lista los diferentes proyectos realizados detro de la Institucion")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<ProyectoVinculacionPlanificacionDTO> list = service.findAll(new ProyectoVinculacionPlanificacionDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<ProyectoVinculacionPlanificacionDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary = "Guarda los diferentes proyectos realizados detro de la Institucion")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody ProyectoVinculacionPlanificacionDTO proyectoVinculacionPlanificacionDTO) {
		ProyectoVinculacionPlanificacionDTO proyectoDTOResult  = service.save(proyectoVinculacionPlanificacionDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, 	proyectoDTOResult), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Actualiza los diferentes proyectos realizados detro de la Institucion")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody ProyectoVinculacionPlanificacionDTO proyectoVinculacionPlanificacionDTO) {
		ProyectoVinculacionPlanificacionDTO resultDTO = service.update(proyectoVinculacionPlanificacionDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
		}
	
	@Operation(summary = "Recupera un Proyecto por medio del Id")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		ProyectoVinculacionPlanificacionDTO dto = new ProyectoVinculacionPlanificacionDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	@Operation(summary = "Eliminar por id un Proyecto")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		ProyectoVinculacionPlanificacionDTO dto = new ProyectoVinculacionPlanificacionDTO();
		dto.setId(id);
		Optional<ProyectoVinculacionPlanificacion> categoryOptional = service.find(dto);
	
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
}
