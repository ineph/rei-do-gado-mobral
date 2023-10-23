package api.mobral.reidogado.model;

import api.mobral.reidogado.DTO.FazendaDTO;
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
    @Column(name = "cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_fazenda")
    private String nomeFazenda;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cd_id_usuario")
    private UsuarioModel usuario;

}
