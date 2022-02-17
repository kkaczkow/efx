package com.santander.efx.price;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoCommissionPolicyTest {

    private BigDecimal ask = getAmount( 1.2499);
    private BigDecimal bid = getAmount(1.2561);
    private int id = 123;
    private String instrumentName = "abc";
    private long timestamp = 123L;
    private Price price = Price.builder()
            .id(id)
            .instrumentName(instrumentName)
            .timestamp(timestamp)
            .ask(ask)
            .bid(bid)
            .build();
    private CommisionPolicy commisionPolicy = new DemoCommissionPolicy();

    @Test
    void shouldModifyAsk() {
        // given - when
        Price result = commisionPolicy.apply(price);

        // then
        assertEquals(getAmount(1.2511), result.getAsk());
    }

    @Test
    void shouldModifyBid() {
        // given - when
        Price result = commisionPolicy.apply(price);

        // then
        assertEquals(getAmount(1.2548), result.getBid());
    }

    @Test
    void shouldApplyZero_WhenBidIsNull() {
        // given
        price = Price.builder()
                .id(id)
                .bid(null)
                .build();

        // when
        Price result = commisionPolicy.apply(price);

        // then
        assertEquals(BigDecimal.ZERO, result.getBid());
    }

    @Test
    void shouldApplyZero_WhenAskIsNull() {
        // given
        price = Price.builder()
                .id(id)
                .ask(null)
                .build();

        // when
        Price result = commisionPolicy.apply(price);

        // then
        assertEquals(BigDecimal.ZERO, result.getAsk());
    }

    @Test
    void shouldKeepOtherValuesNotChanged() {
        // given - when
        Price result = commisionPolicy.apply(price);

        // then
        assertEquals(instrumentName, result.getInstrumentName());
        assertEquals(timestamp, result.getTimestamp());
        assertEquals(id, result.getId());
    }


    private BigDecimal getAmount(double value) {
        return new BigDecimal(value).setScale(Price.SCALE, RoundingMode.HALF_EVEN);
    }
}