package ec.edu.insteclrg.sig_api.service.general;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.general.TipoCertificadoLaboral;
import ec.edu.insteclrg.sig_api.dto.general.TipoCertificadoLaboralDTO;
import ec.edu.insteclrg.sig_api.persistence.general.TipoCertificadoLaboralPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class TipoCertificadoLaboralService extends GenericCrudServiceImpl<TipoCertificadoLaboral, TipoCertificadoLaboralDTO>{
	
	@Autowired
	private TipoCertificadoLaboralPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<TipoCertificadoLaboral> find(TipoCertificadoLaboralDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public TipoCertificadoLaboral mapToDomain(TipoCertificadoLaboralDTO dto) {
		return modelMapper.map(dto, TipoCertificadoLaboral.class);
	}

	@Override
	public TipoCertificadoLaboralDTO mapToDto(TipoCertificadoLaboral domain) {
		return modelMapper.map(domain, TipoCertificadoLaboralDTO.class);
	}
	

}
