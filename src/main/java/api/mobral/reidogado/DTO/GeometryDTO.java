package api.mobral.reidogado.DTO;

import java.util.List;

public record GeometryDTO(
        String type,
        List<List<List<Double>>> coordinates
) {}
