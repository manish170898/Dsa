package org.lld.conceptCoding.solid.singleResponsibilty.bad;

import org.lld.conceptCoding.solid.singleResponsibilty.Marker;

public class InvoiceBad {
    Marker marker;
    int quantity;

    public InvoiceBad(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    // Single Resposibilty says class should have on reason to change
//    But nhere we have 3 reasons to change ... suppose we want to change calculate method in future ... also we want ot change printing method .. or save to multiple dbs s
//    we have 3 reason to change here
    public int calculateTotal(){
        return marker.price * this.quantity;
    }
    public void printInvoice(){

    }
    public void savetoDB(){

    }
}
