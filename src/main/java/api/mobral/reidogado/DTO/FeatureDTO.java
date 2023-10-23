package api.mobral.reidogado.DTO;

import java.util.Map;

public record FeatureDTO(
        String type,
        Map<String, Object> properties,
        GeometryDTO geometry
) {}
