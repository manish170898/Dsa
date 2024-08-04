package org.lld.conceptCoding.questions.HashMapInternals;

public class CustomHashMap<K,V> {
    public static final int INITIAL_CAPACITY = 1<<4;
    public static final int MAXIMUM_CAPACITY = 1<<30;

    public Entry[] hashTable;

    public CustomHashMap() {
        this.hashTable = new Entry[INITIAL_CAPACITY];
    }
    public CustomHashMap(int capacity) {
        int tableSize = tableSizeFor(capacity);
        this.hashTable = new Entry[tableSize];
    }

    private int tableSizeFor(int capacity) {
        int n = capacity-1;
        n |= n >>>1;
        n |= n >>>2;
        n |= n >>>4;
        n |= n >>>8;
        n |= n >>>16;
        return (n<0) ? 1 : (n>=MAXIMUM_CAPACITY)? MAXIMUM_CAPACITY : n+1;
    }

    public void put(K key, V value){
        int hashCode = key.hashCode() % hashTable.length;
//        int h;
//        int hashCode = (h = key.hashCode()) ^ (h>>>16);
        Entry node = hashTable[hashCode];
        Entry<K,V> newNode = new Entry<K,V>(key, value);
        if(node == null){
            hashTable[hashCode] = newNode;
        }
        else{
            Entry prevNode = node;
            while(node != null){
                if(node.key == key){
                    node.value = value;
                    return;
                }
                prevNode = node;
                node = node.next;
            }
            prevNode.next = newNode;
        }
    }

    public V get(K key){
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];
        while (node != null){
            if(node.key.equals(key)){
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

}
