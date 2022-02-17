package com.santander.efx.price;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Adds 0.1% to Ask and subtracts 0.1% from Bid
 */
@Component
public class DemoCommissionPolicy implements CommisionPolicy {

    private static final BigDecimal ASK_FACTOR = new BigDecimal("1.001");
    private static final BigDecimal BID_FACTOR = new BigDecimal("0.999");

    @Override
    public Price apply(Price price) {
        return Price.builder()
                .id(price.getId())
                .instrumentName(price.getInstrumentName())
                .timestamp(price.getTimestamp())
                .ask(multiplyWithScale(price.getAsk(), ASK_FACTOR))
                .bid(multiplyWithScale(price.getBid(), BID_FACTOR))
                .build();
    }

    private BigDecimal multiplyWithScale(BigDecimal value, BigDecimal factor) {
        return value != null ? value.multiply(factor)
                .setScale(Price.SCALE, RoundingMode.HALF_EVEN) : BigDecimal.ZERO;
    }
}
