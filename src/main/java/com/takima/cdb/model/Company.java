package com.takima.cdb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Company {

  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(nullable=false)
  private String name;

  @OneToMany(mappedBy = "company") @JsonIgnore
  @RestResource(exported = false)
  private List<Computer> computers;
}
