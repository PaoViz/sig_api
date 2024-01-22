package ec.edu.insteclrg.sig_api.service.vinculacion;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.vinculacion.ProyectoPracticas;
import ec.edu.insteclrg.sig_api.dto.vinculacion.ProyectoPracticasDTO;
import ec.edu.insteclrg.sig_api.persistence.vinculacion.ProyectoPracticasPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class ProyectoPracticasService extends GenericCrudServiceImpl<ProyectoPracticas, ProyectoPracticasDTO>{

	@Autowired
	private ProyectoPracticasPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<ProyectoPracticas> find(ProyectoPracticasDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public ProyectoPracticas mapToDomain(ProyectoPracticasDTO dto) {
		return modelMapper.map(dto, ProyectoPracticas.class);
	}

	@Override
	public ProyectoPracticasDTO mapToDto(ProyectoPracticas domain) {
		return modelMapper.map(domain, ProyectoPracticasDTO.class);
	}

}
