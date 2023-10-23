package api.mobral.reidogado.DTO;

import api.mobral.reidogado.model.FazendaModel;

import java.util.function.Function;

public class FazendaDTOMapper implements Function<FazendaModel, FazendaDTO> {
    @Override
    public FazendaDTO apply(FazendaModel fazenda){
        return new FazendaDTO(fazenda.getNomeFazenda(), fazenda.getId());
    }
}
