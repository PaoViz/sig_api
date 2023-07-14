package ec.edu.insteclrg.sig_api.service.administracion;



import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.insteclrg.sig_api.domain.administracion.GrupoOcupacional;
import ec.edu.insteclrg.sig_api.dto.administracion.GrupoOcupacionalDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.GrupoOcupacionalPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class GrupoOcupacionalService  extends GenericCrudServiceImpl<GrupoOcupacional, GrupoOcupacionalDTO> {

	@Autowired
	private GrupoOcupacionalPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<GrupoOcupacional> find(GrupoOcupacionalDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public GrupoOcupacional mapToDomain(GrupoOcupacionalDTO dto) {
		return modelMapper.map(dto, GrupoOcupacional.class);
	}

	@Override
	public GrupoOcupacionalDTO mapToDto(GrupoOcupacional domain) {
		return modelMapper.map(domain, GrupoOcupacionalDTO.class);
	}
	

}
