package com.takima.cdb.repository;

import com.takima.cdb.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {

  @Override
  @Query("select c from Computer c order by c.name")
  Page<Computer> findAll(Pageable pageable);
}
