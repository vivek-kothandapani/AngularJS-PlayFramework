# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table skus (
  id                        varchar(255) not null,
  name                      varchar(255),
  status                    varchar(255),
  price                     varchar(255),
  type                      varchar(255),
  features                  varchar(255),
  created_date              varchar(255),
  expiry_date               varchar(255),
  constraint pk_skus primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table skus;

SET FOREIGN_KEY_CHECKS=1;

