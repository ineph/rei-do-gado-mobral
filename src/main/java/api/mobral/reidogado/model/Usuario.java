package api.mobral.reidogado.model;

import api.mobral.reidogado.DTO.DadosNovoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;

    public Usuario(DadosNovoUsuario usuario) {
        this.nome = usuario.nome();
        this.cpf = usuario.cpf();
    }
}
