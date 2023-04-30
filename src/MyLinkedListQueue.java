import java.util.NoSuchElementException;

public class MyLinkedListQueue<T> {
  MyLinkedList myLinkedList = new <T>MyLinkedList();

  MyLinkedListQueue() {}
  public void enqueue(T element) {
    myLinkedList.add(element);
  }

  public T dequeue() {
    return (T) myLinkedList.remove(0);
  }
  public int size() {
    return myLinkedList.size();
  }
}
