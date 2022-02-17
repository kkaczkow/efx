package com.santander.efx.client;

import com.santander.efx.price.Price;

public interface PriceObserver {
    void updatePrice(Price price);
}
