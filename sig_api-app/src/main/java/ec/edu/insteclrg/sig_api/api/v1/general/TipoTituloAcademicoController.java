package ec.edu.insteclrg.sig_api.api.v1.general;

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

import ec.edu.insteclrg.sig_api.common.Constants;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.general.TipoTituloAcademicoDTO;
import ec.edu.insteclrg.sig_api.service.general.TipoTituloAcademicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_TIPO_TITULO_ACADEMICO })
@Tag(name = "Tipo Titulo Académico", description = "Gestiona titulo academico (ej.tercer nivel, cuarto nivel)")
public class TipoTituloAcademicoController {
	@Autowired
	private TipoTituloAcademicoService service;

	@Operation(summary = "Lista todos los titulo Academico")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<TipoTituloAcademicoDTO> list = service.findAll(new TipoTituloAcademicoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<TipoTituloAcademicoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda un nuevo Titulo academico")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody TipoTituloAcademicoDTO TituloAcademicoDTO) {
		TipoTituloAcademicoDTO TituloAcademicoDTOResult = service.save(TituloAcademicoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, TituloAcademicoDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualiza un Titulo academico")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody TipoTituloAcademicoDTO TituloAcademicoDTO) {
		TipoTituloAcademicoDTO resultDTO = service.update(TituloAcademicoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);

	}

	@Operation(summary = "Recupera por id un Titulo academico")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		TipoTituloAcademicoDTO dto = new TipoTituloAcademicoDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}

	@Operation(summary = "Eliminar por id Titulo academico")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		TipoTituloAcademicoDTO dto = new TipoTituloAcademicoDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);

	}
}
