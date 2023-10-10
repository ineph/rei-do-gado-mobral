package api.mobral.reidogado.usuario;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosNovoUsuario(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String cpf
        ) {}
