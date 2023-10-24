package api.mobral.reidogado.service;

import api.mobral.reidogado.DTO.FazendaInput;
import api.mobral.reidogado.DTO.TalhaoAPIBody;
import api.mobral.reidogado.exception.CustomException;
import api.mobral.reidogado.externals.TalhaoManagerAPI;
import api.mobral.reidogado.model.FazendaModel;
import api.mobral.reidogado.model.UsuarioModel;
import api.mobral.reidogado.repository.FazendaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FazendaService {

    public final FazendaRepository fazendaRepository;
    public final UsuarioService usuarioService;
    public final TalhaoManagerAPI talhaoManagerAPI;

    FazendaService(FazendaRepository fazendaRepository, UsuarioService usuarioService, TalhaoManagerAPI tallhaoApi){
        this.fazendaRepository = fazendaRepository;
        this.usuarioService = usuarioService;
        this.talhaoManagerAPI = tallhaoApi;
    }

    public FazendaModel criarFazenda(FazendaInput fazenda){
        Optional<UsuarioModel> usuarioFazenda = usuarioService.getById(fazenda.cd_id_usuario());
        FazendaModel fazendaModel = new FazendaModel();
        if (usuarioFazenda.isPresent()){
            fazendaModel.setNomeFazenda(fazenda.nome());
            fazendaModel.setUsuario(usuarioFazenda.orElseThrow());
        } else {
            throw new CustomException("Usuario com id  "+fazenda.cd_id_usuario()+" não existe.", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        FazendaModel fazendaCriada = fazendaRepository.save(fazendaModel);
        this.criarTalhao(fazenda, fazendaCriada.getId());
        return fazendaCriada;
    }

    public void criarTalhao(FazendaInput fazenda, long idFazenda){
        TalhaoAPIBody talhaoBody = new TalhaoAPIBody(idFazenda, fazenda.geom());
        ObjectMapper objMap = new ObjectMapper();
        try {
            String talhaoJson = objMap.writeValueAsString(talhaoBody);
            talhaoManagerAPI.postNovoTalhao(talhaoJson);
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
