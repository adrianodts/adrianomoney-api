CREATE TABLE lancamento(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(50) NOT NULL,
	data_vencimento DATE NOT NULL,
	data_pagamento DATE,
	valor DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(100),
	tipo VARCHAR(20) NOT NULL,
	codigo_categoria BIGINT(20) NOT NULL,
	codigo_pessoa BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
	FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa) 
VALUES ('Salário Mensal', '2018-08-13', null, 989.55, 'Premio de participação nos lucros', 'RECEITA', 5, 1);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa) 
VALUES ('Supermercado Mensal', '2018-08-01', '2018-08-13', 1001.14, 'Compra mensal supermercado', 'RECEITA', 3, 2);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa)  VALUES 
('Salário Mensal','2018-08-13',NULL,989.55,'Premio de participação nos lucros','RECEITA',5,1);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa)  VALUES 
('Supermercado Mensal','2018-08-01','2018-08-13',1001.14,'Compra mensal supermercado','RECEITA',3,2);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa) VALUES 
('Juros Bancários','2018-07-01','2018-08-01',15.00,'Juros referente a aplicação da poupança','RECEITA',6,1);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa) VALUES 
('Cinema','2018-08-10','2018-08-10',15.00,'Vingadores Guerra Infinita I','DESPESA',1,3);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa) VALUES 
('Barzinho','2018-08-05','2018-08-05',84.55,'Bar Marechal com a galera','DESPESA',1,1);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa) VALUES 
('MacDonalds','2018-08-05','2018-08-05',155.43,'Lanche com a familia','DESPESA',2,1);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa) VALUES 
('Girafas','2018-07-15','2018-08-15',155.43,'Almoço com as crianças','DESPESA',2,3);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa) VALUES 
('Farmacia','2018-08-10','2018-08-15',35.10,'Dipirona','DESPESA',4,1);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa) VALUES 
('Farmacia Hirata','2018-08-10','2018-08-10',21.67,'Lenço Umedecido','DESPESA',4,3);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa) VALUES 
('Aplicação CEF','2018-07-14','2018-08-14',100.00,'Aplicação salario poupança','RECEITA',6,1);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa)  VALUES 
('Tesouro Direto','2018-07-14','2018-08-14',700.00,'Aplicação Tesouro Direto','RECEITA',6,1);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa)  VALUES
('Reembolso','2018-07-14','2018-08-14',10.00,'Reembolso Ubber','RECEITA',6,1);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa) VALUES 
('Outras','2018-07-14','2018-08-14',1005.44,'Outras despesas não categorizadas','DESPESA',5,1);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa) VALUES 
('Outras','2018-07-14','2018-08-14',550.00,'Bahamas','DESPESA',5,1);

INSERT INTO lancamento (descricao,data_vencimento,data_pagamento,valor,observacao,tipo,codigo_categoria, codigo_pessoa) VALUES 
('Outras','2018-07-14','2018-08-14',33500.00,'Despesas não lançadas','DESPESA',5,1);
