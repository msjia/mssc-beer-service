package my.selfstudy.msscbeerservice.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.selfstudy.msscbeerservice.web.model.BeerDto;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    static final long serialVersionUID = 3828308404885393061L;

    private BeerDto beerDto;
}
