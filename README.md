# Fourth Assignment Documentation
Welcome to my respository, which I created due to ADS lessons. Here you can easily find some tasks with their explanations. Hope you like it🤙
### Hash
 This is a function that takes a key and returns an index into the array that represents the hashtable. The goal of a good hash function is to evenly distribute the keys across the array to minimize collisions.
```java
  private int hash (K key) {
    return key.hashCode() % M;
  }
``` 
### getSize
 This function returns the number of key-value pairs currently stored in the hashtable.
```java
  public int getSize() {
    return size;
  }
``` 
### put
 This function takes a key-value pair and inserts it into the hashtable. It uses the hash function to compute the index where the pair should be stored. If there is already a pair with the same key in the hashtable, the value for that key is updated.
```java
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
``` 
### get
 This function takes a key and returns the corresponding value from the hashtable. It uses the hash function to compute the index where the value should be stored, and then looks for the key at that index. If the key is not found, get returns null (or some other sentinel value).
```java
  public V get (K key) {
    if (chain[hash(key)] == null) return null;

    for (HashNode<K, V> node: chain[hash(key)]){
      if(node.getKey().equals(key)) return node.getValue();
    }
    return null;
  }
``` 
### remove
This function takes a key and removes the corresponding key-value pair from the hashtable. It uses the hash function to compute the index where the pair should be stored, and then looks for the key at that index. If the key is found, the pair is removed and the function returns true. Otherwise, it returns false.
```java
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
``` 
### contains
 This function takes a key and returns true if the key is present in the hashtable, false otherwise. It uses the hash function to compute the index where the key should be stored, and then looks for the key at that index.
```java
  public boolean contains(V value) {
    for(LinkedList<HashNode<K,V>> list: chain) {
      for(HashNode<K,V> node: list){
        if (node.getValue().equals(value)) return true;
      }
    }
    return false;
  }
``` 
### getKey
 This function takes a value and returns the key that maps to that value in the hashtable. This function is not typically provided by standard hashtable implementations, as it requires iterating over all key-value pairs in the hashtable until the correct value is found.
```java
    public K getKey(V value) {
    for(LinkedList<HashNode<K,V>> list: chain) {
      for(HashNode<K,V> node: list){
        if (node.getValue().equals(value)) return node.getKey();
      }
    }
    return null;
  }
``` 
# Third Assignment Documentation
## Enqueue
### MyArrayListQueue
Add element in a queue
```java
  public void enqueue(T element) {
    myArrayList.add(element);
  }
```
### MyLikedListQueue
```java
  public void enqueue(T element) {
    myLinkedList.add(element);
  }
```
## Dequeue
Remove element from queue
### MyArrayListQueue
```java
  public T dequeue() {
    return (T) myArrayList.remove(0);
  }
```
### MyLikedListQueue
```java
  public T dequeue() {
    return (T) myLinkedList.remove(0);
  }
```
## Push
Add element to Stack.
### MyArrayListStack
Add element in a queue
```java
  public void push(T element) {
    myArrayList.add(element);
  }
```
### MyLinkedListStack
```java
  public void push(T element) {
    myLinkedList.add(element);
  }
```
## Pop
Remove element from Stack.
### MyArrayListQueue
```java
  public T pop() {
    isEmptyThrowException();
    return (T) myArrayList.remove(0);
  }
```
### MyLikedListQueue
```java
  public T pop() {
    isEmptyThrowException();
    return (T) myLinkedList.remove(0);
  }
```
## Size
Size of array queue
### MyArrayListQueue
```java
  public int size() {
    return myArrayList.size();
  }
```
### MyLikedListQueue
```java
  public int size() {
    return myLinkedList.size();
  }
```
### MyArrayListStack
```java
 public int size() {
    return myArrayList.size();
  }
```
### MyLinkedListStack
```java
  public int size() {
    return myLinkedList.size();
  }
```
## Peek
Get first element
### MyArrayListQueue
```java
  public T peek() throws NoSuchFieldException {
    isEmptyThrowException();
    return (T) myArrayList.get(0);
  }
```
### MyLikedListQueue
```java
  public T peek(){
    isEmptyThrowException();
    return (T) myLinkedList.get(0);
  }
```
### MyArrayListStack
```java
  public T peek() {
    isEmptyThrowException();
    return (T) myArrayList.get(0);
  }
```
### MyLinkedListStack
```java
  public T peek() {
    isEmptyThrowException();
    return (T) myLinkedList.get(0);
  }
```





