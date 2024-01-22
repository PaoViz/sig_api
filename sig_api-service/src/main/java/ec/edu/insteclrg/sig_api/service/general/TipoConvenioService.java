package ec.edu.insteclrg.sig_api.service.general;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.general.TipoConvenio;
import ec.edu.insteclrg.sig_api.dto.general.TipoConvenioDTO;
import ec.edu.insteclrg.sig_api.persistence.general.TipoConvenioPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;


@Service
public class TipoConvenioService extends GenericCrudServiceImpl<TipoConvenio, TipoConvenioDTO>{
	
	@Autowired
	private TipoConvenioPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<TipoConvenio> find(TipoConvenioDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public TipoConvenio mapToDomain(TipoConvenioDTO dto) {
		return modelMapper.map(dto, TipoConvenio.class);
	}

	@Override
	public TipoConvenioDTO mapToDto(TipoConvenio domain) {
		return modelMapper.map(domain, TipoConvenioDTO.class);
	}

}
