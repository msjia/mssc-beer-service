package my.selfstudy.msscbeerservice.events;

import lombok.NoArgsConstructor;
import my.selfstudy.msscbeerservice.web.model.BeerDto;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }

}
