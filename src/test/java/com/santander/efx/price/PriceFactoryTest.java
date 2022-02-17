package com.santander.efx.price;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceFactoryTest {

    private PriceFactory priceFactory = new PriceFactory();
    private int id = 110;
    private String instrumentName = "EUR/JPY";
    private String bid = "119.6100";
    private String ask = "119.9100";
    private String timestamp = "01-06-2020 12:01:02:110";
    private String priceMessage = id + ", " + instrumentName + ", " + bid + ", " + ask + ", " + timestamp;

    @Test
    void shouldReturnAsk() {
        // given

        // when
        Price result = priceFactory.create(priceMessage);

        // then
        assertEquals(ask, result.getAsk().toString());

    }

    @Test
    void shouldReturnBid() {
        // given

        // when
        Price result = priceFactory.create(priceMessage);

        // then
        assertEquals(bid, result.getBid().toString());

    }

    @Test
    void shouldReturnId() {
        // given

        // when
        Price result = priceFactory.create(priceMessage);

        // then
        assertEquals(id, result.getId());

    }

    @Test
    void shouldReturnTimestamp() {
        // given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");

        // when
        Price result = priceFactory.create(priceMessage);

        // then
        assertEquals(LocalDateTime.parse(timestamp, formatter)
                .toInstant(ZoneOffset.UTC)
                .toEpochMilli(), result.getTimestamp());

    }

    @Test
    void shouldReturnInstrumentName() {
        // given

        // when
        Price result = priceFactory.create(priceMessage);

        // then
        assertEquals(instrumentName, result.getInstrumentName());

    }
}