package ec.edu.insteclrg.sig_api.service.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.sig_api.common.exception.ApiException;
import ec.edu.insteclrg.sig_api.domain.administracion.ModalidadContrato;

import ec.edu.insteclrg.sig_api.dto.administracion.ModalidadContratoDTO;

import ec.edu.insteclrg.sig_api.persistence.administracion.ModalidadContratoPersistence;

import ec.edu.insteclrg.sig_api.service.GenericCrudServiceImpl;

@Service
public class ModalidadContratoService extends GenericCrudServiceImpl<ModalidadContrato, ModalidadContratoDTO> {

	@Autowired
	private ModalidadContratoPersistence repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<ModalidadContrato> find(ModalidadContratoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public ModalidadContrato mapToDomain(ModalidadContratoDTO dto) {
		return modelMapper.map(dto, ModalidadContrato.class);
	}

	@Override
	public ModalidadContratoDTO mapToDto(ModalidadContrato domain) {
		return modelMapper.map(domain, ModalidadContratoDTO.class);
	}

	public Optional<ModalidadContrato> buscarPorCodigo(String codigo) {
		Optional<ModalidadContrato> entidad = repository.findByCodigo(codigo);
		if (entidad.isEmpty())
			throw new ApiException(String.format("Registro con código %s no existe en el sistema", codigo));
		return entidad;
	}

	
}
