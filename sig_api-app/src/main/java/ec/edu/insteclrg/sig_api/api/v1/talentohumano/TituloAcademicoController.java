package ec.edu.insteclrg.sig_api.api.v1.talentohumano;

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
import ec.edu.insteclrg.sig_api.domain.talentohumano.TituloAcademico;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.talentohumano.TituloAcademicoDTO;
import ec.edu.insteclrg.sig_api.service.talentohumano.TituloAcademicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(value = { Constants.URI_API_TITULO_ACADEMICO })
@Tag(name = "Docente", description = "Gestiona los diferentes titulos Academicos que se registran detro de la Institucion (ej. Titulo de Bachiller, etc")
public class TituloAcademicoController {

	@Autowired
	TituloAcademicoService service;
	
	@Operation(summary = "Lista los Titulos academiscos que se han registrado en la institucion")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<TituloAcademicoDTO> list = service.findAll(new TituloAcademicoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<TituloAcademicoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@Operation(summary = "Guarda un nuevo titulo academico  en la institucion")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody TituloAcademicoDTO tituloAcademicoDTO) {
		TituloAcademicoDTO tituloacademicoDTOResult  = service.save(tituloAcademicoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, tituloacademicoDTOResult), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Actualiza el titulo academico guardado")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody TituloAcademicoDTO tituloAcademicoDTO) {
		TituloAcademicoDTO resultDTO = service.update(tituloAcademicoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Recupera un titulo academico por medio del id")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		TituloAcademicoDTO dto = new TituloAcademicoDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	@Operation(summary = "Elimina por id un titulo academico")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		TituloAcademicoDTO dto = new TituloAcademicoDTO();
		dto.setId(id);
		Optional<TituloAcademico> categoryOptional = service.find(dto);
	
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
}
