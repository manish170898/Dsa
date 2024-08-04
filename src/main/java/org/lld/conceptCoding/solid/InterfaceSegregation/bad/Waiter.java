package org.lld.conceptCoding.solid.InterfaceSegregation.bad;

public class Waiter implements RestrauntEmployee {
//    Waiter only need to serveCustomer so we hace wrong interface here
    @Override
    public void washDish() {

    }

    @Override
    public void serveCustomers() {

    }

    @Override
    public void cookFood() {

    }
}
