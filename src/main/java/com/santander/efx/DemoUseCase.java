package com.santander.efx;

import com.santander.efx.client.ClientApi;
import com.santander.efx.price.Price;
import com.santander.efx.provider.MarketPriceProvider;
import com.santander.efx.subscriber.MarketPriceSubscriber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Slf4j
@Component
@RequiredArgsConstructor
public class DemoUseCase {

    private final MarketPriceProvider priceProvider;
    private final MarketPriceSubscriber priceSubscriber;
    private final ClientApi clientApi;

    public void run() {
        processPriceMessages();
        logLatestPrice();
    }

    private void processPriceMessages() {
        log.info("Processing price messages");
        Flux<String> prices = priceProvider.getPrices();
        prices.doOnNext(priceSubscriber::onMessage)
                .blockLast();
    }

    private void logLatestPrice() {
        Price price = clientApi.getPrice("GBP/USD");
        log.info("Getting the latest price for GBP/USD: {}", price);
    }
}
