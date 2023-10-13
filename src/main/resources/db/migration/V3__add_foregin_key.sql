ALTER TABLE public.fazendas ADD cd_id_usuario int8 NOT NULL;

ALTER TABLE public.fazendas
    ADD CONSTRAINT fk_fazenda_usuario_id FOREIGN KEY (cd_id_usuario) REFERENCES usuarios (id);