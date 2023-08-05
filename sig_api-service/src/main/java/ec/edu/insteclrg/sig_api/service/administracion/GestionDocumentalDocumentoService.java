package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.common.exception.ApiException;
import ec.edu.insteclrg.sig_api.domain.administracion.GestionDocumentalDocumento;
import ec.edu.insteclrg.sig_api.dto.administracion.GestionDocumentalDocumentoDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.GestionDocumentalDocumentoPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class GestionDocumentalDocumentoService extends GenericCrudServiceImpl<GestionDocumentalDocumento, GestionDocumentalDocumentoDTO>{
	
	@Autowired
	private GestionDocumentalDocumentoPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<GestionDocumentalDocumento> find(GestionDocumentalDocumentoDTO dto) {
		return repository.findById(dto.getId());
	}
	
	@Override
	public GestionDocumentalDocumento mapToDomain(GestionDocumentalDocumentoDTO dto) {
		return modelMapper.map(dto, GestionDocumentalDocumento.class);
	}
	
	@Override
	public GestionDocumentalDocumentoDTO mapToDto(GestionDocumentalDocumento domain) {
		return modelMapper.map(domain, GestionDocumentalDocumentoDTO.class);
	}
	
	public Optional<GestionDocumentalDocumento> buscarPorCodigo(String codigo) {
		Optional<GestionDocumentalDocumento> entidad = repository.findByCodigo(codigo);
		if (entidad.isEmpty())
			throw new ApiException(String.format("Registro con código %s no existe en el sistema", codigo));
		return entidad;
	}
	
}
