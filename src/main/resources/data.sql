create table if not exists alunos
(
    id       int auto_increment,
    nome     varchar(50),
    telefone varchar(20),
    endereco varchar(50),
    primary key (id)
);
create table if not exists professores
(
    id   int auto_increment,
    nome varchar(50),
    primary key (id)
);
