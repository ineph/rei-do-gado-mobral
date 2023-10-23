package api.mobral.reidogado.DTO;

import jakarta.validation.constraints.NotBlank;

public record FazendaInput(

        @NotBlank
        String nome,

        @NotBlank
        Long cd_id_usuario) {

}

