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

CREATE TABLE reserva (
    idquarto INT UNSIGNED,
    num_cartao INT,  -- Agora apenas um atributo
    PRIMARY KEY (idquarto),   -- idquarto é a chave primária
    CONSTRAINT fk_idquarto_reserva FOREIGN KEY (idquarto) REFERENCES quarto(idquarto),
    CONSTRAINT fk_num_cartao FOREIGN KEY (num_cartao) REFERENCES cartao_acesso(numero_cartao)  -- Referencia numero_cartao da tabela cartao_acesso
);


create table servico_funcionario (
    duracao_servico float,
    tipo_servico varchar(55),
    idfuncionario int unsigned,
    idcliente int unsigned, 
    constraint fk_idfuncionario foreign key (idfuncionario) references funcionario(idfuncionario),
    constraint fk_idcliente_servico foreign key (idcliente) references cliente(idcliente)
);


INSERT INTO quarto (numero, capacidade, classificacao, preco) VALUES
(101, 2, 3, 150.00),
(102, 4, 4, 200.00),
(103, 1, 2, 120.00),
(104, 3, 5, 300.00);

-- Inserindo dados na tabela "cliente"
INSERT INTO cliente (nome, telefone_contato, cpf, endereco, idade) VALUES
('Drácula', '11987654321', '123.456.789-00', 'Castelo Transilvânia, nº 666', 540),
('Mavis', '11912345678', '987.654.321-00', 'Castelo Transilvânia, nº 666', 120),
('Johnny', '11987651234', '321.654.987-00', 'Nova Iorque, USA', 28),
('Frankenstein', '11999887766', '213.546.789-00', 'Monte Egípcio, nº 99', 400);

-- Inserindo dados na tabela "funcionario"
INSERT INTO funcionario (nome, cargo, salario, datadenasc) VALUES
('Wayne Lobisomem', 'Camareiro', 2500.00, '1975-05-10'),
('Murray Múmia', 'Recepcionista', 3200.00, '1900-01-15'),
('Griffin Invisível', 'Segurança', 2800.00, '1985-11-25'),
('Blobby', 'Limpeza', 2300.00, '1990-07-05');

-- Inserindo dados na tabela "informacao_reserva"
INSERT INTO informacao_reserva (data_inicio_reserva, data_fim_reserva) VALUES
('2024-09-20', '2024-09-25'), -- Drácula
('2024-09-22', '2024-09-28'), -- Mavis
('2024-09-23', '2024-09-27'), -- Johnny
('2024-09-24', '2024-09-30'); -- Frankenstein

-- Inserindo dados na tabela "cartao_acesso"
INSERT INTO cartao_acesso (numero_cartao) VALUES
(1001), -- Drácula
(1002), -- Mavis
(1003), -- Johnny
(1004); -- Frankenstein

-- Inserindo dados na tabela "reserva"
INSERT INTO reserva (idquarto, num_cartao) VALUES

('1', '1001'),
('2', '1002'),
('3', '1003'),
('4', '1004');


-- Inserindo dados na tabela "servico_funcionario"
INSERT INTO servico_funcionario (duracao_servico, tipo_servico, idfuncionario, idcliente) VALUES
(2.5, 'Limpeza de Quarto', 4, 1), -- Blobby limpando quarto do Drácula
(1.5, 'Entrega de Toalhas', 1, 2), -- Wayne entregando toalhas para Mavis
(3.0, 'Segurança 24h', 3, 3), -- Griffin protegendo Johnny
(2.0, 'Check-in', 2, 4); -- Murray fazendo check-in do Frankenstein
