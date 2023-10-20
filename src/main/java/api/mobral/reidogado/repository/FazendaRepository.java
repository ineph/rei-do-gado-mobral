package api.mobral.reidogado.repository;

import api.mobral.reidogado.model.Fazenda;
import api.mobral.reidogado.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
    List<Fazenda> findByUsuario(Usuario usuario);
}
