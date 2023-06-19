package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.common.exception.ApiException;
import ec.edu.insteclrg.sig_api.domain.administracion.Pais;
import ec.edu.insteclrg.sig_api.dto.administracion.PaisDTO;
import ec.edu.insteclrg.sig_api.persistence.administracion.PaisPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class PaisService extends GenericCrudServiceImpl<Pais, PaisDTO> {

	@Autowired
	private PaisPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Pais> find(PaisDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Pais mapToDomain(PaisDTO dto) {
		return modelMapper.map(dto, Pais.class);
	}

	@Override
	public PaisDTO mapToDto(Pais domain) {
		return modelMapper.map(domain, PaisDTO.class);
	}

	public Optional<Pais> buscarPorCodigo(String codigo) {
		Optional<Pais> entidad = repository.findByCodigo(codigo);
		if (entidad.isEmpty())
			throw new ApiException(String.format("Registro con código %s no existe en el sistema", codigo));
		return entidad;
	}

}
