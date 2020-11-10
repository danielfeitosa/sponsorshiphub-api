package org.comfort.comfortapi.repository;

import org.comfort.comfortapi.model.Sponsor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SponsorRepository extends JpaRepository<Sponsor, Long>, JpaSpecificationExecutor<Sponsor> {

	Page<Sponsor> findByFirstName(String firstName, Pageable pageable);

}
