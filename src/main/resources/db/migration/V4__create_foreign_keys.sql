alter table pessoas
    add constraint fk_departamento_pessoa foreign key (departamento_id)
    references departamento(id);

alter table tarefas
    add constraint fk_departamento_tarefa foreign key (departamento_id)
    references departamento(id);

alter table tarefas
    add constraint fk_pessoa_tarefa foreign key (pessoas_id)
    references pessoas(id);