package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.administracion.EmpresaFormadora;
import ec.edu.insteclrg.sig_api.dto.administracion.EmpresaFormadoraDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.EmpresaFormadoraPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class EmpresaFormadoraService extends GenericCrudServiceImpl<EmpresaFormadora, EmpresaFormadoraDTO> {

	@Autowired
	private EmpresaFormadoraPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<EmpresaFormadora> find(EmpresaFormadoraDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public EmpresaFormadora mapToDomain(EmpresaFormadoraDTO dto) {
		return modelMapper.map(dto, EmpresaFormadora.class);
	}

	@Override
	public EmpresaFormadoraDTO mapToDto(EmpresaFormadora domain) {
		return modelMapper.map(domain, EmpresaFormadoraDTO.class);
	}
}
