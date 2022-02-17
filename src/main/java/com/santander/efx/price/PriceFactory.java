package com.santander.efx.price;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class PriceFactory {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyyHH:mm:ss:SSS");

    public Price create(String priceMessage) {
        List<String> priceItems = Arrays.asList(priceMessage.replace(" ", "").split(","));
        return Price.builder()
                .id(Integer.valueOf(priceItems.get(0)))
                .instrumentName(priceItems.get(1))
                .bid(stringToAmount(priceItems.get(2)))
                .ask(stringToAmount(priceItems.get(3)))
                .timestamp(LocalDateTime.parse(priceItems.get(4), formatter)
                        .toInstant(ZoneOffset.UTC)
                        .toEpochMilli())
                .build();
    }

    private BigDecimal stringToAmount(String from) {
        return from != null && !from.isBlank() ?
                new BigDecimal(Double.valueOf(from)).setScale(Price.SCALE, RoundingMode.HALF_EVEN)
                : BigDecimal.ZERO;
    }
}
