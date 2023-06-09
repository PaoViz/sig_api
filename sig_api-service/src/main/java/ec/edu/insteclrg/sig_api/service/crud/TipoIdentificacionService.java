package ec.edu.insteclrg.sig_api.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.Tipo_Identificacion;
import ec.edu.insteclrg.sig_api.dto.Tipo_IdentificacionDTO;
import ec.edu.insteclrg.sig_api.persistence.TipoIndentificacionPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class TipoIdentificacionService extends GenericCrudServiceImpl<Tipo_Identificacion, Tipo_IdentificacionDTO> {

	@Autowired
	private TipoIndentificacionPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<Tipo_Identificacion> find(Tipo_IdentificacionDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Tipo_Identificacion mapToDomain(Tipo_IdentificacionDTO dto) {
		return modelMapper.map(dto, Tipo_Identificacion.class);
	}

	@Override
	public Tipo_IdentificacionDTO mapToDto(Tipo_Identificacion domain) {
		return modelMapper.map(domain, Tipo_IdentificacionDTO.class);
	}

}
