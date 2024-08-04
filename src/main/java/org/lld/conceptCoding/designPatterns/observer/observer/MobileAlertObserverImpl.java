package org.lld.conceptCoding.designPatterns.observer.observer;

import org.lld.conceptCoding.designPatterns.observer.observable.StockObservable;

public class MobileAlertObserverImpl implements StockObserver{
    private Integer phoneNUmber;
    StockObservable observable;

    public MobileAlertObserverImpl(Integer phoneNUmber, StockObservable observable) {
        this.phoneNUmber = phoneNUmber;
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Messege sent to" + phoneNUmber);
    }
}
