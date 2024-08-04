package org.lld.conceptCoding.solid.openClosed.bad;

import org.lld.conceptCoding.solid.singleResponsibilty.good.InvoiceGood;


// now I have a requirement to save to files as well  .. I will create new method as save to File ... now this is bas as it does not follow
// OPen to extension closed to modification principal
public class InvoiceDaoBad {
    InvoiceGood invoiceGood;
    public InvoiceDaoBad(InvoiceGood invoiceGood) {
        this.invoiceGood = invoiceGood;
    }
    public void saveToDb(){

    }
    // Does not follow Open CLosed
    public void saveToFile(){

    }
}
