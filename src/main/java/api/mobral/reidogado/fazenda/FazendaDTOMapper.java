package api.mobral.reidogado.fazenda;

import java.util.function.Function;

public class FazendaDTOMapper implements Function<Fazenda, FazendaDTO> {
    @Override
    public FazendaDTO apply(Fazenda fazenda){
        return new FazendaDTO(fazenda.getNome(), fazenda.getArea(), fazenda.getId());
    }
}
