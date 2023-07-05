package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.insteclrg.sig_api.common.exception.ApiException;
import ec.edu.insteclrg.sig_api.domain.administracion.Ciclo;
import ec.edu.insteclrg.sig_api.dto.administracion.CicloDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.CicloPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class CicloService extends GenericCrudServiceImpl<Ciclo, CicloDTO>{

	@Autowired
	private CicloPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Ciclo> find(CicloDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Ciclo mapToDomain(CicloDTO dto) {
		return modelMapper.map(dto, Ciclo.class);
	}

	@Override
	public CicloDTO mapToDto(Ciclo domain) {
		return modelMapper.map(domain, CicloDTO.class);
	}

}

