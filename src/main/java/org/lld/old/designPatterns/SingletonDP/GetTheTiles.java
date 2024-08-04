package org.lld.old.designPatterns.SingletonDP;

public class GetTheTiles implements Runnable {
    @Override
    public void run() {
        try {
            Singleton newInstance = Singleton.getInstance();
            System.out.println("ID:" + System.identityHashCode(newInstance));
            System.out.println(newInstance.getLetterList());
            System.out.println("player1: " + newInstance.getTiles(2));
            System.out.println(newInstance.getLetterList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
