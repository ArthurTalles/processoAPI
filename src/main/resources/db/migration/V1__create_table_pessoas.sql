create table if not exists pessoas(
    id int primary key,
    nome varchar(255) not null,
    departamento_id int not null,
    lista_tarefas varchar
)