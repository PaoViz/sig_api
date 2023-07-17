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
import ec.edu.insteclrg.sig_api.domain.administracion.GestionCertificado;
import ec.edu.insteclrg.sig_api.dto.administracion.ApiResponseDTO;
import ec.edu.insteclrg.sig_api.dto.administracion.GestionCertificadoDTO;
import ec.edu.insteclrg.sig_api.service.administracion.GestionCertificadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1.0/gestion_certificado")
@Tag(name = "gestion_certificado", description = "Gestiona los certificados(ej. emision de certificados etc.")

public class GestionCertificadoController {

	@Autowired
	private GestionCertificadoService service;
	
	@Operation(summary = "Lista los certificados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>listar(){
		List<GestionCertificadoDTO> list = service.findAll( new GestionCertificadoDTO());
		if ( !list.isEmpty()) {
			ApiResponseDTO<List<GestionCertificadoDTO>> response = new ApiResponseDTO<>(true,list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
			
		}else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false,null),HttpStatus.NOT_FOUND);
		}
	}
	@Operation( summary = "guardar los certificados")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>guardar(@RequestBody GestionCertificadoDTO  gestionCertificadoDTO){
		GestionCertificadoDTO  GestionCertificadoDTOResult= service.save(gestionCertificadoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true,GestionCertificadoDTOResult),HttpStatus.CREATED);
	}
	@Operation(summary = "Actualizar los certificados")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>actualizar(@RequestBody GestionCertificadoDTO  gestionCertificadoDTO ) {
		GestionCertificadoDTO  ResultDTO = service.update(gestionCertificadoDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, ResultDTO),HttpStatus.CREATED);
		
	}
	@Operation(summary = "recuperar  certificados ")
	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object>buscarPorId(@Valid @PathVariable("id") long id){
		GestionCertificadoDTO  dto= new GestionCertificadoDTO ();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}
	
	@Operation(summary = "Eliminar los certificados")
	@DeleteMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		GestionCertificadoDTO dto = new GestionCertificadoDTO();
		dto.setId(id);
		Optional<GestionCertificado> categoryOptional = service.find(dto);
	
		if(categoryOptional.isPresent()) {
			service.delete(dto);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		    
		    }
		}
}
	


