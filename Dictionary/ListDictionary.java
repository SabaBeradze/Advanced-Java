package advance_Java;

import java.util.*;
import java.util.stream.Stream;


  class ListDictionary <K,V>  implements Dictionary<K,V> {
    private List<K> keys;
    private List<V> values;
    public ListDictionary(List<K> keys, List<V> values) {
        this.keys =new LinkedList<>();
        this.values = new LinkedList<>();}
    public ListDictionary() {}
    @Override
    public Option<V> get(K key ){
        if(keys.contains(key)){
             return Option.some(values.get(keys.indexOf(key)));
        }
        return Option.none();
    }
    @Override
    public V get(K key, V defaultValue) {
        if(!this.keys.contains(key))
            return defaultValue;
        int index = this.keys.indexOf(key);
        return this.values.get(index);
    }

    @Override
    public boolean containsKey(K key) {
        return (keys.contains(key));
    }

    @Override
    public boolean put(K k, V v) {
        if (containsKey(k)){
            keys.add(k);
            values.add(v);
            return true;
        }return false;}

    @Override
    public boolean update(K k, V v) {
        if(containsKey(k)){
            values.set(keys.indexOf(k),v);
            return true;
        }return  false;
}

    @Override
    public void clear(K k) {
        if(containsKey(k)){
            values.remove(keys.indexOf(k));
            keys.remove(keys.indexOf(k));

        }
    }

    @Override
    public Stream<K> keyStream() {
        return  keys.stream();
    }

    @Override
    public Stream<V> valuesStream() {
        return values.stream();
    }

}

