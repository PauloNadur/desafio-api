package gft.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gft.entities.Starter;

@Repository
public interface StarterRepository extends JpaRepository<Starter, Long> {

	Page<Starter> findAll(Pageable pageable);

}
