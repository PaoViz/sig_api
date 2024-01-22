package ec.edu.insteclrg.sig_api.service.general;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.domain.general.Cargo;
import ec.edu.insteclrg.sig_api.dto.general.CargoDTO;
import ec.edu.insteclrg.sig_api.persistence.general.CargoPersistence;
import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class CargoService extends GenericCrudServiceImpl<Cargo, CargoDTO>{
	
	@Autowired
	private CargoPersistence repository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Cargo> find(CargoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public Cargo mapToDomain(CargoDTO dto) {
		return modelMapper.map(dto, Cargo.class);
	}

	@Override
	public CargoDTO mapToDto(Cargo domain) {
		return modelMapper.map(domain, CargoDTO.class);
	}


}
