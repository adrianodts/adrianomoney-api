CREATE TABLE pessoa(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
	logradoro VARCHAR(100),
	numero VARCHAR(10),
	complemento VARCHAR(20),
	bairro VARCHAR(40),
	cep VARCHAR(9),
	cidade VARCHAR(40),
	estado VARCHAR(2),
	ativo BOOLEAN
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradoro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES 
('Adriano Dantas','Rua Augusto Montenegro','0067','TERREO','PARQUE EDU CHAVES','02230-050','São Paulo','SP',1);

INSERT INTO pessoa (nome, logradoro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES 
('Renata Parpinelli','Rua Servidão','1000','CASA 24','JD CUMBICA','01234-100','Guarulhos','SP',0);

INSERT INTO pessoa (nome, logradoro, numero, complemento, bairro, cep, cidade, estado, ativo) VALUES 
('Maria Josefina','Avenida Rui Barbosa','1001','Casa B','Centro','01234-567','Rio de Janeiro','RJ',1);

