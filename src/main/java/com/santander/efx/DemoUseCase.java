package com.santander.efx;

import com.santander.efx.provider.MarketPriceProvider;
import com.santander.efx.subscriber.MarketPriceSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class DemoUseCase {

    private final MarketPriceProvider priceProvider;
    private final MarketPriceSubscriber priceSubscriber;

    public void run() {
        Flux<String> prices = priceProvider.getPrices();
        prices.doOnNext(priceSubscriber::onMessage)
                .blockLast();
    }
}
