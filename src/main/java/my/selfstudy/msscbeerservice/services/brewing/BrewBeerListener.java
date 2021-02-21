package my.selfstudy.msscbeerservice.services.brewing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.selfstudy.msscbeerservice.config.JmsConfig;
import my.selfstudy.msscbeerservice.domain.Beer;
import my.selfstudy.msscbeerservice.events.BrewBeerEvent;
import my.selfstudy.msscbeerservice.events.NewInventoryEvent;
import my.selfstudy.msscbeerservice.repository.BeerRepository;
import my.selfstudy.msscbeerservice.web.model.BeerDto;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent brewBeerEvent) {
        BeerDto beerDto = brewBeerEvent.getBeerDto();
        log.info("beerDto: " + beerDto);

        Beer beer = beerRepository.getOne(beerDto.getId());
        log.info("beer: " + beer);
        beerDto.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);

        log.debug("Brewed beer " + beer.getMinOnHand() + " : QOH: " + beerDto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }
}
