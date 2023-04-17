public class MyLinkedList<E> implements MyList{
  private MyArrayList elements = new MyArrayList<E>();
  private Node<E> head;
  private Node<E> tail;
  private int size;
  MyLinkedList() {
    size = 0;
  }
  private class Node<E> {
    E val;
    Node next;
    public Node(E vaule) {
      val = vaule;
      next = null;
    }

  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public void add(Object item) {

  }

  @Override
  public void addAt(Object item, int index) {

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
    return null;
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
