CREATE TABLE categoria(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria (nome) VALUES ('Lazer');
INSERT INTO categoria (nome) VALUES ('Alimentação');
INSERT INTO categoria (nome) VALUES ('Supermercado');
INSERT INTO categoria (nome) VALUES ('Farmacia');
INSERT INTO categoria (nome) VALUES ('Outros');
INSERT INTO categoria (nome) VALUES ('Aplicação poupança');
INSERT INTO categoria (nome) VALUES ('Sem categoria');
INSERT INTO categoria (nome) VALUES ('Educação');
INSERT INTO categoria (nome) VALUES ('Educação');
INSERT INTO categoria (nome) VALUES ('Despesas fixas');
INSERT INTO categoria (nome) VALUES ('Despesas Domésticas');
