package aulapratica.repository;

import aulapratica.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Override
    <S extends Cliente> S save(S entity);

    @Override
    void deleteById(Long aLong);

    @Override 
    List<Cliente> findAll();

    @Override 
    Optional<Cliente> findById(Long aLong);
}
