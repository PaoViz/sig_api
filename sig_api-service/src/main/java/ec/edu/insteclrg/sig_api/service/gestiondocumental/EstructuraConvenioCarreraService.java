package ec.edu.insteclrg.sig_api.service.gestiondocumental;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.gestiondocumental.EstructuraConvenioCarrera;
import ec.edu.insteclrg.sig_api.dto.gestiondocumental.EstructuraConvenioCarreraDTO;
import ec.edu.insteclrg.sig_api.persistence.gestiondocumental.EstructuraConvenioCarreraPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class EstructuraConvenioCarreraService extends GenericCrudServiceImpl<EstructuraConvenioCarrera,EstructuraConvenioCarreraDTO>{
	
	@Autowired
	private EstructuraConvenioCarreraPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<EstructuraConvenioCarrera> find(EstructuraConvenioCarreraDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public EstructuraConvenioCarrera mapToDomain(EstructuraConvenioCarreraDTO dto) {
		return modelMapper.map(dto, EstructuraConvenioCarrera.class);
	}

	@Override
	public EstructuraConvenioCarreraDTO mapToDto(EstructuraConvenioCarrera domain) {
		return modelMapper.map(domain, EstructuraConvenioCarreraDTO.class);
	}

}
