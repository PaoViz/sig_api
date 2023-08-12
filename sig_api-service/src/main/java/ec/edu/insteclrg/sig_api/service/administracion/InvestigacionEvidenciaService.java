package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.insteclrg.sig_api.domain.administracion.InvestigacionEvidencia;
import ec.edu.insteclrg.sig_api.dto.administracion.InvestigacionEvidenciaDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.InvestigacionEvidenciaPersistence;
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
