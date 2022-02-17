package com.santander.efx.provider;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.BaseStream;

@Service
public class CsvMarketPriceProvider implements MarketPriceProvider {

    @Override
    public Flux<String> getPrices() {
        return Flux.using(() -> Files.lines(Paths.get("src", "main","resources","messages.csv")),
                Flux::fromStream,
                BaseStream::close
        );
    }
}
