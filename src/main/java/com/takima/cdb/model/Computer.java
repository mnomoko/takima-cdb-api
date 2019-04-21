package com.takima.cdb.model;

import lombok.*;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Computer {

  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(nullable=false)
  private String name;
  private Date introduced;
  private Date discontinued;

  @ManyToOne
  @RestResource(exported = false)
  private Company company;
}
