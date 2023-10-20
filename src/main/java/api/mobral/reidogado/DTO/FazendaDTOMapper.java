package api.mobral.reidogado.DTO;

import api.mobral.reidogado.DTO.FazendaDTO;
import api.mobral.reidogado.model.Fazenda;

import java.util.function.Function;

public class FazendaDTOMapper implements Function<Fazenda, FazendaDTO> {
    @Override
    public FazendaDTO apply(Fazenda fazenda){
        return new FazendaDTO(fazenda.getNome(), fazenda.getArea(), fazenda.getId());
    }
}
