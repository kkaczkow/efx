package com.santander.efx.price;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * The assumption taken was taking price scale up to 4 digits.
 */
@ToString
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Price {
    public static int SCALE = 4;
    @NonNull
    private Integer id;
    private String instrumentName;
    private BigDecimal bid;
    private BigDecimal ask;
    private long timestamp;
}
