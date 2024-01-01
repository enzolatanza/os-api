package io.github.enzolatanza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.enzolatanza.domain.OS;

@Repository
public interface OSRepository extends JpaRepository<OS, Integer>{ //<Classe a ser manipulada, tipo primitivo do objeto identificador id é integer

}
