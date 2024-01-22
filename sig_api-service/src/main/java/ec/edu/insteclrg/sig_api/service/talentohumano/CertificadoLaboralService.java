package ec.edu.insteclrg.sig_api.service.talentohumano;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.talentohumano.CertificadoLaboral;
import ec.edu.insteclrg.sig_api.dto.talentohumano.CertificadoLaboralDTO;
import ec.edu.insteclrg.sig_api.persistence.talentohumano.CertificadoLaboralPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class CertificadoLaboralService extends GenericCrudServiceImpl<CertificadoLaboral, CertificadoLaboralDTO> {

	@Autowired
	private CertificadoLaboralPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<CertificadoLaboral> find(CertificadoLaboralDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public CertificadoLaboral mapToDomain(CertificadoLaboralDTO dto) {
		return  modelMapper.map(dto, CertificadoLaboral.class);
	}

	@Override
	public CertificadoLaboralDTO mapToDto(CertificadoLaboral domain) {
		return modelMapper.map(domain, CertificadoLaboralDTO.class);
	}

}
