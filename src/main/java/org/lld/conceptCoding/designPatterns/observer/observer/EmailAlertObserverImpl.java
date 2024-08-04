package org.lld.conceptCoding.designPatterns.observer.observer;

import org.lld.conceptCoding.designPatterns.observer.observable.StockObservable;

public class EmailAlertObserverImpl implements StockObserver{
    String email;
    StockObservable observable;
    public EmailAlertObserverImpl(String email, StockObservable observable) {
        this.email = email;
        this.observable = observable;
    }
    @Override
    public void update() {
        System.out.println("Email sent to" + email);
    }
}
