package com.santander.efx.subscriber;

import com.santander.efx.client.ClientApiImpl;
import com.santander.efx.price.CommisionPolicy;
import com.santander.efx.price.Price;
import com.santander.efx.price.PriceFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MarketPriceSubscriberImpl implements MarketPriceSubscriber {

    private final ClientApiImpl clientApi;
    private final PriceFactory priceFactory;
    private final CommisionPolicy commisionPolicy;

    @Override
    public void onMessage(String message) {
        log.info("Received a message: {}", message);

        Price price = Optional.of(message)
                .map(priceFactory::create)
                .map(commisionPolicy::apply)
                .get();
        clientApi.updatePrice(price);
    }
}
