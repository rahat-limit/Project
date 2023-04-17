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
     * Method contains that define is object exist in array.
     * @return boolean value.
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
    if(index < 0 || index>=size){
      throw new IndexOutOfBoundsException();
    }
  }
  @Override
  public void addAt(Object item, int index) {
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

  @Override
  public boolean remove(Object item) {
    return false;
  }

  @Override
  public Object remove(int index) {
    return null;
  }

  @Override
  public void clear() {

  }

  @Override
  public Object get(int index) {
    if(index < 0 || index>=size){
      throw new IndexOutOfBoundsException();
    }
    return getNode(index).val;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public void sort() {

  }
}
