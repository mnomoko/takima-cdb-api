drop table if exists computer;
drop table if exists company;

create sequence company_seq start with 44 increment by 1;
create table company (
  id                        bigint default nextval('company_seq'),
  name                      varchar(255),
  constraint pk_company primary key (id))
;

create sequence computer_seq start with 575 increment by 1;
create table computer (
  id                        bigint default nextval('computer_seq'),
  name                      varchar(255),
  introduced                timestamp NULL,
  discontinued              timestamp NULL,
  company_id                bigint default NULL,
  constraint pk_computer primary key (id))
;

alter table computer add constraint fk_computer_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_computer_company_1 on computer (company_id);