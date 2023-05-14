public class MyHashTable<K, V> {
  private int M = 11: // default number of chains
  private int size;
  public MyHashTable () {

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
      return "{" + key + " " + value + "}";
    }
  }
  public MyHashTable(int M) {}
  private int hash (K key) {
    return 0;
  }
  public void put (K key, V wvalue) {

  }
  public V get (K key) {
    return;
  }
  public V remove(K key) {
    return;
  }
  public boolean contains(V value) {
    return true;
  }
  public K getKey(V value) {
    return;
  }
}
