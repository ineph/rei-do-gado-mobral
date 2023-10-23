package api.mobral.reidogado.repository;

import api.mobral.reidogado.model.FazendaModel;
import api.mobral.reidogado.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FazendaRepository extends JpaRepository<FazendaModel, Long> {
    List<FazendaModel> findByUsuario(UsuarioModel usuarioModel);
}
