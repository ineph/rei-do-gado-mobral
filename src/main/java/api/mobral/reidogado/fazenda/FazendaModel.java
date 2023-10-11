package api.mobral.reidogado.fazenda;

import api.mobral.reidogado.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "fazendas")
@Entity(name = "Fazenda")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class FazendaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_id_usuario")
    private Usuario usuario;

    public FazendaModel(FazendaNewDTO fazenda) {
        this.nome = fazenda.nome();
        this.area = fazenda.area();
        this.usuario = new Usuario();
    }
}