# Second Assignment Documentation
## Main File Main.java [(source)](https://github.com/rahat-limit/lab-2/blob/master/src/Main.java/)
**All tasks in lab-2 works the same way. All you needed to uncomment Example lines and start project**
## ✖️ MyArrayList [(source)](https://github.com/rahat-limit/lab-2/blob/master/src/MyArrayList.java)
### Method GET:
Method get that provide exact item of array by index.
### Explanation:
Firstly, check by method isExist is object in array. Then, return item of array by index.
### Solution:
```java
  @Override
  public Object get(int index) {
    isExist(index);
    return arr[index];
  }
```
```java
  @Override
  public Object get(int index) {
    /**
     * Method get that returns the exact item from array.
     * @return Object.
     */
    if(index < 0 || index>=size){
      throw new IndexOutOfBoundsException();
    }
    return getNode(index).val;
  }
```
### Method SIZE:
Method size that return length of array.
### Explanation:
Simply return size of array.
### Solution:
```java
  @Override
  public int size() {
    return size;
  }
```
```java
  @Override
  public int size() {
    /**
     * Method size that return length of array.
     * @return int.
     */
    return size;
  }
```
### Method CONTAINS:
Method contains that define is object exist in array.
### Explanation:
Firstly, condition to check is array empty or not, after it goes through loop to define equal to given Object element. Then return Boolean value.
### Solution:
```java
  @Override
  public boolean contains(Object o) {
    if (arr.length == 0) return false;
    for (int i = 0; i < size; i++) {
      if (arr[i].equals(o)) return true;
    }
    return false;
  }
```
```java
  @Override
  public boolean contains(Object o) {
    /**
     * Method contains that define is object exist in array.
     * @return boolean value.
     */
    return (indexOf(o) != -1 ? true : false);
  }
```
### Method ADD:
Method add that add to array one object.
### Explanation:
Condition to check is free space in array, otherwise increase memory by method increaseBuffer. Then add to next element item. 
### Solution:
```java
  @Override
  public void add(Object item) {
    if(size == arr.length){
      increaseBuffer();
    }
    arr[size++] = (T)item;
  }
```
```java
  @Override
  public void add(Object item) {
    /**
     * Method add that that add to array addition object.
     * @return null;
     */
    Node<E> node = new Node<>((E) item);
    if (size == 0) {
      this.head = node;
    } else {
      this.tail.next = node;
    }
    this.tail = node;
    elements.add(item);
    size++;
  }
```
### Method ADDAT:
 Method addAt that add to aray one object at exact index.
### Explanation:
Condition to check is index relevant to array by method isExist. Condition to check is free space in array, otherwise increase memory by method increaseBuffer. Then by loop we replace each element by -1, from index to array length. 
### Solution:
```java
  @Override
  public void addAt(Object item, int index) {
    isExist(index);
    if (size == arr.length) {
      increaseBuffer();
    }
    for(int i = size; i>index; i--) {
      arr[i] = arr[i-1];
    }
    size++;
    arr[index] = (T) item;
  }
```
### Explanation:
Firstly, we throw error if index is not relevant. Than create new node and couple conditions to check equals of head, next and previous. Finally, add to array and increase size.
```java
  @Override
  public void addAt(Object item, int index) {
    /**
     * Method addAt that add to aray one object at exact index.
     * @return null;
     */
    if (index < 0 || index > size) throw new IndexOutOfBoundsException();
    Node oldNode = getNode(index);
    Node node = new Node<E>((E) item);
    if (this.head.equals(oldNode)) {
      node.next = this.head;
      this.head.previous = node;
      this.head = node;
    } else if (this.tail.equals(oldNode)){
      node.next = this.tail;
      node.previous = this.tail.previous;
      this.tail.previous.next = node;
      this.tail.previous = node;
    } else {
      node.previous = oldNode.previous;
      node.next = oldNode;
      oldNode.previous.next = node;
      oldNode.previous = node;
    }
    elements.add(item);
    size++;
  }
```
### Method REMOVE:
 Method remove that remove one object from array.
