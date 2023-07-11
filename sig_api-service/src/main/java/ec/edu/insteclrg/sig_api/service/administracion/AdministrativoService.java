package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.administracion.Administrativo;
import ec.edu.insteclrg.sig_api.dto.administracion.AdministrativoDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.AdministrativoPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class AdministrativoService extends GenericCrudServiceImpl<Administrativo, AdministrativoDTO>{
	
	@Autowired
	private AdministrativoPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Administrativo> find(AdministrativoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Administrativo mapToDomain(AdministrativoDTO dto) {
		return modelMapper.map(dto, Administrativo.class);
	}

	@Override
	public AdministrativoDTO mapToDto(Administrativo domain) {
		return modelMapper.map(domain, AdministrativoDTO.class);
	}

}