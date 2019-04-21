package com.takima.cdb.config;

import com.takima.cdb.model.Company;
import com.takima.cdb.model.Computer;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

@Component
public class RestConfig implements RepositoryRestConfigurer {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.setBasePath("/api");
    config.setDefaultPageSize(20);
    config.exposeIdsFor(Company.class, Computer.class);
  }
}
