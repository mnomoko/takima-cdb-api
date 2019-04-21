package com.takima.cdb.repository;

import com.takima.cdb.model.Company;
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
public class CompanyRepositoryTest {
  @Autowired
  private CompanyRepository companyRepository;

  @Test
  public void findByIdTest() {
    Optional<Company> company = companyRepository.findById(1l);
    Assert.assertTrue("company is not found", company.isPresent());
    Assert.assertEquals(company.get().getName(), "Apple Inc.");
    Assert.assertEquals(company.get().getId().longValue(), 1L);
  }

  @Test
  public void saveCompany() {
    Company company = Company.builder().name("Mamadou Corp.").build();
    companyRepository.save(company);

    List<Company> companies = companyRepository.findAll();
    Assert.assertEquals(companies.size(), 7);
  }

  @Test
  public void updateCompany() {
    Optional<Company> company = companyRepository.findById(1l);
    Assert.assertTrue("company is not found", company.isPresent());

    company.get().setName("Apple");
    Company savedCompany = companyRepository.save(company.get());
    Assert.assertEquals(savedCompany.getName(), "Apple");
    Assert.assertEquals(savedCompany.getId().longValue(), 1L);
  }

  @Test
  public void deleteCompany() {
    List<Company> companies = companyRepository.findAll();
    Assert.assertEquals(companies.size(), 6);

    companyRepository.deleteById(6l);

    companies = companyRepository.findAll();
    Assert.assertEquals(companies.size(), 5);
  }

}
