package org.example.DistributedCache;

import java.util.List;

public class DistributedCacheNodeImpl<K,V> implements DistributedCache<K,V>{
    private final List<DistributedCache<K,V>>nodes;
    private final int numberOfNodes;

    public DistributedCacheNodeImpl(List<DistributedCache<K,V>>nodes){
        this.nodes=nodes;
        this.numberOfNodes=nodes.size();
    }
    public int getNodeIndex(K key){
        return Math.abs(key.hashCode()) % numberOfNodes;
    }
    @Override
    public V getValue(K key) {
        return nodes.get(getNodeIndex(key)).getValue(key);
    }

    @Override
    public V removeKey(K key) {
        return nodes.get(getNodeIndex(key)).removeKey(key);
    }

    @Override
    public void putValue(K key, V value) {
        nodes.get(getNodeIndex(key)).putValue(key, value);
    }
}
