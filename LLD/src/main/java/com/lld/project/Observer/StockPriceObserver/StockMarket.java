package com.lld.project.Observer.StockPriceObserver;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class StockMarket {
    // CopyOnWriteArrayList: thread-safe for concurrent subscribe/unsubscribe during iteration
    private final CopyOnWriteArrayList<StockObserver> observers = new CopyOnWriteArrayList<>();
    private final Map<String, Double> prices = new HashMap<>();

    public void subscribe(StockObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(StockObserver observer) {
        observers.remove(observer);
    }

    // Push model: subject pushes old + new price — observer doesn't need to call back
    public void updatePrice(String ticker, double newPrice) {
        double oldPrice = prices.getOrDefault(ticker, 0.0);
        prices.put(ticker, newPrice);

        if (oldPrice != newPrice) {
            notifyObservers(ticker, oldPrice, newPrice);
        }
    }

    // Pull model alternative (for comparison):
    // Subject only notifies "something changed"; observer calls getPrice() to fetch
    public double getPrice(String ticker) {
        return prices.getOrDefault(ticker, 0.0);
    }

    private void notifyObservers(String ticker, double oldPrice, double newPrice) {
        for (StockObserver observer : observers) {
            // Subject respects each observer's declared interest — no useless calls
            if (observer.interestedIn(ticker)) {
                observer.onPriceUpdate(ticker, oldPrice, newPrice);
            }
        }
    }
}

