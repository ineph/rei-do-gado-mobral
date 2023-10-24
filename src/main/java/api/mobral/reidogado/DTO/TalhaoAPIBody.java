package api.mobral.reidogado.DTO;

public record TalhaoAPIBody(
        long cdIdFazenda,
        GeoJsonDTO geom
) {}
