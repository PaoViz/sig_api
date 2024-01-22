package ec.edu.insteclrg.sig_api.service.investigacion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.investigacion.InvestigacionEvidencia;
import ec.edu.insteclrg.sig_api.dto.investigacion.InvestigacionEvidenciaDTO;
import ec.edu.insteclrg.sig_api.persistence.investigacion.InvestigacionEvidenciaPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class InvestigacionEvidenciaService extends GenericCrudServiceImpl<InvestigacionEvidencia, InvestigacionEvidenciaDTO>{
	
	@Autowired
	private InvestigacionEvidenciaPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<InvestigacionEvidencia> find(InvestigacionEvidenciaDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public InvestigacionEvidencia mapToDomain(InvestigacionEvidenciaDTO dto) {
		return modelMapper.map(dto, InvestigacionEvidencia.class);
	}

	@Override
	public InvestigacionEvidenciaDTO mapToDto(InvestigacionEvidencia domain) {
		return modelMapper.map(domain, InvestigacionEvidenciaDTO.class);
	}

}
