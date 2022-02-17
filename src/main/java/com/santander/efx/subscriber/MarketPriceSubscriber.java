package com.santander.efx.subscriber;

public interface MarketPriceSubscriber {
    void onMessage(String message);
}
