package api.mobral.reidogado.service;

import api.mobral.reidogado.DTO.FazendaDTO;
import api.mobral.reidogado.DTO.FazendaInput;
import api.mobral.reidogado.exception.CustomException;
import api.mobral.reidogado.model.FazendaModel;
import api.mobral.reidogado.model.UsuarioModel;
import api.mobral.reidogado.repository.FazendaRepository;
import api.mobral.reidogado.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FazendaService {

    public final FazendaRepository fazendaRepository;
    public final UsuarioService usuarioService;

    FazendaService(FazendaRepository fazendaRepository, UsuarioService usuarioService){
        this.fazendaRepository = fazendaRepository;
        this.usuarioService = usuarioService;
    }

    public FazendaModel criarFazenda(FazendaInput fazenda){
//        UsuarioModel usuarioFazenda = usuarioRepo.findById(novaFazenda.cd_id_usuario().longValue()).orElseThrow(() -> new RuntimeException());
        Optional<UsuarioModel> usuarioFazenda = usuarioService.getById(fazenda.cd_id_usuario());
        FazendaModel fazendaModel = new FazendaModel();
        if (usuarioFazenda.isPresent()){
            fazendaModel.setNomeFazenda(fazenda.nome());
            fazendaModel.setUsuario(usuarioFazenda.orElseThrow());
        } else {
            throw new CustomException("Usuario com id  "+fazenda.cd_id_usuario()+" não existe.", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return fazendaRepository.save(fazendaModel);
    }
}
