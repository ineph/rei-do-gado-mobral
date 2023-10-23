create table fazendas(
    cd_id serial not null primary key,
    nome_fazenda varchar(100) not null,
    cd_id_usuario int8 references usuarios(cd_id) not null
);