package api.mobral.reidogado.controller;

import api.mobral.reidogado.fazenda.DadosNovaFazenda;
import api.mobral.reidogado.fazenda.Fazenda;
import api.mobral.reidogado.fazenda.FazendaRepository;
import api.mobral.reidogado.usuario.Usuario;
import api.mobral.reidogado.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fazendas")
@RequiredArgsConstructor
public class FazendaController {

    private final FazendaRepository fazendaRepo;
    private final UsuarioRepository usuarioRepo;

    @PostMapping
    @Transactional
    public void cadastrarFazenda(@RequestBody DadosNovaFazenda novaFazenda) {

        Usuario usuario = usuarioRepo.findById(novaFazenda.cd_id_usuario().longValue()).orElseThrow(() -> new RuntimeException());

        Fazenda fazenda = Fazenda.builder()
                .nome(novaFazenda.nome())
                .area(novaFazenda.area())
                .usuario(usuario).build();

        fazendaRepo.save(fazenda);
    }
}
