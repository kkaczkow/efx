# Getting Started

### Reference
Santander Corporate & Investment Banking (FX)
Java Developer 2021 - Market Price Handler Exercise

### How to run

Execute following command:

```sh
./gradlew clean build & bootRun
```

### Example output

2022-02-17 14:04:23.607  INFO 20932 --- [           main] com.santander.efx.EfxApplication         : Started EfxApplication in 0.716 seconds (JVM running for 1.068)

2022-02-17 14:04:23.609  INFO 20932 --- [           main] com.santander.efx.DemoUseCase            : Processing price messages

2022-02-17 14:04:23.680  INFO 20932 --- [           main] c.s.e.s.MarketPriceSubscriberImpl        : Received a message: 106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001

2022-02-17 14:04:23.683  INFO 20932 --- [           main] c.s.e.s.MarketPriceSubscriberImpl        : Received a message: 107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002

2022-02-17 14:04:23.684  INFO 20932 --- [           main] c.s.e.s.MarketPriceSubscriberImpl        : Received a message: 108, GBP/USD, 1.2500,1.2560,01-06-2020 12:01:02:002

2022-02-17 14:04:23.684  INFO 20932 --- [           main] c.s.e.s.MarketPriceSubscriberImpl        : Received a message: 109, GBP/USD, 1.2499,1.2561,01-06-2020 12:01:02:100

2022-02-17 14:04:23.684  INFO 20932 --- [           main] c.s.e.s.MarketPriceSubscriberImpl        : Received a message: 110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110

2022-02-17 14:04:23.687  INFO 20932 --- [           main] com.santander.efx.DemoUseCase            : Getting the latest price for GBP/USD: Price(id=109, instrumentName=GBP/USD, bid=1.2487, ask=1.2574, timestamp=01-06-202012:01:02:100)

### Assumptions

1. Prices are held in BigDecimal and are having scale up to 4 digits.

2. Timestamps in the business logic are held in Unix time

3. The format of incoming messages is as follows: id, currency_pair, bid, ask, timestamp

4. Currency pair has format CUR1/CUR2

5. Timestamp in messages has dd-MM-yyyy HH:mm:ss:SSS format
