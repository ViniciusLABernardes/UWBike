package br.com.UWbike.repository;

import br.com.UWbike.entity.Patio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatioRepository extends JpaRepository<Patio,Long> {
}
