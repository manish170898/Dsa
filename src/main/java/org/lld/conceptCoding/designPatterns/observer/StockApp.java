package org.lld.conceptCoding.designPatterns.observer;

import org.lld.conceptCoding.designPatterns.observer.observable.RVNLObservableImpl;
import org.lld.conceptCoding.designPatterns.observer.observable.StockObservable;
import org.lld.conceptCoding.designPatterns.observer.observer.EmailAlertObserverImpl;
import org.lld.conceptCoding.designPatterns.observer.observer.MobileAlertObserverImpl;
import org.lld.conceptCoding.designPatterns.observer.observer.StockObserver;

public class StockApp {
    public static void main(String[] args) {
        StockObservable RVNLstock = new RVNLObservableImpl();

        StockObserver mobileObserver = new MobileAlertObserverImpl(755524324,RVNLstock);
        StockObserver emailObserver = new EmailAlertObserverImpl("manish170898@mgial.com",RVNLstock);

        RVNLstock.add(mobileObserver);
        RVNLstock.add(emailObserver);

        RVNLstock.setStock(74);
    }
}
