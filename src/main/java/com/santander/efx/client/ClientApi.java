package com.santander.efx.client;

import com.santander.efx.price.Price;

public interface ClientApi {
    void updatePrice(Price newPrice);
}
