package org.lld.conceptCoding.questions.HashMapInternals;

public class Entry <K,V>{
    public K key;
    public V value;
    public Entry next;
    Entry(K k, V v){
        key = k;
        value = v;
    }

}