### Explanation:
Condition to check is item relevant to array by method contains. Then by indexOf we check is first occurence is >= 0. Then remove element and return true.
### Solution:
```java
  @Override
  public boolean remove(Object item) {
    if (!contains(item)) return false;
    if (indexOf(item) >= 0) {
      remove(indexOf(item));
      return true;
    }
    return false;
  }
```
```java
  @Override
  public boolean remove(Object item) {
    /**
     * Method remove that remove one object from array.
     * @return boolean value.
     */
    int index= indexOf(item);
    if (index >= 0) {
      remove(index);
      size--;
      size--;
      elements.remove(item);
      return true;
    }
    return false;
  }
```
### Method REMOVE:
Method removeAt that remove one oject from array by index.
### Explanation:
Condition to check is index relevant to array by method isExist. Then go through loop to replace each element from index to length of array. Finaly, remove and return element.  
### Solution:
```java
  @Override
  public Object remove(int index) {
    isExist(index);
    T item = arr[index];
    for(int i = index + 1; i <= size; i++) {
      arr[i-1] = arr[i];
    }
    size--;
    return item;
  }
```
```java
  @Override
  public Object remove(int index) {
    /**
     * Method removeAt that remove one oject from array by index.
     * @params item - removed element
     * @return removed object.
     */
    isItem(index);
    Node node = getNode(index);

    if (node.previous == null) {
      this.head = node.next;
      this.head.previous = null;
    }
    else if (node.next == null) {
      this.tail = node.previous;
      this.tail.next = null;
    }
    else {
      node.previous.next = node.next;
      node.next.previous = node.previous;
    }
    elements.remove(index);
    this.size--;
    return node.val;
  }
```
### Method CLEAR:
Method clear that clear array and array size.
### Explanation:
Simply clear array or replace our array with new empty data.
### Solution:
```java
  @Override
  public void clear(){
    this.arr = (T[]) new Object[5];
    this.size = 0;
  }
```
```java
  @Override
  public void clear() {
    /**
     * Method clear that clear array and array size.
     */
    head = null;
    tail = null;
    size = 0;
  }
```
### Method INDEXOF:
Method indexOf that returns the position of the first occurrence of specified character(s) in a string.
### Explanation:
Check by method contains is object in array list. Then by loop check eaual items to return index, otherwise return -1.
### Solution:
```java
  @Override
  public int indexOf(Object o) {
    if (!contains(o)) return -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals((T) o)) {
        return i;
      }
    }
    return -1;
  }
```
```java
@Override
  public int indexOf(Object o) {
    /**
     * Method indexOf that returns the position of the first occurrence of specified character(s) in a string.
     * @return int.
     */
    int i = 0;
    Node<E> nextNode = this.head;
    while (!nextNode.equals(null)) {
      if (this.head.val.equals(o)) return i;
      nextNode = nextNode.next;
      i++;
    }
    return -1;
  }
```
### Method LASTINDEXOF:
Method lastIndexOf that return the position of the last occurrence of specified character(s) in a string.
### Explanation:
Check by method contains is object in array list. Then by loop check equal items and i > index, to equal index = 1, then to return index. 
### Solution:
```java
  @Override
  public int lastIndexOf(Object o) {
    if (!contains(o)) return -1;
    int index = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals((T) o) && i > index){
        index = i;
      }
    }
    return index;
  }
```
```java
 @Override
  public int lastIndexOf(Object o) {
    /**
     * Method lastIndexOf that return the position of the last occurrence of specified character(s) in a string.
     * @return int.
     */
    int i = size()-1;
    Node<E> node = this.tail;
    while (i >= 0) {
      if (node.equals(o)) return i;
      node = this.tail.previous;
      i--;
    }
    return -1;
  }
```
### Method SORT:
Method sort that sort elements of a collection.
### Explanation:
We use nested loops, to check by conditions in order to swap elements with places, to get right sorted list.
### Solution:
```java
  @Override
  public void sort() {
    for(int i = 0; i < size; i++) {
      for (int d = i; d < size; d++) {
        if ((int) arr[d] < (int) arr[i]) {
          T item = arr[i];
          arr[i] = arr[d];
          arr[d] = item;
        }
      }
    }
  }
```
```java
  @Override
  public void sort() {
    /**
     * Method sort that sort elements of a collection.
     */
    Integer.valueOf((int) this.get(0));

    elements.sort();
    this.clear();
    for (int i = 0; i < elements.size(); i++) {
      this.addN(elements.get(i), false);
    }
  }
```
