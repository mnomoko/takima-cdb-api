package com.takima.cdb.repository;

import com.takima.cdb.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company, Long> {

  @Override
  @Query("select c from Company c order by c.id")
  Page<Company> findAll(Pageable pageable);
}
