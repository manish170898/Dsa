package org.lld.old.designPatterns.SingletonDP;

public class ScrabbleTest {
    public static void main(String[] args) throws InterruptedException {
        Singleton newInstance = Singleton.getInstance();
        System.out.println("ID:" + System.identityHashCode(newInstance));
        System.out.println(newInstance.getLetterList());
        System.out.println("player1: " + newInstance.getTiles(2));
        System.out.println(newInstance.getLetterList());


        Singleton newInstance2 = Singleton.getInstance();
        System.out.println("ID:" + System.identityHashCode(newInstance2));

    }
}
