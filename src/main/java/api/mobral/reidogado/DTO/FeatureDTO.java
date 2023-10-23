package api.mobral.reidogado.DTO;

import lombok.Data;

import java.util.Map;

@Data
public class FeatureDTO {
    private String type;
    private Map<String, Object> properties;
    private GeometryDTO geometry;
}
