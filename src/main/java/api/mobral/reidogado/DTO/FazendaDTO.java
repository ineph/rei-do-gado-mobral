package api.mobral.reidogado.DTO;

import jakarta.validation.constraints.NotBlank;

public record FazendaDTO<Usuario>(

        @NotBlank
        String nome,

        @NotBlank
        Usuario usuario
) {
}
