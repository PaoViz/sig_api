package ec.edu.insteclrg.sig_api.service;

import java.util.List;
import java.util.Optional;

public interface GenericCrudService<DOMAIN, DTO> {

	public DTO guardar(DTO dto);

	public DTO actualizar(DTO dto);

	public void eliminar(DTO dto);

	public abstract Optional<DOMAIN> buscar(DTO dto);

	public List<DTO> buscarTodo(DTO dto);

	DOMAIN mapToDomain(DTO dto);

	DTO mapToDto(DOMAIN domain);
}
