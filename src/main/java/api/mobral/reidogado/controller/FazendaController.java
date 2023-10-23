package api.mobral.reidogado.controller;

import api.mobral.reidogado.model.FazendaModel;
import api.mobral.reidogado.DTO.FazendaDTO;
import api.mobral.reidogado.DTO.FazendaInput;
import api.mobral.reidogado.repository.FazendaRepository;
import api.mobral.reidogado.model.UsuarioModel;
import api.mobral.reidogado.repository.UsuarioRepository;
import api.mobral.reidogado.service.FazendaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fazendas")
@RequiredArgsConstructor
public class FazendaController {

    private final FazendaRepository fazendaRepo;
    private final UsuarioRepository usuarioRepo;
    private final FazendaService fazendaService;

    @PostMapping
    @Transactional
    public ResponseEntity<FazendaModel> cadastrarFazenda(@RequestBody FazendaInput novaFazenda) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fazendaService.criarFazenda(novaFazenda));
    }

    @GetMapping(path = "/{idUsuario}")
    @Transactional
    public List<FazendaDTO> buscarFazendasUsuarios(@PathVariable Long idUsuario) {
        UsuarioModel usuarioModel = usuarioRepo.findById(idUsuario).orElseThrow(() -> new RuntimeException());
        return fazendaRepo.findByUsuario(usuarioModel).stream().map(fazenda -> new FazendaDTO(
                fazenda.getNomeFazenda(), fazenda.getUsuario()
        )).toList();
    }
}
