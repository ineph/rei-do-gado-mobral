package api.mobral.reidogado.fazenda;

import api.mobral.reidogado.usuario.Usuario;
import api.mobral.reidogado.usuario.UsuarioRepository;
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

        Usuario usuario = usuarioRepo.findById(novaFazenda.cd_id_usuario().longValue()).orElseThrow(() -> new RuntimeException());

        Fazenda fazenda = Fazenda.builder()
                .nome(novaFazenda.nome())
                .area(novaFazenda.area())
                .usuario(usuario).build();

        fazendaRepo.save(fazenda);
    }

    @GetMapping(path = "/{idUsuarioFazenda}")
    @Transactional
    public List<FazendaDTO> buscarFazendasUsuarios(@PathVariable Long idUsuarioFazenda) {
        Usuario usuario = usuarioRepo.findById(idUsuarioFazenda).orElseThrow(() -> new RuntimeException());
        return fazendaRepo.findByUsuario(usuario).stream().map(fazenda -> new FazendaDTO(
                fazenda.getNome(), fazenda.getArea(), fazenda.getId()
        )).toList();
    }
}
