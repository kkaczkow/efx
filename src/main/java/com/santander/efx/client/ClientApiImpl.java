package com.santander.efx.client;

import com.santander.efx.price.Price;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class ClientApiImpl implements ClientApi, PriceObserver {

    private final Map<String, Price> prices = new ConcurrentHashMap<>();

    // GET REST method
    public Price getPrice(String instrument) {
        return prices.get(instrument);
    }

    public void updatePrice(Price price) {
        prices.put(price.getInstrumentName(), price);
        log.debug("Updated price: {}", price);
    }


}
