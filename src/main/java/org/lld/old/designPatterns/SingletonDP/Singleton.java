package org.lld.old.designPatterns.SingletonDP;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Singleton {
    private static Singleton firstInstance = null;

    String [] scrabbleLetters = {"a","b","c","d","e","f","g","h","i","j"};

    private LinkedList<String> letterList = new LinkedList<String>(Arrays.asList(scrabbleLetters));

    static boolean firstThread = true;

    private Singleton(){}

    public static Singleton getInstance() throws InterruptedException {
        if(firstInstance == null){
            if(firstThread){
                firstThread = false;
                Thread.currentThread();
                Thread.sleep(1000);
            }
            synchronized (Singleton.class) {
                if(firstInstance == null){
                    firstInstance = new Singleton();
                    Collections.shuffle(firstInstance.letterList);
                }
            }
        }
        return firstInstance;
    }

    public LinkedList<String> getLetterList(){
        return firstInstance.letterList;
    }

    public LinkedList<String> getTiles(int noOfTiles){
        LinkedList<String> tilesToSend = new LinkedList<String>();

        for(int i=0; i<noOfTiles; i++){
            tilesToSend.add(firstInstance.letterList.remove(0));
        }
        return tilesToSend;
    }
}
