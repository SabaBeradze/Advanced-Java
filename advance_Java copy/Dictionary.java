package advance_Java;

import java.util.stream.Stream;

public interface Dictionary<K,V>{
    Option<V> get(K key);
    V get(K key, V defaultValue);
    boolean containsKey(K k);
    boolean put(K k,V v);
    boolean update(K k,V v);
    void clear(K k);
    Stream<K> keyStream();
    Stream <V> valuesStream();
}