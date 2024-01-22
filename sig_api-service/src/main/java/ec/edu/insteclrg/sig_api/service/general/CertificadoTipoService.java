package ec.edu.insteclrg.sig_api.service.general;


import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.general.CertificadoTipo;
import ec.edu.insteclrg.sig_api.dto.general.CertifdicadoTipoDTO;
import ec.edu.insteclrg.sig_api.persistence.general.CertificadoTipoPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class CertificadoTipoService extends GenericCrudServiceImpl<CertificadoTipo, CertifdicadoTipoDTO> {

	@Autowired
	private CertificadoTipoPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<CertificadoTipo> find(CertifdicadoTipoDTO dto) {
		return repository.findById(dto.getId());
	}
	
	@Override
	public CertificadoTipo mapToDomain(CertifdicadoTipoDTO dto) {
		return modelMapper.map(dto, CertificadoTipo.class);
	}
		
		@Override
		public CertifdicadoTipoDTO mapToDto(CertificadoTipo domain) {
			return modelMapper.map(domain, CertifdicadoTipoDTO.class);
		}
}
