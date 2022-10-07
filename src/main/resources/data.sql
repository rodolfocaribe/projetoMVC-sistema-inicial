create table if not exists contatos
(
    id       int auto_increment,
    nome     varchar(50),
    telefone varchar(20),
    endereco varchar(50),
    primary key (id)
);
insert into contatos (nome, telefone, endereco)
VALUES ('Rodrigo Faro', '123456789', 'Rua dos Bobos, 40');
insert into contatos (nome, telefone, endereco)
VALUES ('Fernanda Lima', '987654321', 'Rua dos engraçados, 50');
insert into contatos (nome, telefone, endereco)
VALUES ('Fausto Silva', '123456789', 'Rua dos Bobos, 40');


create table if not exists professores
(
    id   int auto_increment,
    nome varchar(50),
    primary key (id)
);
insert into professores (nome)
VALUES ('Professor Girafales');
insert into professores (nome)
VALUES ('Professor Pardal');
insert into professores (nome)
VALUES ('Professor Raimundo');