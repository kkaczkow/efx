package com.santander.efx.client;

import com.santander.efx.price.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientApiImplTest {

    @Mock private Price oldPrice;
    @Mock private Price newPrice;
    private String INSTRUMENT = "USD/GBP";
    private ClientApiImpl clientApi = new ClientApiImpl();

    @BeforeEach
    void setUp() {
        when(oldPrice.getInstrumentName()).thenReturn(INSTRUMENT);
        when(oldPrice.getTimestamp()).thenReturn(2222L);
        when(newPrice.getInstrumentName()).thenReturn(INSTRUMENT);
    }


    @Test
    void shouldUpdatePrice() {
        // given
        when(newPrice.getTimestamp()).thenReturn(3333L);
        clientApi.updatePrice(oldPrice);

        // when
        clientApi.updatePrice(newPrice);

        // then
        assertEquals(newPrice, clientApi.getPrice(INSTRUMENT));

    }

    @Test
    void shouldNotUpdatePrice() {
        // given
        when(newPrice.getTimestamp()).thenReturn(1111L);
        clientApi.updatePrice(oldPrice);

        // when
        clientApi.updatePrice(newPrice);

        // then
        assertEquals(oldPrice, clientApi.getPrice(INSTRUMENT));
    }
}