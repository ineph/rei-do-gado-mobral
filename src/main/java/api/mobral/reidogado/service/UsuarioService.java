package api.mobral.reidogado.service;

import api.mobral.reidogado.DTO.UsuarioRecordDto;
import api.mobral.reidogado.model.UsuarioModel;
import api.mobral.reidogado.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioModel criarusuario(UsuarioRecordDto usuario){
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(usuario.nome());
        return usuarioRepository.save(usuarioModel);
    }
}
