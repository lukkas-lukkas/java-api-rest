create table patients(
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    phone varchar(100) not null unique,
    cpf varchar(100) not null,
    street varchar(100) not null,
    neighborhood varchar(100) not null,
    zipcode varchar(100) not null,
    city varchar(100) not null,
    state varchar(100) not null,
    complement varchar(100),

    primary key(id)
);