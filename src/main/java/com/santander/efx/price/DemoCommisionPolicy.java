package com.santander.efx.price;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Adds 0.1% to Ask and subtracts 0.1% from Bid
 */
@Component
public class DemoCommisionPolicy implements CommisionPolicy {

    @Override
    public Price apply(Price price) {
        return Price.builder()
                .id(price.getId())
                .instrumentName(price.getInstrumentName())
                .timestamp(price.getTimestamp())
                .ask(addPercentage(0.001, price.getAsk()))
                .bid(addPercentage(-0.001, price.getBid()))
                .build();
    }

    private BigDecimal addPercentage(double percentage, BigDecimal value) {
        return value.multiply(new BigDecimal(1.0d + percentage))
                .setScale(Price.SCALE, RoundingMode.HALF_EVEN);
    }
}
