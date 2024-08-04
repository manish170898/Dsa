package org.lld.conceptCoding.solid.dependencyInversion.bad;

// Classes should depend on interface rather than on other classes
public class MackBook {
    private WiredKeyboard keyboard;
    private WiredMouse mouse;

    public MackBook(WiredKeyboard keyboard, WiredMouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}
