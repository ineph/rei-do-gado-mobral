package api.mobral.reidogado.DTO;


import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordDto(
        @NotBlank
        String nome
        ) {}
