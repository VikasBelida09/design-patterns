package org.example.DistributedCache;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCacheNode <K, V> implements DistributedCache<K,V>{
    private final ConcurrentHashMap<K,V>store=new ConcurrentHashMap<>();
    private final Long nodeId;
    public InMemoryCacheNode(long nodeId){
        this.nodeId=nodeId;
    }
    @Override
    public V getValue(K key) {
        return store.get(key);
    }

    @Override
    public V removeKey(K key) {
        return store.remove(key);
    }

    @Override
    public void putValue(K key, V value) {
        store.put(key, value);
    }
}
