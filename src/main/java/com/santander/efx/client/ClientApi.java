package com.santander.efx.client;

import com.santander.efx.price.Price;

public interface ClientApi {
    Price getPrice(String instrument);
}
