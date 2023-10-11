package api.mobral.reidogado.fazenda;

import jakarta.validation.constraints.NotBlank;

public record FazendaDTO<Usuario>(

        @NotBlank
        String nome,

        @NotBlank
        String area,

        @NotBlank
        Usuario usuario
) {
}
