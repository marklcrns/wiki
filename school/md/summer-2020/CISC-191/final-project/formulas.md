---
title: Stock Portfolio Formulas
author: Mark Lucernas
date: 2020-07-04
summary: Final Project Stock Portfolio Formulas
---


# Final Project Stock Portfolio Formulas

Most of the sheets are "protected" to prevent unintended changes as most of the
cells are formula and formatting heavy.

To unprotect sheet to make cells clickable, right click the current "sheet"
then click "Unprotect Sheet..." or from the Ribbon menu, "Review" then
"Unprotect Sheet".

## Formulas

### Percent Change

  - Percent change from old value to new value


Formula 1: $\dfrac{\text{New Value} - \text{Old Value}}{\text{Old Value}}$

Formula 1: $\dfrac{\text{New Value}}{\text{Old Value}} - 1$

```java
// TODO:
// Java codes goes here
```

### Risk-to-Reward Ratio

  - Ratio between risk of entryPrice to targetPrice by entryPrice to
    stopLossPrice.
  - Ratio relative to 1. Very common and easier to understand
  - Aka P/L Ratio or profit-loss ratio


```java
double ratio = 1 / (entryPrice - stopLossPrice) / (targetPrice - entryPrice);
System.out.println("1 : " + ratio);
```

### Breakeven/Average Price

  - Stock price in the market that, if shares are to be sold, there would be no
    profit or loss. (exclusive of commissions).


The order DOES matter so I used `LinkedHashMap`
When partial of the open position, say 15 shares were bought for price of $20,
then 5 shares where sold for $24, the profit of $20 needs to be taken account
for the breakeven price. Reduce to total cost if profited, add if loss.

Formula: $\dfrac{\text{All Entries} - \text{All Exits} + (\text{-Profit or +Loss})}{\text{All Entry Shares} - \text{All Exit Shares}}$

```java
import java.util.HashMap;
import java.util.Map;

// Entry prices are positives, both entry and shares. Exit price are negatives
// Map<execPrice, numShares>
Map<Integer, Integer> executions = new HashMap<Integer, Integer>();
int total

// Loop over all Map entries or key/value pairs
for (Map.Entry<Integer, Integer> entry : executions.entrySet()) {
  // TODO: Formula
}
```

### Trade Cost

  - Cost of a given trade

Formula: $\text{Entry Price} \cdot \text{Entry Shares}$

```java
// TODO:
// Java codes goes here
```

### Trade Proceeds

  - Amount after closing some or all of open trades


Formula: $\text{Exit Price} \cdot \text{Exit Shares}$

```java
// TODO:
// Java codes goes here
```
### Trade Size

  - Size of the trade relative to current account value

Formula: $\dfrac{\text{Trade Cost}}{\text{Account Value}}$

```java
// TODO:
```

### Trade Risk

  - Potential trade risk relative to the trade cost


Formula: $\dfrac{\text{Stop Loss} - \text{Average Price}}{Average Price}$

```java
// TODO:
// Java codes goes here
```

### Account Risk

  - Potential trade risk relative to current account value


Formula: $(\text{Stop Loss} \cdot \text{Shares}) - \text{Trade Cost}$

```java
// TODO:
// Java codes goes here
```

### Profit/Loss

  - Trade profit


Formula: $(\text{Entry Price} \cdot \text{Shares}) - (\text{Exit Price} \cdot \text{Shares})$

```java
// TODO:
// Java codes goes here
```

### Realized P/L

  - Trade profit or loss that has been closed


Formula: $\text{Total Proceeds}$

```java
// TODO:
// Java codes goes here
```

### Net Realized P/L

  - Net trade profit or loss that has been closed


Formula: $\text{Realized P/L} - \text{Gross Cost} - \text{Commissions and Fees}$

```java
// TODO:
// Java codes goes here
```

### Account Percent Change

  - Percent change from the previous account value to current account value

Formula 1: $\dfrac{Net Realized P/L}{\text{Previous Account Value} - \text{Net Realized P/L}}$

Formula 2: $\dfrac{\text{New Account Value} - \text{Previous Account Value}}{\text{Previous Account Value}}$

```java
// TODO:
// Java codes goes here
```

## Glossary

| Term                   | Definition                                                                                                   |
|------------------------|--------------------------------------------------------------------------------------------------------------|
| Entry Price            | Buy or sell stock to open new trade                                                                          |
| Executed Price         | Refers to both entry and exit price                                                                          |
| Exit Price             | Buy or sell stock to exit trade                                                                              |
| Long Trade             | Entering trade by buying stock shares then closing by selling the same amount of shares                      |
| Price Filled           | Order price officially bought or sold at                                                                     |
| Realized Profit/Loss   | Trade profit or loss that has been closed                                                                    |
| Short Trade (Shorting) | Entering trade by borrowing or selling stock shares later to be returned by buying the same amount of shares |
| Stop Loss Price        | Trigger price to exit automatically once market price drops went up (if shorting) certain amount             |
| Unrealized Profit/Loss | Trade profit or loss that on paper or hasn't been closed and will likely change                              |

<br>

# Resources

