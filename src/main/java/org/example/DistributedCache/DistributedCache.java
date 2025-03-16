package org.example.DistributedCache;

public interface DistributedCache <K,V>{
    V getValue(K key);
    V removeKey(K key);
    void putValue(K key, V value);
}
