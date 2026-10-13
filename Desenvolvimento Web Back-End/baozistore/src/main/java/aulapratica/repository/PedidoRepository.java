package aulapratica.repository;

import aulapratica.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Override
	<S extends Pedido> S save(S pedido);

	@Override
	List<Pedido> findAll();

	@Override
	Optional<Pedido> findById(Long id);

	@Override
	void deleteById(Long id);
}
