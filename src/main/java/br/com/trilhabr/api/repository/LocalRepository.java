package br.com.trilhabr.api.repository;

import br.com.trilhabr.api.model.trilhabr.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {

    public boolean existsByIdFourSquare(String idFourSquare);

    public boolean existsByIdTripAdvisor(String idTripAdvisor);
}
