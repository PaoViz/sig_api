package ec.edu.insteclrg.sig_api.api.v1.administracion;

import java.util.List;


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

import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.administracion.EmpresaFormadoraDTO;
import ec.edu.insteclrg.sig_api.service.administracion.EmpresaFormadoraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/periodo")
@Tag(name = "Titulo Academico", description = "Gestiona titulo academico (ej.tercer nivel, cuarto nivel")
public class EmpresaFormadoraController {
	@Autowired
	private EmpresaFormadoraService service;
	
	@Operation(summary = "Lista todos los titulo Academico")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<EmpresaFormadoraDTO> list = service.findAll(new EmpresaFormadoraDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<EmpresaFormadoraDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda un nuevo Tipo administrativo")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody EmpresaFormadoraDTO EmpresaFormadoraDTO) {
		EmpresaFormadoraDTO TituloAcademicoDTOResult = service.save(EmpresaFormadoraDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, TituloAcademicoDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualiza un Tipo administrativo")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody EmpresaFormadoraDTO EmpresaFormadoraDTO) {
		EmpresaFormadoraDTO resultDTO = service.update(EmpresaFormadoraDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	
	}

	@Operation(summary = "Recupera por id un Tipo administrativo")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		EmpresaFormadoraDTO dto = new EmpresaFormadoraDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	@Operation(summary = "Eliminar por id Tipo administrativo")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		EmpresaFormadoraDTO dto = new EmpresaFormadoraDTO();
		dto.setId(id);
	 return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	
	}
}
