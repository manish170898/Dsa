package org.lld.old.solid.dependencyInversion;

public class Desktop {
    private Monitor monitor;
    private QwertyKeyboard qwertyKeyboard;
    //Solution for abstraction, we generalize keyboard so we can pass any keyboard required
    // it can ew querty as well as a gaming keyboard.
    private Keyboard keyboard;
 // This is tight coupling veryn hard to test
    public Desktop() {
        this.monitor = new Monitor();
        this.qwertyKeyboard = new QwertyKeyboard();
    }

    // Partial SOlution without abstaraction of keyboard
    public Desktop(QwertyKeyboard qwertyKeyboard, Monitor monitor) {
        this.monitor = monitor;
        this.qwertyKeyboard = qwertyKeyboard;
    }
// more abstract injection of dependency
    public Desktop(Keyboard keyboard, Monitor monitor) {
        this.monitor = monitor;
        this.qwertyKeyboard = qwertyKeyboard;
    }
}

//SOlution
// to make it more loosely coupled

interface Keyboard{}
class Monitor{}
class QwertyKeyboard implements Keyboard{}
class GamingKeyboard implements Keyboard{}