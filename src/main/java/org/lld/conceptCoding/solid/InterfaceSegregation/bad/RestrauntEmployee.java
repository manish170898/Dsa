package org.lld.conceptCoding.solid.InterfaceSegregation.bad;

//Interfaces should be such that client should not implement unnecessory functions they dont need to
public interface RestrauntEmployee {
    void washDish();
    void serveCustomers();
    void cookFood();
}
