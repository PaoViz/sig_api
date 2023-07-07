package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.insteclrg.sig_api.domain.administracion.TipoAdministrativo;
import ec.edu.insteclrg.sig_api.dto.administracion.TipoAdministrativoDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.TipoAdministrativoPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class TipoAdministrativoService  extends GenericCrudServiceImpl<TipoAdministrativo, TipoAdministrativoDTO> {

	@Autowired
	private TipoAdministrativoPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<TipoAdministrativo> find(TipoAdministrativoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public TipoAdministrativo mapToDomain(TipoAdministrativoDTO dto) {
		return modelMapper.map(dto, TipoAdministrativo.class);
	}

	@Override
	public TipoAdministrativoDTO mapToDto(TipoAdministrativo domain) {
		return modelMapper.map(domain, TipoAdministrativoDTO.class);
	}
	

}
