package com.santander.efx.price;

public interface CommisionPolicy {
    Price apply(Price price);
}
