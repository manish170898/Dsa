package org.lld.conceptCoding.designPatterns.observer.observable;

import org.lld.conceptCoding.designPatterns.observer.observer.StockObserver;

import java.util.ArrayList;
import java.util.List;

public class RVNLObservableImpl implements StockObservable {
    private final List<StockObserver> observerList = new ArrayList<>();
    private int stockPrice = 75;

    @Override
    public void add(StockObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(StockObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(StockObserver observer : observerList){
            observer.update();
        }
    }

    @Override
    public void setStock(Integer price) {
        if(price != stockPrice){
            stockPrice = price;
            notifyObservers();
        }
    }
    public int getStockPrice(){
        return stockPrice;
    }
}
