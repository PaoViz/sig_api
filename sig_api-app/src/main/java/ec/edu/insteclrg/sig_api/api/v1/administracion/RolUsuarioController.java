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
import ec.edu.insteclrg.sig_api.domain.administracion.RolUsuario;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.administracion.RolUsuarioDTO;
import ec.edu.insteclrg.sig_api.service.administracion.RolUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = {Constants.URI_API_ROL_USUARIO})
@Tag(name = "Rol", description = "Gestiona la creacion de los roles de los usuarios")
public class RolUsuarioController {
	
	@Autowired
	private RolUsuarioService service;
	
	@Operation(summary = "Lista todos los Roles de los usuarios creados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<RolUsuarioDTO> list = service.findAll(new RolUsuarioDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<RolUsuarioDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}


	@Operation(summary = "Guarda la creacion del roles de usuario")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody RolUsuarioDTO RolUsuarioDTO) {
		RolUsuarioDTO RolUsuarioResult = service.save(RolUsuarioDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, RolUsuarioResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualiza el registro de roles")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody RolUsuarioDTO RolDTO) {
		RolUsuarioDTO resultDTO = service.update(RolDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Eliminar los registros de los roles")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		RolUsuarioDTO dto = new RolUsuarioDTO();
		dto.setId(id);
		Optional<RolUsuario> categoryOptional = service.find(dto);
		
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	

}
