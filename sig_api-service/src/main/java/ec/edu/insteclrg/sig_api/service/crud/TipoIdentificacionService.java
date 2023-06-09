package ec.edu.insteclrg.sig_api.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.TipoIdentificacion;
import ec.edu.insteclrg.sig_api.dto.Tipo_IdentificacionDTO;
import ec.edu.insteclrg.sig_api.persistence.TipoIndentificacionPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class TipoIdentificacionService extends GenericCrudServiceImpl<TipoIdentificacion, Tipo_IdentificacionDTO> {

	@Autowired
	private TipoIndentificacionPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<TipoIdentificacion> find(Tipo_IdentificacionDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public TipoIdentificacion mapToDomain(Tipo_IdentificacionDTO dto) {
		return modelMapper.map(dto, TipoIdentificacion.class);
	}

	@Override
	public Tipo_IdentificacionDTO mapToDto(TipoIdentificacion domain) {
		return modelMapper.map(domain, Tipo_IdentificacionDTO.class);
	}

}
