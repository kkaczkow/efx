package com.santander.efx.client;

import com.santander.efx.price.Price;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClientApiImpl implements ClientApi {

    //@RequestMapping(value = "/price//{instrumentName}", method = RequestMethod.PUT)
    public void updatePrice(Price price) {
        log.info("ClientApiImpl received price: {}", price);
    }
}
