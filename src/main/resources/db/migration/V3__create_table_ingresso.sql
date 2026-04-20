CREATE TABLE ingresso (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    evento_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (evento_id) REFERENCES evento(id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);