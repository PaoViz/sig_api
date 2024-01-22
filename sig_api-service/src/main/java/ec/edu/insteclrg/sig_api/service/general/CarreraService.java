package ec.edu.insteclrg.sig_api.service.general;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.common.exception.ApiException;
import ec.edu.insteclrg.sig_api.domain.general.Carrera;
import ec.edu.insteclrg.sig_api.dto.general.CarreraDTO;
import ec.edu.insteclrg.sig_api.persistence.general.CarreraPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class CarreraService extends GenericCrudServiceImpl<Carrera, CarreraDTO> {

	@Autowired
	private CarreraPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Carrera> find(CarreraDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Carrera mapToDomain(CarreraDTO dto) {
		return modelMapper.map(dto, Carrera.class);
	}

	@Override
	public CarreraDTO mapToDto(Carrera domain) {
		return modelMapper.map(domain, CarreraDTO.class);
	}

	public Optional<Carrera> buscarPorCodigo(String codigo) {
		Optional<Carrera> entidad = repository.findByCodigo(codigo);
		if (entidad.isEmpty())
			throw new ApiException(String.format("Registro con código %s no existe en el sistema", codigo));
		return entidad;
	}

}