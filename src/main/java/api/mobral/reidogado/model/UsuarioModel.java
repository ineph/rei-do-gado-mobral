package api.mobral.reidogado.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioModel {

    @Id
    @Column(name = "cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

//    @OneToMany(mappedBy = "usuario")
//    private List<FazendaModel> fazendas;
}
