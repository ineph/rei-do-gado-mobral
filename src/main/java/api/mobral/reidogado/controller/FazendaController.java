package api.mobral.reidogado.controller;

import api.mobral.reidogado.model.FazendaModel;
import api.mobral.reidogado.DTO.FazendaDTO;
import api.mobral.reidogado.DTO.FazendaInput;
import api.mobral.reidogado.repository.FazendaRepository;
import api.mobral.reidogado.model.UsuarioModel;
import api.mobral.reidogado.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fazendas")
@RequiredArgsConstructor
public class FazendaController {

    private final FazendaRepository fazendaRepo;
    private final UsuarioRepository usuarioRepo;

    @PostMapping
    @Transactional
    public void cadastrarFazenda(@RequestBody FazendaInput novaFazenda) {

        UsuarioModel usuarioModel = usuarioRepo.findById(novaFazenda.cd_id_usuario().longValue()).orElseThrow(() -> new RuntimeException());

        FazendaModel fazenda = FazendaModel.builder()
                .nomeFazenda(novaFazenda.nome())
                .usuario(usuarioModel).build();

        fazendaRepo.save(fazenda);
    }

    @GetMapping(path = "/{idUsuarioFazenda}")
    @Transactional
    public List<FazendaDTO> buscarFazendasUsuarios(@PathVariable Long idUsuarioFazenda) {
        UsuarioModel usuarioModel = usuarioRepo.findById(idUsuarioFazenda).orElseThrow(() -> new RuntimeException());
        return fazendaRepo.findByUsuario(usuarioModel).stream().map(fazenda -> new FazendaDTO(
                fazenda.getNomeFazenda(), fazenda.getUsuario()
        )).toList();
    }
}
