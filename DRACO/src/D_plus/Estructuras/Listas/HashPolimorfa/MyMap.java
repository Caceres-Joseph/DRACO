/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D_plus.Estructuras.Listas.HashPolimorfa; 
import D_plus.Estructuras.Listas.*;
import java.util.ArrayList;
import java.util.Iterator; 
import java.util.Map; 
import java.util.Set;
import java.util.TreeSet;
/**
 *
 * @author joseph
 */
class MyMap implements Map {

  protected ArrayList keys;

  protected ArrayList values;

  public MyMap() {
    keys = new ArrayList();
    values = new ArrayList();
  }


    /**
     * Return the number of mappings in this Map.
     */
    @Override
    public int size() {
        return keys.size();
    }

    /**
     * Return true if this map is empty.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Return true if o is contained as a Key in this Map.
     * @param o
     */
    @Override
    public boolean containsKey(Object o) {
        return keys.contains(o);
    }

    /**
     * Return true if o is contained as a Value in this Map.
     * @param o
     */
    
    
    @Override
    public boolean containsValue(Object o) {
        return keys.contains(o);
    }

    /**
     * Get the object value corresponding to key k.
     * @param k
     */
    @Override
    public Object get(Object k) {
        int i = keys.indexOf(k);
        if (i == -1) {
            return null;
        }
        return values.get(i);
    }

    /**
     * Put the given pair (k, v) into this map, by maintaining "keys" in sorted
     * order.
     *
     * @param k
     * @param v
     */
    @Override
    public Object put(Object k, Object v) {
        for (int i = 0; i < keys.size(); i++) {
            Object old = keys.get(i);

            /* Does the key already exist? */
            if (((Comparable) k).compareTo(keys.get(i)) == 0) {
                keys.set(i, v);
                return old;
            }

            /*
             * Did we just go past where to put it? i.e., keep keys in sorted order.
             */
            if (((Comparable) k).compareTo(keys.get(i)) == +1) {
                int where = i > 0 ? i - 1 : 0;
                keys.add(where, k);
                values.add(where, v);
                return null;
            }
        }

        // Else it goes at the end.
        keys.add(k);
        values.add(v);
        return null;
    }

    /**
     * Put all the pairs from oldMap into this map
     *
     * @param oldMap
     */
    @Override
    public void putAll(java.util.Map oldMap) {
        Iterator keysIter = oldMap.keySet().iterator();
        while (keysIter.hasNext()) {
            Object k = keysIter.next();
            Object v = oldMap.get(k);
            put(k, v);
        }
    }

    @Override
    public Object remove(Object k) {
        int i = keys.indexOf(k);
        if (i == -1) {
            return null;
        }
        Object old = values.get(i);
        keys.remove(i);
        values.remove(i);
        return old;
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public java.util.Set keySet() {
        return new TreeSet(keys);
    }

    @Override
    public java.util.Collection values() {
        return values;
    }

    @Override
    public Set entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 

    /**
     * The Map.Entry objects contained in the Set returned by entrySet().
     */
    private class MyMapEntry implements Map.Entry, Comparable {

        private Object key, value;

        MyMapEntry(Object k, Object v) {
            key = k;
            value = v;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object nv) {
            throw new UnsupportedOperationException("setValue");
        }

        @Override
        public int compareTo(Object o2) {
            if (!(o2 instanceof MyMapEntry)) {
                throw new IllegalArgumentException("Huh? Not a MapEntry?");
            }
            Object otherKey = ((MyMapEntry) o2).getKey();
            return ((Comparable) key).compareTo((Comparable) otherKey);
        }
    }
}
