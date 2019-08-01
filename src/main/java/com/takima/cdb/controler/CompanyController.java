package com.takima.cdb.controler;

import com.takima.cdb.model.Company;
import com.takima.cdb.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "companies")
@RepositoryRestController
public class CompanyController {

  @Autowired
  private CompanyRepository companyRepository;

  public CompanyController() {}

  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody HttpEntity<PagedResources<?>> getCompanies(Pageable pageable, PagedResourcesAssembler assembler) {
    Page<Company> companies = companyRepository.findAll(pageable);

    return ResponseEntity.ok(assembler.toResource(companies));
  }
}
