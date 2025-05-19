package br.com.UWbike.repository;

import br.com.UWbike.entity.Ancora;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AncoraRepository extends JpaRepository<Ancora,Long> {
}
