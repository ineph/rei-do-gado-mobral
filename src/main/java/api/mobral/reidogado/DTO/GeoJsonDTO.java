package api.mobral.reidogado.DTO;

import lombok.Data;
import java.util.List;

@Data
public class GeoJsonDTO {
    private String type;
    private List<FeatureDTO> features;
}
