package com.santander.efx.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.BaseStream;

@Slf4j
@Service
public class CsvMarketPriceProvider implements MarketPriceProvider {

    @Override
    public Flux<String> getPrices() {
        try {
            return Flux.using(() -> Files.lines(Paths.get("src", "main", "resources", "messages.csv")),
                    Flux::fromStream,
                    BaseStream::close
            );

        } catch (Exception ex) {
            log.error("Error while parsing messages", ex);
        }
        return Flux.empty();
    }
}
