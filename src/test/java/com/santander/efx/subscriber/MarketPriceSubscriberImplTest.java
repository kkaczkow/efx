package com.santander.efx.subscriber;

import com.santander.efx.client.PriceObserver;
import com.santander.efx.price.CommisionPolicy;
import com.santander.efx.price.Price;
import com.santander.efx.price.PriceFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MarketPriceSubscriberImplTest {

    @Mock private PriceObserver clientApi;
    @Mock private PriceFactory priceFactory;
    @Mock private CommisionPolicy commisionPolicy;
    @Mock private Price basePrice;
    @Mock private Price adjustedPrice;
    @InjectMocks private MarketPriceSubscriberImpl marketPriceSubscriber;

    @Test
    void onMessage() {
        // given
        String message = "anc";
        when(priceFactory.create(message)).thenReturn(basePrice);
        when(commisionPolicy.apply(basePrice)).thenReturn(adjustedPrice);

        // when
        marketPriceSubscriber.onMessage(message);

        // then
        verify(clientApi, times(1)).updatePrice(adjustedPrice);
    }
}