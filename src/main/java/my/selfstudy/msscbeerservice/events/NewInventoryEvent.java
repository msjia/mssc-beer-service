package my.selfstudy.msscbeerservice.events;

import lombok.NoArgsConstructor;
import my.selfstudy.msscbeerservice.web.model.BeerDto;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
