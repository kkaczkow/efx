package com.santander.efx.price;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceFactoryTest {

    private PriceFactory priceFactory = new PriceFactory();

    @Test
    void create() {
        // given
        int id = 110;
        String instrumentName = "EUR/JPY";
        String bid = "119.6100";
        String ask = "119.9100";
        String timestamp = "12:01:02:110";
        String priceMessage = id + ", " + instrumentName + ", " + bid + ", " + ask + ", " + timestamp;

        // when
        Price result = priceFactory.create(priceMessage);

        // then
        assertEquals(ask, result.getAsk().toString());
        assertEquals(bid, result.getBid().toString());
        assertEquals(id, result.getId());
        assertEquals(timestamp, result.getTimestamp());
        assertEquals(instrumentName, result.getInstrumentName());

    }
}