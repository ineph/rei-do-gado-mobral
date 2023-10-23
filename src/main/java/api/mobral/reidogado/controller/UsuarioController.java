package api.mobral.reidogado.controller;

import api.mobral.reidogado.DTO.UsuarioRecordDto;
import api.mobral.reidogado.model.UsuarioModel;
import api.mobral.reidogado.repository.UsuarioRepository;
import api.mobral.reidogado.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsuarioController {

    public final UsuarioService usuarioService;

    UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("usuarios")
    @Transactional
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody @Valid UsuarioRecordDto usuarioBody){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarusuario(usuarioBody));
    }

    @GetMapping("usuarios/{usuarioId}")
    public ResponseEntity<Object> getUsuariosById(@PathVariable(value = "usuarioId") Long usuarioId){
        Optional<UsuarioModel> usuarioModel = usuarioService.getById(usuarioId);
        if (usuarioModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario com id " + usuarioId + " não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getById(usuarioId));
    }
}
