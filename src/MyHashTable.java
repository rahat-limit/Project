import java.util.LinkedList;

public class MyHashTable<K, V> {
  private int M = 11;// default number of chains
  private int size;
  private LinkedList<HashNode<K, V>>[] chain;

  public MyHashTable() {
    chain = new LinkedList[M];
    size = 0;
  }
  public class HashNode<K, V> {
    private K key;
    private V value;
    public HashNode(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public K getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }

    public void setValue(V value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return key.toString() + " " + value.toString();
    }
  }
  private int hash (K key) {
    return key.hashCode() % M;
  }
  public int getSize() {
    return size;
  }
  public void put (K key, V value) {
    if (chain[hash(key)] == null){
      chain[hash(key)] = new LinkedList<HashNode<K, V>>();
    }
    for (HashNode<K, V> node: chain[hash(key)]){
      if(node.getKey().equals(key)){
        node.setValue(value);
        return;
      }
    }
    chain[hash(key)].add(new HashNode<K, V>(key, value));
    size++;
  }
  public V get (K key) {
    if (chain[hash(key)] == null) return null;

    for (HashNode<K, V> node: chain[hash(key)]){
      if(node.getKey().equals(key)) return node.getValue();
    }
    return null;
  }
  public V remove(K key) {
    if (chain[hash(key)] == null) return null;

    for (HashNode<K, V> node: chain[hash(key)]){
      if(node.getKey().equals(key)) {
        chain[hash(key)].remove(node);
        size--;
        return node.getValue();
      }
    }
    size--;
    return null;
  }
  public boolean contains(V value) {
    for(LinkedList<HashNode<K,V>> list: chain) {
      for(HashNode<K,V> node: list){
        if (node.getValue().equals(value)) return true;
      }
    }
    return false;
  }
  public K getKey(V value) {
    for(LinkedList<HashNode<K,V>> list: chain) {
      for(HashNode<K,V> node: list){
        if (node.getValue().equals(value)) return node.getKey();
      }
    }
    return null;
  }
}
