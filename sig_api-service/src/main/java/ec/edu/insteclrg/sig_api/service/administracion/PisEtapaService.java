package ec.edu.insteclrg.sig_api.service.administracion;


import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.insteclrg.sig_api.domain.administracion.PisEtapa;
import ec.edu.insteclrg.sig_api.dto.administracion.PisEtapaDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.PisEtapaPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class PisEtapaService extends GenericCrudServiceImpl<PisEtapa, PisEtapaDTO> {

	@Autowired
	private PisEtapaPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();
	
    @Override
    public Optional<PisEtapa> find(PisEtapaDTO dto) {
    	return repository.findById(dto.getId());
    }

    @Override
    public PisEtapa mapToDomain(PisEtapaDTO dto) {
    	return modelMapper.map(dto, PisEtapa.class);
    }

	@Override
	public PisEtapaDTO mapToDto(PisEtapa domain) {
		return modelMapper.map(domain, PisEtapaDTO.class);
	}

}
