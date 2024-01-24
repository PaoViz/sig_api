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
import ec.edu.insteclrg.sig_api.common.exception.ApiException;
import ec.edu.insteclrg.sig_api.domain.general.Usuario;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.general.UsuarioDTO;
import ec.edu.insteclrg.sig_api.service.general.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = { Constants.URI_API_USUARIO})
@Tag(name = "Usuario", description = "Gestiona los Usuario.")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Operation(summary = "Lista todos los Usuarios")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<UsuarioDTO> list = service.findAll(new UsuarioDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<UsuarioDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda un nuevo Usuario")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody UsuarioDTO UsuarioDTO) {
		UsuarioDTO UsuarioDTOResult = service.save(UsuarioDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, UsuarioDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualiza un Usuario")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody UsuarioDTO UsuarioDTO) {
		UsuarioDTO resultDTO = service.update(UsuarioDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Recupera por id un Usuario")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	@Operation(summary = "Recupera por username un Usuario")
	@GetMapping(value = "{username}/archivo/username", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorUsername(@Valid @PathVariable("username") String username) {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.buscarPorUsername(username)), HttpStatus.OK);
	}
	
	


}
