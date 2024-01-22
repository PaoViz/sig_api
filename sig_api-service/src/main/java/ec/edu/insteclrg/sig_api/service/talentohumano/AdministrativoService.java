package ec.edu.insteclrg.sig_api.service.talentohumano;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.talentohumano.Administrativo;
import ec.edu.insteclrg.sig_api.dto.talentohumano.AdministrativoDTO;
import ec.edu.insteclrg.sig_api.persistence.talentohumano.AdministrativoPersistence;
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