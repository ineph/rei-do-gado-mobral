package api.mobral.reidogado.usuario;

import api.mobral.reidogado.usuario.DadosNovoUsuario;
import api.mobral.reidogado.usuario.Usuario;
import api.mobral.reidogado.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repo;

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody DadosNovoUsuario novoUsuario){
        repo.save(new Usuario(novoUsuario));
    }
}
