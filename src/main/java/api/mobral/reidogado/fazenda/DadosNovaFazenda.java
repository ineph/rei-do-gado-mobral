package api.mobral.reidogado.fazenda;

import jakarta.validation.constraints.NotBlank;

public record DadosNovaFazenda(

        @NotBlank
        String nome,

        @NotBlank
        String area,

        @NotBlank
        Integer cd_id_usuario
) {
}
