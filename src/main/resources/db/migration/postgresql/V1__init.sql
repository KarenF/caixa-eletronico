create table usuario(
id serial,
nome varchar(50),
valor numeric(10,2),
primary key (id));

create table caixa(
id serial,
usuario integer,
valor numeric(10,2),
primary key(id),
foreign key(usuario) references usuario(id)
);