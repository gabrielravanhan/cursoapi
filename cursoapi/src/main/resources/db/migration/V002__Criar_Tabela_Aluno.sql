CREATE TABLE aluno (
    id BIGINT   NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nomealuno   VARCHAR(150),
    curso_id    INT NOT NULL
);

ALTER TABLE aluno ADD CONSTRAINT FK_aluno_curso FOREIGN KEY (curso_id) REFERENCES Curso(id);

INSERT INTO aluno(nomealuno, curso_id)
    VALUES('Rogério', 3),
    ('Luis Fabiano', 1),
    ('Rainara', 2),
    ('Gabriel', 3),
    ('Polly', 1),
    ('Kauany', 2),
    ('Vinicius', 3),
    ('Maria Eduarda', 2),
    ('Vitória', 4),
    ('Karen', 2),
    ('Santana', 4);