package com.santander.efx.provider;

import reactor.core.publisher.Flux;

public interface MarketPriceProvider {
    Flux<String> getPrices();
}
