package org.lld.conceptCoding.solid.dependencyInversion.good;

public class MacBook {
    Keyboard keyboard;
    Mouse mouse;

    public MacBook(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}
