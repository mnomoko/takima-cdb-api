package com.takima.cdb.repository;

import com.takima.cdb.model.Computer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ComputerRepositoryTest {
  @Autowired
  private ComputerRepository computerRepository;

  @Test
  public void findByIdTest() {
    Optional<Computer> computer = computerRepository.findById(1l);
    Assert.assertTrue("computer is not found", computer.isPresent());
    Assert.assertEquals(computer.get().getName(), "MacBook Pro 15.4 inch");
    Assert.assertEquals(computer.get().getId().longValue(), 1L);
  }

  @Test
  public void saveComputer() {
    Computer computer = Computer.builder().name("Mamadou Corp.").build();
    computerRepository.save(computer);

    List<Computer> computers = computerRepository.findAll();
    Assert.assertEquals(computers.size(), 12);
  }

  @Test
  public void updateComputer() {
    Optional<Computer> computer = computerRepository.findById(1l);
    Assert.assertTrue("computer is not found", computer.isPresent());
    computer.get().setName("MacBook Pro 15.4 pouce");

    Computer savedComputer = computerRepository.save(computer.get());
    Assert.assertEquals(savedComputer.getName(), "MacBook Pro 15.4 pouce");
    Assert.assertEquals(savedComputer.getId().longValue(), 1L);
  }

  @Test
  public void deleteComputer() {
    List<Computer> computers = computerRepository.findAll();
    Assert.assertEquals(computers.size(), 11);

    computerRepository.deleteById(1l);

    computers = computerRepository.findAll();
    Assert.assertEquals(computers.size(), 10);
  }
}
