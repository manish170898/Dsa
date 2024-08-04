package org.lld.conceptCoding.solid.singleResponsibilty.good;

import org.lld.conceptCoding.solid.singleResponsibilty.Marker;

public class InvoiceGood {
    Marker marker;
    int quantity;

    public InvoiceGood(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    // Single Resposibilty says class should have on reason to change
    public int calculateTotal() {
        return marker.price * this.quantity;
    }
}
