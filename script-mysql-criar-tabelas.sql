USE padaria;

CREATE TABLE endereco (
	codigo 	INT AUTO_INCREMENT PRIMARY KEY,
    cep 	VARCHAR(150),
    cidade 	VARCHAR(150),
    estado 	VARCHAR(150)
);

CREATE TABLE fornecedor (
	codigo			INT AUTO_INCREMENT PRIMARY KEY,
    nome			VARCHAR(150),
    telefone		VARCHAR(150),
    email			VARCHAR(150),
    codigo_endereco	INT,
    FOREIGN KEY(codigo_endereco) REFERENCES endereco(codigo)
);

CREATE TABLE produto (
	codigo				INT AUTO_INCREMENT PRIMARY KEY,
    descricao			VARCHAR(150),
    disponivel			BIT(1),
    valor				DECIMAL(10,2),
    codigo_fornecedor	INT,
    FOREIGN KEY (codigo_fornecedor) REFERENCES fornecedor(codigo)
);

CREATE TABLE funcionario (
	codigo	INT AUTO_INCREMENT PRIMARY KEY,
    nome	VARCHAR(150),
    cpf		VARCHAR(50),
    cargo	VARCHAR(150)
);

CREATE TABLE comanda (
	codigo	INT AUTO_INCREMENT PRIMARY KEY,
    pago	BIT(1),
    total	DECIMAL(10,2)    
);

CREATE TABLE comanda_produto(
	codigo_comanda 		INT,
    codigo_produto 		INT,
    quantidade_produto	INT,
    subtotal_produto	DECIMAL(10,2),
    codigo_funcionario	INT,
    PRIMARY KEY (codigo_comanda, codigo_produto),
    FOREIGN KEY (codigo_comanda) REFERENCES comanda (codigo),
    FOREIGN KEY (codigo_produto) REFERENCES produto(codigo),
    FOREIGN KEY (codigo_funcionario) REFERENCES funcionario (codigo)
);

CREATE TABLE forma_pagamento (
	codigo 		INT AUTO_INCREMENT PRIMARY KEY,
    descricao	VARCHAR(50)
);

CREATE TABLE comanda_pagamento (
	codigo_comanda 			INT,
    codigo_forma_pagamento	INT,
    valor					DECIMAL(10,2),
    PRIMARY KEY (codigo_comanda, codigo_forma_pagamento),
    FOREIGN KEY (codigo_comanda) REFERENCES comanda (codigo),
    FOREIGN KEY (codigo_forma_pagamento) REFERENCES forma_pagamento(codigo)    
);


-- INSERTS
-- Inserir um registro na tabela endereco e armazenar o ID
INSERT INTO endereco (cep, cidade, estado)
VALUES ('CEP1', 'Cidade1', 'Estado1');
SET @endereco_id = LAST_INSERT_ID();

-- Inserir um registro na tabela fornecedor e armazenar o ID
INSERT INTO fornecedor (nome, telefone, email, codigo_endereco)
VALUES ('Fornecedor1', 'Telefone1', 'email1', @endereco_id);
SET @fornecedor_id = LAST_INSERT_ID();

-- Inserir um registro na tabela produto e armazenar o ID
INSERT INTO produto (descricao, disponivel, valor, codigo_fornecedor)
VALUES ('Produto1', 1, 100.00, @fornecedor_id);
SET @produto_id = LAST_INSERT_ID();

-- Inserir um registro na tabela funcionario e armazenar o ID
INSERT INTO funcionario (nome, cpf, cargo)
VALUES ('Funcionario1', 'CPF1', 'Cargo1');
SET @funcionario_id = LAST_INSERT_ID();

-- Inserir um registro na tabela comanda e armazenar o ID
INSERT INTO comanda (pago, total)
VALUES (1, 500.00);
SET @comanda_id = LAST_INSERT_ID();

-- Inserir um registro na tabela comanda_produto e armazenar o ID
INSERT INTO comanda_produto (codigo_comanda, codigo_produto, quantidade_produto, subtotal_produto, codigo_funcionario)
VALUES (@comanda_id, @produto_id, 2, 200.00, @funcionario_id);
SET @comanda_produto_id = LAST_INSERT_ID();

-- Inserir um registro na tabela forma_pagamento e armazenar o ID
INSERT INTO forma_pagamento (descricao)
VALUES ('Forma de Pagamento1');
SET @forma_pagamento_id = LAST_INSERT_ID();

-- Inserir um registro na tabela comanda_pagamento
INSERT INTO comanda_pagamento (codigo_comanda, codigo_forma_pagamento, valor)
VALUES (@comanda_id, @forma_pagamento_id, 200.00);