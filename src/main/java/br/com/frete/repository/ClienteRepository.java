package br.com.frete.repository;

import br.com.frete.doamin.cliente.Cliente;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCnpj (String cnpj);

    List<Cliente> findByNome(String nome, Sort sort);

}
