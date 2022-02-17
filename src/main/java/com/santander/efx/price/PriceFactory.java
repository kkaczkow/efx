package com.santander.efx.price;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

@Service
public class PriceFactory {
    public Price create(String priceMessage) {
        List<String> priceItems = Arrays.asList(priceMessage.replace(" ", "").split(","));
        return Price.builder()
                .id(Integer.valueOf(priceItems.get(0)))
                .instrumentName(priceItems.get(1))
                .bid(stringToAmount(priceItems.get(2)))
                .ask(stringToAmount(priceItems.get(3)))
                .timestamp(priceItems.get(4))
                .build();
    }

    private BigDecimal stringToAmount(String from) {
        return new BigDecimal(Double.valueOf(from)).setScale(Price.SCALE, RoundingMode.HALF_EVEN);
    }
}
