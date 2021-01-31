package my.selfstudy.msscbeerservice.web.mappers;

import my.selfstudy.msscbeerservice.domain.Beer;
import my.selfstudy.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
