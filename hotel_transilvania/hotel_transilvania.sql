create database hotel_transilvania;
use hotel_transilvania;

create table quarto (
	idquarto int unsigned not null auto_increment primary key ,
    numero int not null,
    capacidade int,
    classificacao int,
    preco float
);

create table cliente (
	idcliente int unsigned not null auto_increment primary key,
    nome varchar(55),
    telefone_contato varchar(11),
    cpf varchar(15) not null unique,
    endereco varchar(55),
    idade int
);

create table funcionario (
	idfuncionario int unsigned not null auto_increment primary key,
    nome varchar(55),
    cargo varchar(55),
    salario float,
    datadenasc date
);

create table informacao_reserva (
	idreserva int unsigned not null auto_increment primary key,
    data_inicio_reserva date,
    data_fim_reserva date,
    idcliente int unsigned,
    constraint fk_idcliente_reserva foreign key (idcliente) references cliente(idcliente)
);

create table cartao_acesso (
	idcartao int unsigned not null auto_increment primary key,
    numero_cartao int not null unique,
    idquarto int unsigned,
    idreserva int unsigned,
    constraint fk_idquarto_cartao foreign key (idquarto) references quarto(idquarto),
    constraint fk_idreserva foreign key (idreserva) references informacao_reserva(idreserva)
);

create table reserva (
	idquarto int unsigned,
    idcartao int unsigned,
    constraint fk_idquarto_reserva foreign key (idquarto) references quarto(idquarto),
    constraint fk_idcartao foreign key (idcartao) references cartao_acesso(idcartao)
);

create table servico_funcionario (
    duracao_servico float,
    tipo_servico varchar(55),
    idfuncionario int unsigned,
    idcliente int unsigned, 
    constraint fk_idfuncionario foreign key (idfuncionario) references funcionario(idfuncionario),
    constraint fk_idcliente_servico foreign key (idcliente) references cliente(idcliente)
);