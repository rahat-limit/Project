public class MyLinkedList<E> implements MyList{
  private MyArrayList elements = new MyArrayList<E>();
  private class Node<E> {
    E val;
    Node previous;
    Node next;
    public Node(E v) {
      val = v;
      previous = null;
      next = null;
    }
  }
  private Node<E> head;
  private Node<E> tail;
  private int size;
  MyLinkedList() {
    size = 0;
  }



  @Override
  public int size() {
    /**
     * Method size that return length of array.
     * @return int.
     */
    return size;
  }

  @Override
  public boolean contains(Object o) {
    /**
     * Method contains that define is object exist in array.
     * @return boolean value.
     */
    return (indexOf(o) != -1 ? true : false);
  }

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

  private Node getNode(int index) {
    /**
     * Method getNde that return exact node by index.
     * @return Node.
     */
    isItem(index);
    Node toSearch;
    toSearch = this.head;
    while (index != 0) {
      toSearch = toSearch.next;
      index--;
    }
    return toSearch;
  }
  private void isItem(int index){
    /**
     * Method isItem that check is item exist in array.
     * @return null;
     */
    if(index < 0 || index>=size){
      throw new IndexOutOfBoundsException();
    }
  }
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
  private void newNode (E item) {
    /**
     * Method newNode that create a new node in class.
     * @return null;
     */
    Node<E> node = new Node<>(item);
    if (size == 0) {
      this.head = node;
    } else {
      node.previous = this.tail;
      this.tail.next = node;
    }
    this.tail = node;
  }
  public void addN(Object item, boolean notSave) {
    newNode((E) item);
    if (notSave) elements.add(item);
    size++;
  }

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

  @Override
  public void clear() {
    /**
     * Method clear that clear array and array size.
     */
    head = null;
    tail = null;
    size = 0;
  }

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

}
