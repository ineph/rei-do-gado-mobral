package api.mobral.reidogado.fazenda;

import jakarta.validation.constraints.NotBlank;

public record FazendaInput(

        @NotBlank
        String nome,

        @NotBlank
        String area,

        @NotBlank
        Long cd_id_usuario) {

}

