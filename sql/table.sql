create table addresses (
       lastname    varchar(200) not null,
       givenname   varchar(200) not null,
       phonenumber varchar(20),
       id	   integer primary key
);

create sequence seq_addresses_id start with 30;