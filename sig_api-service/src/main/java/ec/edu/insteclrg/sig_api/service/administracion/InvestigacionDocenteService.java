package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.administracion.InvestigacionDocente;
import ec.edu.insteclrg.sig_api.dto.administracion.InvestigacionDocenteDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.InvestigacionDocentePersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class InvestigacionDocenteService  extends GenericCrudServiceImpl <InvestigacionDocente,InvestigacionDocenteDTO>{

	
	@Autowired
	private InvestigacionDocentePersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<InvestigacionDocente> find(InvestigacionDocenteDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public InvestigacionDocente mapToDomain(InvestigacionDocenteDTO dto) {
		return modelMapper.map(dto,InvestigacionDocente.class);
	}

	@Override
	public InvestigacionDocenteDTO mapToDto(InvestigacionDocente domain) {
		return modelMapper.map(domain, InvestigacionDocenteDTO.class);
	}

}
