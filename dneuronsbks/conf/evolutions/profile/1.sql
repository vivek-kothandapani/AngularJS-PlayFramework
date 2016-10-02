# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table account_info (
  account_id                varchar(255) not null,
  company_name              varchar(255),
  username                  varchar(255),
  password                  varchar(255),
  address_id                varchar(255),
  legal_info_id             varchar(255),
  entitlement_id            varchar(255),
  report_info_id            varchar(255),
  status                    varchar(255),
  role                      varchar(255),
  last_login                varchar(255),
  constraint pk_account_info primary key (account_id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table account_info;

SET FOREIGN_KEY_CHECKS=1;

