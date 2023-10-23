package api.mobral.reidogado.DTO;

import java.util.List;

public record GeoJsonDTO(
        String type,
        List<FeatureDTO> features
) {}

