package aulapratica.repository;

import aulapratica.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface ProdutoRepository  extends JpaRepository<Produto, Long> {

    @Override 
    <S extends Produto> S save(S entity);

    List<Produto> findByEstoqueTrue();

    @Override
    List<Produto> findAll();

    @Override
    java.util.Optional<Produto> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

}
