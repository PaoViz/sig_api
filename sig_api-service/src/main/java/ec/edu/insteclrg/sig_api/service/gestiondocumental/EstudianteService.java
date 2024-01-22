package ec.edu.insteclrg.sig_api.service.gestiondocumental;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.gestiondocumental.Estudiante;
import ec.edu.insteclrg.sig_api.dto.gestiondocumental.EstudianteDTO;
import ec.edu.insteclrg.sig_api.persistence.gestiondocumental.EstudiantePersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class EstudianteService extends GenericCrudServiceImpl<Estudiante, EstudianteDTO>{

	@Autowired
	private EstudiantePersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<Estudiante> find(EstudianteDTO dto) {
		return repository.findById(dto.getId());
	}
	
	@Override
	public Estudiante mapToDomain(EstudianteDTO dto) {
		return modelMapper.map(dto, Estudiante.class);
	}
	
	@Override
	public EstudianteDTO mapToDto(Estudiante domain) {
		return modelMapper.map(domain, EstudianteDTO.class);
	}

}
