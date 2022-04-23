CREATE TABLE tb_perfil(
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
NOME VARCHAR(255) NOT NULL);

CREATE TABLE tb_usuario(
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
EMAIL VARCHAR(255) NOT NULL,
SENHA VARCHAR(255) NOT NULL,
PERFIL_ID BIGINT NOT NULL,
FOREIGN KEY (perfil_id) REFERENCES tb_perfil(ID));