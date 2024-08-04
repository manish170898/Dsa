package org.lld.conceptCoding.designPatterns.observer.observable;

import org.lld.conceptCoding.designPatterns.observer.observer.StockObserver;

import java.util.List;

public interface StockObservable {
    void add(StockObserver observer);
    void remove(StockObserver observer);
    void notifyObservers();
    void setStock(Integer price);
}
