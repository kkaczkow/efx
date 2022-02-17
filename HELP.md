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

### Background
We would like to connect to a FX price feed of spot prices from the market. With each price, we want to modify it by applying a margin adjustment to each price (like commission). 

With the new price, we then want to make this available to clients/components so they can get the latest price for an instrument whenever they ask for it (history is not required).

You can imagine that there could be a UI to show this price to a real user, but in this exercise, you do not need to write a UI, typically a colleague would be working on this part.

The definition of a Price consists of unique id, instrument name, bid, ask and timestamp. You can assume that the Bid means the sell price (which is lower) and the Ask is the buy price (which is higher).

The market price feed will be given to you in CSV format line by line.

### Tasks

Use Java to write classes that implement a subscriber to process the feed and store the prices for the UI. Frameworks are optional. The focus is clear and concise code. 