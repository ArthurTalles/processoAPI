create table if not exists tarefas(
    id int primary key,
    titulo varchar(255) not null,
    descricao varchar(255) not null,
    departamento_id int not null,
    prazo date not null,
    duracao int not null,
    pessoas_id int not null,
    finalizado boolean not null
    )