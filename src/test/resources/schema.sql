drop schema if exists `myDb`;
create schema if not exists `myDb`;
use `myDb`;

-- drop table if exists computer;
-- drop table if exists company;

create table company (
  id                        bigint IDENTITY,
  name                      varchar(255),
  constraint pk_company primary key (id))
;

create table computer (
  id                        serial primary key,
  name                      varchar(255),
  introduced                timestamp NULL,
  discontinued              timestamp NULL,
  company_id                integer default NULL,
  constraint pk_computer primary key (id))
;