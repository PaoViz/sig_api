package ec.edu.insteclrg.sig_api.api.v1.administracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.sig_api.common.Constants;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.administracion.TipoEnfermedadCatastroficaDTO;
import ec.edu.insteclrg.sig_api.service.administracion.TipoEnfermedadCatastroficaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { Constants.URI_API_TIPO_ENFERMEDAD })
@Tag(name = "Tipo_Enfermead_Catastrofica", description = "Gestiona los tipos de enfermedad catastrofica (ej. Malformacion, Cancer, etc.")

public class TipoEnfermedadCatastroficaController {
	
	@Autowired
	private TipoEnfermedadCatastroficaService service;
	
	@Operation(summary = "Lista todos los Tipos de Enfermedades Catastroficas")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<TipoEnfermedadCatastroficaDTO> list = service.findAll(new TipoEnfermedadCatastroficaDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<TipoEnfermedadCatastroficaDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Guarda un nuevo Tipo de Enfermedad Catastrofica")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody TipoEnfermedadCatastroficaDTO TipoEnfermedadCatastroficaDTO) {
		TipoEnfermedadCatastroficaDTO TipoEnfermedadCatastroficaDTOResult = service.save(TipoEnfermedadCatastroficaDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, TipoEnfermedadCatastroficaDTOResult), HttpStatus.CREATED);
	}

	@Operation(summary = "Actualiza un Tipo de Enfermedad Catastrofica")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody TipoEnfermedadCatastroficaDTO TipoEnfermedadCatastroficaDTO) {
		TipoEnfermedadCatastroficaDTO resultDTO = service.update(TipoEnfermedadCatastroficaDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@Operation(summary = "Recupera por id un Tipo de Enfermedad Catastrofica")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		TipoEnfermedadCatastroficaDTO dto = new TipoEnfermedadCatastroficaDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	

}
