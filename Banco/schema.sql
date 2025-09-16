
PRAGMA foreign_keys = NO;

 -- Tabela usuario 
CREATE TABLE usuario(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    email TEXT NOT NULL,
    senha TEXT NOT NULL
);

-- Table cliente

CREATE TABLE cliente(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    telefone TEXT,
    usuario_id INTEGER NOT NULL UNIQUE,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);
-- Tabela produto
CREATE TABLE produto(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    descricao TEXT,
    preco REAL NOT NULL CHECK (preco >= 0)
);
CREATE TABLE venda(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    data TEXT NOT NULL,
    usuario_id INTEGER NOT NULL,
    cliente_id INTEGER NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) on DELETE SET NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id) on DELETE SET NULL
);

--Tabela venda produto tabela associativa para N:M produto <-> venda
CREATE TABLE venda_produto(
   id INTEGER PRIMARY KEY AUTOINCREMENT,
   venda_id INTEGER NOT NULL,
   produto_id INTEGER NOT NULL,
   quantidade INTEGER NOT NULL CHECK (quantidade > 0),
   preco_unitario REAL NOT NULL CHECK (preco_unitario >=0),
-- PRIMARY KEY (venda_id, produto_id),   
   FOREIGN KEY (venda_id)REFERENCES venda(id)ON DELETE CASCADE,
   FOREIGN KEY (protudo_id)REFERENCES produto(id)ON DELETE CASCADE,
);  
--Inserir usuario
INSERT INTO usuario(nome, email, senha)VALUES ('Matheus','Matheushv@unipam','leafar');
INSERT INTO usuario(nome, email, senha)VALUES ('Gustavo','gustavoteste@unipam','98982');

--Inserir cliente
INSERT INTO cliente(nome, telefone, usuario_id)VALUES ('Matheus Henrique','349966868',1);
INSERT INTO cliente(nome, telefone, usuario_id)VALUES ('Gustavo Moraes','87878979',2);

--Inserir Produto

INSERT INTO produto(nome, descricao, preco)VALUES ('Caixa de papelao','marrom',5.00);
INSERT INTO produto(nome, descricao, preco)VALUES ('Feijao 5KG','Faz o L',2.00);

--Inserir Venda

INSERT INTO venda(data, usuario_id, cliente_id)VALUES('2025-08-27', 1, 1);
INSERT INTO venda(data, usuario_id, cliente_id)VALUES('2025-08-28', 2, 2);

--Inserir venda_produto

INSERT INTO venda_produto(venda_id, produto_id, quantidade, preco_unitario)VALUES(1,1,3,5);
INSERT INTO venda_produto(venda_id, produto_id, quantidade, preco_unitario)VALUES(1,2,5,2);